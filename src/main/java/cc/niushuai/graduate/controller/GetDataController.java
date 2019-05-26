package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.EnumMessage;
import cc.niushuai.graduate.commons.utils.ConstantMethod;
import cc.niushuai.graduate.commons.utils.EnumBean;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.entity.admin.Commpara;
import cc.niushuai.graduate.entity.admin.File;
import cc.niushuai.graduate.service.CommparaService;
import cc.niushuai.graduate.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/getData")
public class GetDataController {
    @Autowired
    private CommparaService commparaService;
    @Autowired
    private FileService fileService;

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
