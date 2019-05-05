package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.SysSubject;
import cc.niushuai.graduate.mapper.SysSubjectMapper;
import cc.niushuai.graduate.service.SysSubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("sysSubjectService")
@Transactional
public class SysSubjectServiceImpl extends BaseServiceImpl<SysSubject> implements SysSubjectService {
    @Autowired
    private SysSubjectMapper sysSubjectMapper;

    @Override
    public SysSubject get(Long subjectId) {
        return sysSubjectMapper.get(subjectId);
    }

    @Override
    public List<SysSubject> getList(Map<String, Object> map) {
        return sysSubjectMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return sysSubjectMapper.getCount(map);
    }

    @Override
    public void save(SysSubject sysSubject) {
        super.addValue(sysSubject, false, 0);
        sysSubjectMapper.save(sysSubject);
    }

    @Override
    public void update(SysSubject sysSubject) {
        super.addValue(sysSubject, false, 1);
        sysSubject.setUpdateTime(new Date());
        sysSubjectMapper.update(sysSubject);
    }

    @Override
    public void delete(Long subjectId) {
        sysSubjectMapper.delete(subjectId);
    }

    @Override
    public void deleteBatch(Long[] subjectIds) {
        sysSubjectMapper.deleteBatch(subjectIds);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            SysSubject sysSubject = get(id);
            sysSubject.setStatus(Integer.valueOf(stateValue));
            sysSubject.setUpdateTime(new Date());
            update(sysSubject);
        }
    }

}
