package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.SysJob;

import java.util.List;
import java.util.Map;

/**
 * Cron任务
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 10:06:03
 */
public interface SysJobService extends BaseService<SysJob>{
	
	SysJob get(Long id);
	
	List<SysJob> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SysJob sysJob);
	
	void update(SysJob sysJob);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    void updateState(Long[] ids, String stateValue);
}
