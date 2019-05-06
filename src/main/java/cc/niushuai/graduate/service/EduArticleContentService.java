package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduArticleContent;

import java.util.List;
import java.util.Map;

/**
 * 文章内容表
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 01:07:31
 */
public interface EduArticleContentService extends BaseService<EduArticleContent>{
	
	EduArticleContent get(Integer articleId);
	
	List<EduArticleContent> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduArticleContent eduArticleContent);
	
	void update(EduArticleContent eduArticleContent);
	
	void delete(Integer articleId);
	
	void deleteBatch(Integer[] articleIds);

    void updateState(Integer[] ids, String stateValue);
}
