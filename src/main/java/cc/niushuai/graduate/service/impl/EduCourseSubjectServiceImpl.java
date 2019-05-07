package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduCourseSubject;
import cc.niushuai.graduate.mapper.EduCourseSubjectMapper;
import cc.niushuai.graduate.service.EduCourseSubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author niushuai
 */
@Slf4j
@Service("eduCourseSubjectService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduCourseSubjectServiceImpl extends BaseServiceImpl<EduCourseSubject> implements EduCourseSubjectService {
    @Autowired
    private EduCourseSubjectMapper eduCourseSubjectMapper;

    @Override
    public EduCourseSubject get(Integer id) {
        return eduCourseSubjectMapper.get(id);
    }

    @Override
    public List<EduCourseSubject> getList(Map<String, Object> map) {
        return eduCourseSubjectMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduCourseSubjectMapper.getCount(map);
    }

    @Override
    public void save(EduCourseSubject eduCourseSubject) {
        super.addValue(eduCourseSubject, false, 0);
        eduCourseSubjectMapper.save(eduCourseSubject);
    }

    @Override
    public void update(EduCourseSubject eduCourseSubject) {
        super.addValue(eduCourseSubject, false, 1);
        eduCourseSubjectMapper.update(eduCourseSubject);
    }

    @Override
    public void delete(Integer id) {
        eduCourseSubjectMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        eduCourseSubjectMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduCourseSubject eduCourseSubject = get(id);
            update(eduCourseSubject);
        }
    }

}
