package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteProfile;
import cc.niushuai.graduate.mapper.EduWebsiteProfileMapper;
import cc.niushuai.graduate.service.EduWebsiteProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("eduWebsiteProfileService")
@Transactional
public class EduWebsiteProfileServiceImpl extends BaseServiceImpl<EduWebsiteProfile> implements EduWebsiteProfileService {
    @Autowired
    private EduWebsiteProfileMapper eduWebsiteProfileMapper;

    @Override
    public EduWebsiteProfile get(Integer id) {
        return eduWebsiteProfileMapper.get(id);
    }

    @Override
    public List<EduWebsiteProfile> getList(Map<String, Object> map) {
        return eduWebsiteProfileMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduWebsiteProfileMapper.getCount(map);
    }

    @Override
    public void save(EduWebsiteProfile eduWebsiteProfile) {
        super.addValue(eduWebsiteProfile, false, 0);
        eduWebsiteProfileMapper.save(eduWebsiteProfile);
    }

    @Override
    public void update(EduWebsiteProfile eduWebsiteProfile) {
        super.addValue(eduWebsiteProfile, false, 1);
        eduWebsiteProfileMapper.update(eduWebsiteProfile);
    }

    @Override
    public void delete(Integer id) {
        eduWebsiteProfileMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        eduWebsiteProfileMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduWebsiteProfile eduWebsiteProfile = get(id);
            eduWebsiteProfile.setState(stateValue);
            update(eduWebsiteProfile);
        }
    }

}
