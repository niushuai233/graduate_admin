package cc.niushuai.graduate.mapper;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年12月19日 下午3:32:04
 */
public interface SysGeneratorMapper {
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
}
