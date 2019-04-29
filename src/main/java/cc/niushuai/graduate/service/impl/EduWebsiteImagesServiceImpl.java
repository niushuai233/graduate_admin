package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteImages;
import cc.niushuai.graduate.mapper.EduWebsiteImagesMapper;
import cc.niushuai.graduate.service.EduWebsiteImagesService;
import cc.niushuai.graduate.service.UploadService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Slf4j
@Service("eduWebsiteImagesService")
@Transactional
public class EduWebsiteImagesServiceImpl extends BaseServiceImpl<EduWebsiteImages> implements EduWebsiteImagesService {
    @Autowired
    private EduWebsiteImagesMapper eduWebsiteImagesMapper;
    @Autowired
    private UploadService uploadService;

    @Override
    public EduWebsiteImages get(Integer imageId) {
        return eduWebsiteImagesMapper.get(imageId);
    }

    @Override
    public List<EduWebsiteImages> getList(Map<String, Object> map) {
        return eduWebsiteImagesMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduWebsiteImagesMapper.getCount(map);
    }

    @Override
    public void save(EduWebsiteImages eduWebsiteImages) {
        super.addValue(eduWebsiteImages, false, 0);
        eduWebsiteImagesMapper.save(eduWebsiteImages);
    }

    @Override
    public void update(EduWebsiteImages eduWebsiteImages) {
        super.addValue(eduWebsiteImages, false, 1);
        eduWebsiteImagesMapper.update(eduWebsiteImages);
    }

    @Override
    public void delete(Integer imageId) {
        destoryImageBeforeDel(new Integer[]{imageId});
        eduWebsiteImagesMapper.delete(imageId);
    }

    /**
     * 在删除之前先删除图片
     *
     * @param imageIds
     */
    private void destoryImageBeforeDel(Integer[] imageIds) {
        try {
            for (Integer imageId : imageIds) {
                EduWebsiteImages eduWebsiteImages = get(imageId);
                String imageUrl = eduWebsiteImages.getImageUrl();
                uploadService.imageDestroy(imageUrl);
            }
        } catch (Exception e) {
            log.error("删除图片出现异常, {}", e.getMessage());
        }
    }

    @Override
    public void deleteBatch(Integer[] imageIds) {

        destoryImageBeforeDel(imageIds);
        eduWebsiteImagesMapper.deleteBatch(imageIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduWebsiteImages eduWebsiteImages = get(id);
            eduWebsiteImages.setState(Integer.valueOf(stateValue));
            update(eduWebsiteImages);
        }
    }

    @Override
    public StorePath uploadImage(MultipartFile file) {
        return uploadService.imageUpload(file);
    }

}
