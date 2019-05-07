package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.entity.EduCourse;
import cc.niushuai.graduate.mapper.EduCourseMapper;
import cc.niushuai.graduate.mapper.EduCourseSubjectMapper;
import cc.niushuai.graduate.mapper.EduCourseTeacherMapper;
import cc.niushuai.graduate.service.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niush
 */
@Slf4j
@Service("eduCourseService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduCourseServiceImpl extends BaseServiceImpl<EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseMapper eduCourseMapper;
    @Autowired
    private EduCourseSubjectMapper eduCourseSubjectMapper;
    @Autowired
    private EduCourseTeacherMapper eduCourseTeacherMapper;

    @Override
    public EduCourse get(Long courseId) {
        return eduCourseMapper.get(courseId);
    }

    @Override
    public List<EduCourse> getList(Map<String, Object> map) {
        return eduCourseMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduCourseMapper.getCount(map);
    }

    @Override
    public void save(EduCourse eduCourse) {
        super.addValue(eduCourse, false, 0);
        eduCourse.setAddTime(new Date());
        eduCourseMapper.save(eduCourse);
        // 增加课程所属专业映射关系
        mappingCourseSubject(eduCourse);
        // 增加课程教师映射关系
        mappingCourseTeacher(eduCourse);
    }

    /**
     * 保存课程的同时 向课程教师中间表插入数据
     *
     * @param eduCourse
     */
    private void mappingCourseTeacher(EduCourse eduCourse) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseName", eduCourse.getCourseName());
        map.put("logo", eduCourse.getLogo());
        map.put("title", eduCourse.getTitle());

        eduCourseMapper.getList(new Query(map));
    }

    /**
     * 保存课程的同事 向课程专业中间表插入数据
     *
     * @param eduCourse
     */
    private void mappingCourseSubject(EduCourse eduCourse) {
    }

    @Override
    public void update(EduCourse eduCourse) {
        super.addValue(eduCourse, false, 1);
        eduCourse.setUpdateTime(new Date());
        eduCourseMapper.update(eduCourse);
    }

    @Override
    public void delete(Long courseId) {
        eduCourseMapper.delete(courseId);
    }

    @Override
    public void deleteBatch(Long[] courseIds) {
        eduCourseMapper.deleteBatch(courseIds);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            EduCourse eduCourse = get(id);
            eduCourse.setIsAvaliable(Long.valueOf(stateValue));
            eduCourse.setUpdateTime(new Date());
            update(eduCourse);
        }
    }

}
