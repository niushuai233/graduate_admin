package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.ListStringUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.entity.EduCourse;
import cc.niushuai.graduate.entity.EduCourseSubject;
import cc.niushuai.graduate.entity.EduCourseTeacher;
import cc.niushuai.graduate.mapper.EduCourseMapper;
import cc.niushuai.graduate.mapper.EduCourseSubjectMapper;
import cc.niushuai.graduate.mapper.EduCourseTeacherMapper;
import cc.niushuai.graduate.service.EduCourseService;
import cn.hutool.core.collection.CollectionUtil;
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
 * @author niushuai
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
        eduCourse.setContext(eduCourse.getHtml());
        eduCourse.setSourcePrice("0");
        eduCourse.setCurrentPrice("0");
        eduCourseMapper.save(eduCourse);
        // 增加课程所属专业映射关系
        mappingCourseSubject(getCourseIdByCondition(eduCourse), eduCourse.getSubjectId());
        // 增加课程教师映射关系
        mappingCourseTeacher(getCourseIdByCondition(eduCourse), eduCourse.getTeacherArray());

        dealCourseTeachers(eduCourse);
    }

    /**
     * 转化教师id
     *
     * @param eduCourse
     */
    private void dealCourseTeachers(EduCourse eduCourse) {
        String[] teacherArray = eduCourse.getTeacherArray();
        String teachers = ListStringUtils.array2String(teacherArray, false);
        log.info("teacherArray:{}", teacherArray.toString());
        log.info("teachers:{}", teachers);
        eduCourse.setTeachers(teachers);
    }

    /**
     * 保存课程的同时 向课程教师中间表插入数据
     *
     * @param courseId
     * @param teacherArray
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    protected void mappingCourseTeacher(Long courseId, String[] teacherArray) {
        // 非空 插入数据内容 teacher是多条数据
        if (null != courseId && null != teacherArray) {

            Map<String, Object> map = new HashMap<>();
            map.put("courseId", courseId);
            List<EduCourseTeacher> list = eduCourseTeacherMapper.getList(new Query(map, false));
            if (CollectionUtil.isNotEmpty(list)) {
                for (EduCourseTeacher eduCourseTeacher : list) {
                    eduCourseTeacherMapper.delete(eduCourseTeacher.getCourseId());
                }
            }

            for (String teacherId : teacherArray) {
                EduCourseTeacher tmp = new EduCourseTeacher();
                tmp.setCourseId(courseId);
                tmp.setTeacherId(Long.valueOf(teacherId));
                eduCourseTeacherMapper.save(tmp);
            }
            log.info("保存课程教师中间表数据成功");
        }
    }


    /**
     * 保存课程的同事 向课程专业中间表插入数据
     *
     * @param courseId
     * @param subjectId
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    protected void mappingCourseSubject(Long courseId, Long subjectId) {
        // 非空 插入数据内容 teacher是多条数据
        if (null != courseId && null != subjectId) {

            EduCourseSubject tmp = new EduCourseSubject();
            tmp.setCourseId(courseId);

            // 删除旧数据
            Map<String, Object> map = new HashMap<>();
            map.put("courseId", courseId);
            List<EduCourseSubject> list = eduCourseSubjectMapper.getList(new Query(map, false));
            if (CollectionUtil.isNotEmpty(list)) {
                for (EduCourseSubject eduCourseSubject : list) {
                    eduCourseSubjectMapper.delete(eduCourseSubject.getId());
                }
            }

            // 保存新数据
            tmp.setSubjectId(subjectId);
            eduCourseSubjectMapper.save(tmp);
            log.info("保存课程专业中间表数据成功");
        }
    }

    /**
     * 根据条件搜索单个数据
     *
     * @param eduCourse
     */
    private Long getCourseIdByCondition(EduCourse eduCourse) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseName", eduCourse.getCourseName());
        map.put("logo", eduCourse.getLogo());
        map.put("title", eduCourse.getTitle());

        Query query = new Query(map, false);
        List<EduCourse> list = eduCourseMapper.getList(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0).getCourseId();
        }
        return null;
    }


    @Override
    public void update(EduCourse eduCourse) {
        super.addValue(eduCourse, false, 1);
        eduCourse.setAddTime(new Date());
        eduCourse.setContext(eduCourse.getHtml());
        eduCourse.setSourcePrice("0");
        eduCourse.setCurrentPrice("0");
        eduCourseMapper.update(eduCourse);

        mappingCourseSubject(eduCourse.getCourseId(), eduCourse.getSubjectId());
        mappingCourseTeacher(eduCourse.getCourseId(), eduCourse.getTeacherArray());
        dealCourseTeachers(eduCourse);

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
    public String getTeacherIds(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseId", id);
        List<EduCourseTeacher> list = eduCourseTeacherMapper.getList(new Query(map, false));
        String ids = "";
        if (CollectionUtil.isNotEmpty(list)) {
            for (EduCourseTeacher teacher : list) {
                ids += teacher.getTeacherId() + ",";
            }
            ids = ids.substring(0, ids.length() - 1);
        }
        return ids;
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

    @Override
    public List<EduCourse> getEWCDList(Map<String, Object> map) {
        return eduCourseMapper.getEWCDList(map);
    }

    @Override
    public int getEWCDCount(Map<String, Object> map) {
        return eduCourseMapper.getEWCDCount(map);
    }

}
