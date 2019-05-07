package cc.niushuai.graduate.mapper;

import cc.niushuai.graduate.entity.EduCourse;

import java.util.List;
import java.util.Map;

/**
 * 课程表
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 13:44:30
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    List<EduCourse> getEWCDList(Map<String, Object> map);

    int getEWCDCount(Map<String, Object> map);
}
