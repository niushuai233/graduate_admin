package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.SysJob;
import cc.niushuai.graduate.mapper.SysJobMapper;
import cc.niushuai.graduate.service.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("sysJobService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SysJobServiceImpl extends BaseServiceImpl<SysJob> implements SysJobService {
    @Autowired
    private SysJobMapper sysJobMapper;

    @Override
    public SysJob get(Long id) {
        return sysJobMapper.get(id);
    }

    @Override
    public List<SysJob> getList(Map<String, Object> map) {
        return sysJobMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return sysJobMapper.getCount(map);
    }

    @Override
    public void save(SysJob sysJob) {
        super.addValue(sysJob, false, 0);
        sysJobMapper.save(sysJob);
    }

    @Override
    public void update(SysJob sysJob) {
        super.addValue(sysJob, false, 1);
        sysJob.setUpdateDate(new Date());
        sysJobMapper.update(sysJob);
    }

    @Override
    public void delete(Long id) {
        sysJobMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysJobMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            SysJob sysJob = get(id);
            sysJob.setState(Integer.valueOf(stateValue));
            sysJob.setUpdateDate(new Date());
            update(sysJob);
        }
    }

}
