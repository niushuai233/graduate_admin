package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduUser;
import cc.niushuai.graduate.mapper.EduUserMapper;
import cc.niushuai.graduate.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("eduUserService")
@Transactional
public class EduUserServiceImpl implements EduUserService {
    @Autowired
    private EduUserMapper eduUserMapper;

    @Override
    public EduUser get(Long userId) {
        return eduUserMapper.get(userId);
    }

    @Override
    public List<EduUser> getList(Map<String, Object> map) {
        return eduUserMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduUserMapper.getCount(map);
    }

    @Override
    public void save(EduUser eduUser) {
        eduUserMapper.save(eduUser);
    }

    @Override
    public void update(EduUser eduUser) {
        eduUserMapper.update(eduUser);
    }

    @Override
    public void delete(Long userId) {
        eduUserMapper.delete(userId);
    }

    @Override
    public void deleteBatch(Long[] userIds) {
        eduUserMapper.deleteBatch(userIds);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            EduUser eduUser = get(id);
            eduUser.setIsAvalible(Integer.valueOf(stateValue));
            update(eduUser);
        }
    }
	
}
