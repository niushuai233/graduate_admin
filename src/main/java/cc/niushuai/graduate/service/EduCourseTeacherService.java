package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduCourseTeacher;

import java.util.List;
import java.util.Map;

/**
 * 课程讲师关联
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 22:06:27
 */
public interface EduCourseTeacherService extends BaseService<EduCourseTeacher>{
	
	EduCourseTeacher get(Integer courseId);
	
	List<EduCourseTeacher> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduCourseTeacher eduCourseTeacher);
	
	void update(EduCourseTeacher eduCourseTeacher);
	
	void delete(Integer courseId);
	
	void deleteBatch(Integer[] courseIds);

    void updateState(Integer[] ids, String stateValue);
}
