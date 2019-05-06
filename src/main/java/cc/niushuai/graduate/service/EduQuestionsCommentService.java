package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduQuestionsComment;

import java.util.List;
import java.util.Map;

/**
 * 问答评论
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 00:16:25
 */
public interface EduQuestionsCommentService extends BaseService<EduQuestionsComment>{
	
	EduQuestionsComment get(Long id);
	
	List<EduQuestionsComment> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduQuestionsComment eduQuestionsComment);
	
	void update(EduQuestionsComment eduQuestionsComment);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    void updateState(Long[] ids, String stateValue);
}
