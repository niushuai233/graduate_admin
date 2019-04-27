package cc.niushuai.graduate.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基础Mapper(还需在XML文件里，有对应的SQL语句)
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:31:36
 */
public interface BaseMapper<T> {
	
	void save(T t);
	
	void save(Map<String, Object> map);
	
	void saveBatch(@Param(value = "entities") List<T> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);

	T queryObject(Object id);

	T get(Object id);
	
	List<T> queryList(Map<String, Object> map);

	List<T> getList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int getCount(Map<String, Object> map);

	int queryTotal();
}
