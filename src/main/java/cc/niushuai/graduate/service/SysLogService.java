package cc.niushuai.graduate.service;


import cc.niushuai.graduate.entity.admin.SysLog;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018-03-08 10:40:56
 */
public interface SysLogService {

    SysLog queryObject(Long id);

    List<SysLog> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysLog sysLog);

    void update(SysLog sysLog);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
