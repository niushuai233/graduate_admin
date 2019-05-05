package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.SysSubject;

import java.util.List;
import java.util.Map;

/**
 * 专业信息
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 01:56:41
 */
public interface SysSubjectService extends BaseService<SysSubject>{
	
	SysSubject get(Long subjectId);
	
	List<SysSubject> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SysSubject sysSubject);
	
	void update(SysSubject sysSubject);
	
	void delete(Long subjectId);
	
	void deleteBatch(Long[] subjectIds);

    void updateState(Long[] ids, String stateValue);
}
