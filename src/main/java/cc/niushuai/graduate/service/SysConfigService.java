package cc.niushuai.graduate.service;


import cc.niushuai.graduate.entity.admin.SysConfig;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年12月4日 下午6:49:01
 */
public interface SysConfigService {

    /**
     * 保存配置信息
     */
    void save(SysConfig config);

    /**
     * 更新配置信息
     */
    void update(SysConfig config);

    /**
     * 根据key，更新value
     */
    void updateValueByKey(String key, String value);

    /**
     * 删除配置信息
     */
    void deleteBatch(Long[] ids);

    /**
     * 获取List列表
     */
    List<SysConfig> queryList(Map<String, Object> map);

    /**
     * 获取总记录数
     */
    int queryTotal(Map<String, Object> map);

    SysConfig queryObject(Long id);

    /**
     * 根据key，获取配置的value值
     *
     * @param key          key
     * @param defaultValue 缺省值
     */
    String getValue(String key, String defaultValue);

    /**
     * 根据key，获取value的Object对象
     *
     * @param key   key
     * @param clazz Object对象
     */
    <T> T getConfigObject(String key, Class<T> clazz);

    List<SysConfig> findRule(Map<String, Object> params);

    void setRule(SysConfig config);

    List<SysConfig> findByCode(String code);
}
