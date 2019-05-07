package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteNavigate;
import cc.niushuai.graduate.mapper.EduWebsiteNavigateMapper;
import cc.niushuai.graduate.service.EduWebsiteNavigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("eduWebsiteNavigateService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduWebsiteNavigateServiceImpl extends BaseServiceImpl<EduWebsiteNavigate> implements EduWebsiteNavigateService {
    @Autowired
    private EduWebsiteNavigateMapper eduWebsiteNavigateMapper;

    @Override
    public EduWebsiteNavigate get(Integer id) {
        return eduWebsiteNavigateMapper.get(id);
    }

    @Override
    public List<EduWebsiteNavigate> getList(Map<String, Object> map) {
        return eduWebsiteNavigateMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduWebsiteNavigateMapper.getCount(map);
    }

    @Override
    public void save(EduWebsiteNavigate eduWebsiteNavigate) {
        super.addValue(eduWebsiteNavigate, false, 0);
        eduWebsiteNavigateMapper.save(eduWebsiteNavigate);
    }

    @Override
    public void update(EduWebsiteNavigate eduWebsiteNavigate) {
        super.addValue(eduWebsiteNavigate, false, 1);
        eduWebsiteNavigate.setUpdateDate(new Date());
        eduWebsiteNavigateMapper.update(eduWebsiteNavigate);
    }

    @Override
    public void delete(Integer id) {
        eduWebsiteNavigateMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        eduWebsiteNavigateMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduWebsiteNavigate eduWebsiteNavigate = get(id);
            eduWebsiteNavigate.setStatus(Integer.valueOf(stateValue));
            eduWebsiteNavigate.setUpdateDate(new Date());
            update(eduWebsiteNavigate);
        }
    }

}
