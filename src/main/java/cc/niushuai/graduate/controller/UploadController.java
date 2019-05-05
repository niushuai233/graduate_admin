package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.utils.EditorMdResult;
import cc.niushuai.graduate.commons.utils.PathUtil;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.service.UploadService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传入口
 *
 * @author niushuai
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    /**
     * 配合editor.md使用的图片上传
     *
     * @return
     */
    @RequestMapping("/eImageUpload")
    public EditorMdResult eImageUpload(@RequestParam(value = "editormd-image-file") MultipartFile file) {

        try {
            StorePath storePath = uploadService.imageUpload(file);
            String fullPath = storePath.getFullPath();
            String fillFdfsPath = PathUtil.fillFdfsPath(fullPath);

            return EditorMdResult.ok(fillFdfsPath);
        } catch (Exception e) {
            log.error("上传文件失败：{}", e.getMessage());
            return EditorMdResult.error("上传失败");
        }
    }

    /**
     * 通用图片上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/imageUpload")
    public ResultUtil imageUpload(MultipartFile file) {

        try {
            StorePath storePath = uploadService.imageUpload(file);
            return ResultUtil.ok(storePath.getFullPath());
        } catch (Exception e) {
            log.error("图片上传失败: {}", e.getMessage());
            return ResultUtil.error("图片上传失败");
        }
    }


}
