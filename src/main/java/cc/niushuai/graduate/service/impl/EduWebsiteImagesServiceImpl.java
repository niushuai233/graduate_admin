package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteImages;
import cc.niushuai.graduate.mapper.EduWebsiteImagesMapper;
import cc.niushuai.graduate.service.EduWebsiteImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("eduWebsiteImagesService")
@Transactional
public class EduWebsiteImagesServiceImpl implements EduWebsiteImagesService {
    @Autowired
    private EduWebsiteImagesMapper eduWebsiteImagesMapper;

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
        eduWebsiteImagesMapper.save(eduWebsiteImages);
    }

    @Override
    public void update(EduWebsiteImages eduWebsiteImages) {
        eduWebsiteImagesMapper.update(eduWebsiteImages);
    }

    @Override
    public void delete(Integer imageId) {
        eduWebsiteImagesMapper.delete(imageId);
    }

    @Override
    public void deleteBatch(Integer[] imageIds) {
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

}
