package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduCourseSubject;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 22:08:20
 */
public interface EduCourseSubjectService extends BaseService<EduCourseSubject>{
	
	EduCourseSubject get(Integer id);
	
	List<EduCourseSubject> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduCourseSubject eduCourseSubject);
	
	void update(EduCourseSubject eduCourseSubject);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    void updateState(Integer[] ids, String stateValue);
}
