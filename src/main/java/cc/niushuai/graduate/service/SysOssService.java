package cc.niushuai.graduate.service;


import cc.niushuai.graduate.entity.admin.SysOss;

import java.util.List;
import java.util.Map;

/**
 * oss配置
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018-12-13 10:07:04
 */
public interface SysOssService {
	
	SysOss get(String bucket);
	
	List<SysOss> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SysOss sysOss);
	
	void update(SysOss sysOss);
	
	void delete(String bucket);
	
	void deleteBatch(String[] buckets);

    void updateState(String[] ids, String stateValue);
}
