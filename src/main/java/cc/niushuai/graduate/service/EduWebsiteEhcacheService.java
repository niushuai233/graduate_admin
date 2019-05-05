package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduWebsiteEhcache;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 22:47:34
 */
public interface EduWebsiteEhcacheService extends BaseService<EduWebsiteEhcache>{
	
	EduWebsiteEhcache get(Integer id);
	
	List<EduWebsiteEhcache> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduWebsiteEhcache eduWebsiteEhcache);
	
	void update(EduWebsiteEhcache eduWebsiteEhcache);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    void updateState(Integer[] ids, String stateValue);
}
