package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteImagesType;
import cc.niushuai.graduate.mapper.EduWebsiteImagesTypeMapper;
import cc.niushuai.graduate.service.EduWebsiteImagesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("eduWebsiteImagesTypeService")
@Transactional
public class EduWebsiteImagesTypeServiceImpl implements EduWebsiteImagesTypeService {
    @Autowired
    private EduWebsiteImagesTypeMapper eduWebsiteImagesTypeMapper;

    @Override
    public EduWebsiteImagesType get(Integer typeId) {
        return eduWebsiteImagesTypeMapper.get(typeId);
    }

    @Override
    public List<EduWebsiteImagesType> getList(Map<String, Object> map) {
        return eduWebsiteImagesTypeMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduWebsiteImagesTypeMapper.getCount(map);
    }

    @Override
    public void save(EduWebsiteImagesType eduWebsiteImagesType) {
        eduWebsiteImagesTypeMapper.save(eduWebsiteImagesType);
    }

    @Override
    public void update(EduWebsiteImagesType eduWebsiteImagesType) {
        eduWebsiteImagesTypeMapper.update(eduWebsiteImagesType);
    }

    @Override
    public void delete(Integer typeId) {
        eduWebsiteImagesTypeMapper.delete(typeId);
    }

    @Override
    public void deleteBatch(Integer[] typeIds) {
        eduWebsiteImagesTypeMapper.deleteBatch(typeIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduWebsiteImagesType eduWebsiteImagesType = get(id);
            eduWebsiteImagesType.setUpdateDate(new Date());
            eduWebsiteImagesType.setState(Integer.valueOf(stateValue));
            update(eduWebsiteImagesType);
        }
    }

}
