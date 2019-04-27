package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.entity.admin.SysConfig;
import cc.niushuai.graduate.mapper.SysConfigMapper;
import cc.niushuai.graduate.service.SysConfigService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public void save(SysConfig config) {
        sysConfigMapper.save(config);
    }

    @Override
    public void update(SysConfig config) {
        sysConfigMapper.update(config);
    }

    @Override
    public void updateValueByKey(String key, String value) {
        sysConfigMapper.updateValueByKey(key, value);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysConfigMapper.deleteBatch(ids);
    }

    @Override
    public List<SysConfig> queryList(Map<String, Object> map) {
        return sysConfigMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysConfigMapper.queryTotal(map);
    }

    @Override
    public SysConfig queryObject(Long id) {
        return sysConfigMapper.queryObject(id);
    }

    @Override
    public String getValue(String key, String defaultValue) {
        String value = sysConfigMapper.queryByKey(key);
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return value;
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key, null);
        if (StringUtils.isNotBlank(value)) {
            return JSON.parseObject(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new MyException("获取参数失败");
        }
    }

    @Override
    public List<SysConfig> findRule(Map<String, Object> params) {
        return sysConfigMapper.findRule(params);
    }

    @Override
    public void setRule(SysConfig config) {
        sysConfigMapper.setRule(config);
    }

    @Override
    public List<SysConfig> findByCode(String code) {
        return sysConfigMapper.findByCode(code);
    }


}
