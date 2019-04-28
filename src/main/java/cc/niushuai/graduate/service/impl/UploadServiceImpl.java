package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.service.UploadService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 附件管理类   此处此类需要整合fastdfs进行分布式文件管理
 *
 * @author 牛帅
 * @class_name UploadServiceImpl
 * @email niushuai951101@gmail.com
 * @date 2018-9-12  下午5:17:11
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private ThumbImageConfig thumbImageConfig;
    @Autowired
    private FastFileStorageClient fastDFSClient;

    @Override
    public StorePath imageUpload(MultipartFile file) {
        StorePath storePath = null;
        try {
            //获取文件大小
            Long fileSize = file.getSize();
            //限制图片大小
            if (fileSize > 2 * 1024 * 1024) {
                throw new Exception("图片过大");
            }
            //获取源文件名
            String fileName = file.getOriginalFilename();
            //获取源文件类型  不带.
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            //此处需要过滤文件类型  待添加

            //保存源文件字节流
            storePath = fastDFSClient.uploadImageAndCrtThumbImage(file.getInputStream(), fileSize, fileType, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("GG思密达");
        }
        return storePath;
    }


    @Override
    public void imageDestroy(String path) {
        fastDFSClient.deleteFile(path);
        fastDFSClient.deleteFile(createThumbImagePath(path));
    }

    @Override
    public StorePath fileUpload(MultipartFile file) {
        StorePath storePath = null;
        //获取文件大小
        Long fileSize = file.getSize();

        //获取源文件名
        String fileName = file.getOriginalFilename();
        //获取源文件类型   不带.
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        //此处需要过滤文件类型  待添加
        try {
            storePath = fastDFSClient.uploadFile(file.getInputStream(), fileSize, fileType, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storePath;
    }

    @Override
    public void fileDestroy(String path) {
        fastDFSClient.deleteFile(path);
    }


    private String createThumbImagePath(String path) {
        StringBuffer buffer = new StringBuffer();
        String[] arr = path.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 2) {
                buffer.append(arr[i] + thumbImageConfig.getPrefixName());
                buffer.append(".");
                continue;
            }
            buffer.append(arr[i]);
            buffer.append(".");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

}
