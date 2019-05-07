package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduCourseTeacher;
import cc.niushuai.graduate.mapper.EduCourseTeacherMapper;
import cc.niushuai.graduate.service.EduCourseTeacherService;
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
@Service("eduCourseTeacherService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduCourseTeacherServiceImpl extends BaseServiceImpl<EduCourseTeacher> implements EduCourseTeacherService {
    @Autowired
    private EduCourseTeacherMapper eduCourseTeacherMapper;

    @Override
    public EduCourseTeacher get(Integer courseId) {
        return eduCourseTeacherMapper.get(courseId);
    }

    @Override
    public List<EduCourseTeacher> getList(Map<String, Object> map) {
        return eduCourseTeacherMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduCourseTeacherMapper.getCount(map);
    }

    @Override
    public void save(EduCourseTeacher eduCourseTeacher) {
        super.addValue(eduCourseTeacher, false, 0);
        eduCourseTeacherMapper.save(eduCourseTeacher);
    }

    @Override
    public void update(EduCourseTeacher eduCourseTeacher) {
        super.addValue(eduCourseTeacher, false, 1);
        eduCourseTeacherMapper.update(eduCourseTeacher);
    }

    @Override
    public void delete(Integer courseId) {
        eduCourseTeacherMapper.delete(courseId);
    }

    @Override
    public void deleteBatch(Integer[] courseIds) {
        eduCourseTeacherMapper.deleteBatch(courseIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduCourseTeacher eduCourseTeacher = get(id);
            update(eduCourseTeacher);
        }
    }

}
