package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteEhcache;
import cc.niushuai.graduate.mapper.EduWebsiteEhcacheMapper;
import cc.niushuai.graduate.service.EduWebsiteEhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("eduWebsiteEhcacheService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduWebsiteEhcacheServiceImpl extends BaseServiceImpl<EduWebsiteEhcache> implements EduWebsiteEhcacheService {
    @Autowired
    private EduWebsiteEhcacheMapper eduWebsiteEhcacheMapper;

    @Override
    public EduWebsiteEhcache get(Integer id) {
        return eduWebsiteEhcacheMapper.get(id);
    }

    @Override
    public List<EduWebsiteEhcache> getList(Map<String, Object> map) {
        return eduWebsiteEhcacheMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduWebsiteEhcacheMapper.getCount(map);
    }

    @Override
    public void save(EduWebsiteEhcache eduWebsiteEhcache) {
        super.addValue(eduWebsiteEhcache, false, 0);
        eduWebsiteEhcacheMapper.save(eduWebsiteEhcache);
    }

    @Override
    public void update(EduWebsiteEhcache eduWebsiteEhcache) {
        super.addValue(eduWebsiteEhcache, false, 1);
        eduWebsiteEhcacheMapper.update(eduWebsiteEhcache);
    }

    @Override
    public void delete(Integer id) {
        eduWebsiteEhcacheMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        eduWebsiteEhcacheMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduWebsiteEhcache eduWebsiteEhcache = get(id);
            update(eduWebsiteEhcache);
        }
    }

}
