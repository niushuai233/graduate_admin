package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduArticle;

import java.util.List;
import java.util.Map;

/**
 * 文章信息表
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 01:07:31
 */
public interface EduArticleService extends BaseService<EduArticle>{
	
	EduArticle get(Integer articleId);
	
	List<EduArticle> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduArticle eduArticle);
	
	void update(EduArticle eduArticle);
	
	void delete(Integer articleId);
	
	void deleteBatch(Integer[] articleIds);

    void updateState(Integer[] ids, String stateValue);
}
