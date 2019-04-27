package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.EnumMessage;
import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.commons.utils.ConstantMethod;
import cc.niushuai.graduate.commons.utils.EnumBean;
import cc.niushuai.graduate.commons.utils.FileUtil;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.entity.admin.Commpara;
import cc.niushuai.graduate.entity.admin.File;
import cc.niushuai.graduate.entity.admin.SysOss;
import cc.niushuai.graduate.service.CommparaService;
import cc.niushuai.graduate.service.FileService;
import cc.niushuai.graduate.service.SysOssService;
import cn.hutool.core.date.DateUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;


@RestController
@RequestMapping("/getData")
public class GetDataController {
    @Autowired
    private CommparaService commparaService;
    @Autowired
    private FileService fileService;
    @Autowired
    private SysOssService ossService;

    /**
     * @param
     * @author niushuai
     * @Description 通过枚举获取数据列表
     * @date date 2017-7-20
     */
    @ResponseBody
    @RequestMapping("/getEnum")
    public ResultUtil getEnum(@RequestParam Map<String, Object> params) throws Exception {
        List<EnumBean> values = new ArrayList<>();
        String enumName = (String) params.get("enumName");
        if (enumName != null && !"".equals(enumName)) {
            Class clzz = null;
            try {
                clzz = Class.forName(ConstantMethod.PACKAGE_NAME + "." + enumName);
                Method method = clzz.getMethod("values");
                EnumMessage[] inter = (EnumMessage[]) method.invoke(new Object[]{}, new Object[]{});
                for (EnumMessage enumMessage : inter) {
                    EnumBean e = new EnumBean();
                    e.setCode(enumMessage.getCode());
                    e.setValue(enumMessage.getValue());
                    values.add(e);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return ResultUtil.ok().put("data", values);
    }

    /**
     * @param
     * @author niushuai
     * @Description 通过表码获取数据列表
     * @date date 2017-7-20
     */
    @ResponseBody
    @RequestMapping("/getCodeValues")
    public ResultUtil getCodeValues(@RequestParam Map<String, Object> params) {
        List<Commpara> sysCodeList = null;
        if (params.get("codeName") != null && !"".equals(params.get("codeName"))) {
            sysCodeList = commparaService.getCodeValues(params);
        }
        return ResultUtil.ok().put("data", sysCodeList);
    }

    /**
     * @param
     * @author niushuai
     * @Description oss文件上传
     * @date date 2017-7-20
     */
    public String uploadImage(String fileName, InputStream inputStream) {
        //获取oss
        Map<String, Object> params = new HashMap<>();
        params.put("state", StateEnum.ENABLE.getCode());
        List<SysOss> ossList = ossService.getList(params);
        if (ossList != null && ossList.size() > 0) {
            SysOss oss = ossList.get(0);
            String fileNameBak = fileName;
            String resultImgUrl = oss.getUrl();
            String endpoint = oss.getEndpoint();
            String accessKeyId = oss.getAccessKeyId();
            String accessKeySecret = oss.getAccessKeySecret();
            String bucket = oss.getBucket();
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            if (!ossClient.doesBucketExist(bucket)) {
                ossClient.createBucket(bucket);
            }

            ObjectMetadata objectMeta = new ObjectMetadata();//oss属性设置
            //objectMeta.setContentLength(inputStream.getSize());//标记长度
            objectMeta.setContentType("image/jpeg");// 可以在metadata中标记文件类型
            try {
                //获取上传的图片文件名
                Long nanoTime = System.nanoTime();// 防止文件被覆盖，以纳秒生成图片名
                String _extName = fileName.substring(fileName.indexOf("."));//获取扩展名
                fileName = nanoTime + _extName;
                fileName = DateUtil.format(new Date(), "yyyyMMdd") + "/" + fileName + "/" + fileNameBak;
                ossClient.putObject(bucket, fileName, inputStream, objectMeta);
                resultImgUrl += fileName;
            } catch (Exception e) {
                e.printStackTrace();
                throw new MyException("上传失败");
            } finally {
                ossClient.shutdown();
            }
            return resultImgUrl;
        }
        throw new MyException("未启用oss配置");


    }

    /**
     * layui文件上传
     */
    @ResponseBody
    @RequestMapping("/upload")
    public ResultUtil upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new MyException("上传文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        String _extName = fileName.substring(fileName.indexOf("."));//获取扩展名

        if (file.getSize() > 1 * 1024 * 1024) {
            throw new MyException("图片不能大于1M");
        }
        //上传文件
        String url = uploadImage(file.getOriginalFilename(), file.getInputStream());
        //String url = "/static/statics/img/timg.jpg";
        return ResultUtil.ok().put("url", url);
    }

    /**
     * Hupload上传文件
     */
    @ResponseBody
    @RequestMapping("/uploads")
    public ResultUtil uploads(@RequestParam("uploadFile") MultipartFile[] file, HttpServletRequest request) throws Exception {

        if (file[0].isEmpty()) {
            throw new MyException("上传文件不能为空");
        }
        String fileName = file[0].getOriginalFilename();
        String _extName = fileName.substring(fileName.indexOf("."));//获取扩展名
        Long size = file[0].getSize();
//        if (size > 1 * 1024 * 1024) {
//            throw new MyException("图片不能大于1M");
//        }

        //上传文件
        String url = uploadImage(file[0].getOriginalFilename(), file[0].getInputStream());
        //存到本地文件
        //String url = "/static/statics/img/timg.jpg";
        String relationId = request.getParameter("relationId");
        File uploadFile = new File();
        uploadFile.setUploadId(relationId);
        uploadFile.setFileName(fileName);
        uploadFile.setFileSize(size.toString());
        uploadFile.setCreateTime(new Date());
        uploadFile.setUrl(url);
        //获取文件类型
        boolean isPicture = FileUtil.isPicture(fileName);
        if (isPicture) {
            uploadFile.setFileType("image");
        } else {
            uploadFile.setFileType(_extName);
        }
        fileService.save(uploadFile);

        return ResultUtil.ok().put("url", url).put("fileId", uploadFile.getId());
    }


    /**
     * Hupload文件回填
     **/
    @ResponseBody
    @RequestMapping("/getFile/{relationId}")
    public ResultUtil getFile(@PathVariable("relationId") String relationId) {
        List<File> list = fileService.getByRelationId(relationId);
        return ResultUtil.ok().put("fileList", list);
    }

    /**
     * Hupload删除上传文件
     */
    @ResponseBody
    @RequestMapping("/deleteFile/{fileId}")
    public ResultUtil uploadFile(@PathVariable("fileId") String fileId) throws Exception {
        fileService.delete(fileId);
        return ResultUtil.ok();
    }

    /**
     * Hupload删除文件
     */
    @ResponseBody
    @RequestMapping("/deleteByRelationId/{relationId}")
    public ResultUtil deleteByRelationId(@PathVariable("relationId") String relationId) throws Exception {
        fileService.deleteByRelationId(relationId);
        return ResultUtil.ok();
    }


}
