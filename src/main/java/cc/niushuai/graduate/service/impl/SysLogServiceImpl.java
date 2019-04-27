package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.admin.SysLog;
import cc.niushuai.graduate.mapper.SysLogMapper;
import cc.niushuai.graduate.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLog queryObject(Long id) {
        return sysLogMapper.queryObject(id);
    }

    @Override
    public List<SysLog> queryList(Map<String, Object> map) {
        return sysLogMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysLogMapper.queryTotal(map);
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }

    @Override
    public void update(SysLog sysLog) {
        sysLogMapper.update(sysLog);
    }

    @Override
    public void delete(Long id) {
        sysLogMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysLogMapper.deleteBatch(ids);
    }

}
