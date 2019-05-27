package cc.niushuai.graduate.service;

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
public interface EduCourseService extends BaseService<EduCourse>{
	
	EduCourse get(Long courseId);
	
	List<EduCourse> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduCourse eduCourse);
	
	void update(EduCourse eduCourse);
	
	void delete(Long courseId);
	
	void deleteBatch(Long[] courseIds);

    void updateState(Long[] ids, String stateValue);

	/**
	 * edu_website_course_detail
	 * @param map
	 * @return
	 */
	List<EduCourse> getEWCDList(Map<String, Object> map);

    int getEWCDCount(Map<String, Object> map);

	String getTeacherIds(Long id);
}
