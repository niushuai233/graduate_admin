package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduQuestions;

import java.util.List;
import java.util.Map;

/**
 * 问答
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 21:39:25
 */
public interface EduQuestionsService extends BaseService<EduQuestions>{
	
	EduQuestions get(Long id);
	
	List<EduQuestions> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduQuestions eduQuestions);
	
	void update(EduQuestions eduQuestions);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    void updateState(Long[] ids, String stateValue);
}
