package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.MD5;
import cc.niushuai.graduate.entity.EduUser;
import cc.niushuai.graduate.mapper.EduUserMapper;
import cc.niushuai.graduate.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @author niushuai
 */
@Service("eduUserService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduUserServiceImpl extends BaseServiceImpl<EduUser> implements EduUserService {
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
        super.addValue(eduUser, false, 0);
        eduUser.setIsAvalible(1);
        String md5 = MD5.getMD5("123456");
        eduUser.setPassword(md5);
        eduUserMapper.save(eduUser);
    }

    @Override
    public void update(EduUser eduUser) {
        super.addValue(eduUser, false, 1);
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
