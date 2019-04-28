/**
 *
 */
package cc.niushuai.graduate.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import org.springframework.web.multipart.MultipartFile;

/**
 * @class_name UploadService
 * @author 牛帅
 * @email niushuai951101@gmail.com
 * @date 2018-9-12  下午5:10:21
 */
public interface UploadService {

    /**
     * 上传图片并制作缩略图保存服务器，存储数据库记录
     * @param file
     */
    StorePath imageUpload(MultipartFile file);

    /**
     * 销毁图片及缩略图
     * @param path
     */
    void imageDestroy(String path);

    /**
     * 上传文件
     * @param file
     */
    StorePath fileUpload(MultipartFile file);

    /**
     * 销毁附件
     * @param path
     */
    void fileDestroy(String path);

}
