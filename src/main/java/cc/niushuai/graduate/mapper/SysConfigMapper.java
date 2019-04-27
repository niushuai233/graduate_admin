package cc.niushuai.graduate.mapper;

import cc.niushuai.graduate.entity.admin.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年12月4日 下午6:46:16
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {
	
	/**
	 * 根据key，查询value
	 */
	String queryByKey(String paramKey);
	
	/**
	 * 根据key，更新value
	 */
	int updateValueByKey(@Param("key") String key, @Param("value") String value);

    List<SysConfig> findRule(Map<String, Object> params);

	void setRule(SysConfig config);

    List<SysConfig> findByCode(String code);
}
