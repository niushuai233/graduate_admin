package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduWebsiteImages;

import java.util.List;
import java.util.Map;

/**
 * banner图管理
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
public interface EduWebsiteImagesService {
	
	EduWebsiteImages get(Integer imageId);
	
	List<EduWebsiteImages> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduWebsiteImages eduWebsiteImages);
	
	void update(EduWebsiteImages eduWebsiteImages);
	
	void delete(Integer imageId);
	
	void deleteBatch(Integer[] imageIds);

    void updateState(Integer[] ids, String stateValue);
}