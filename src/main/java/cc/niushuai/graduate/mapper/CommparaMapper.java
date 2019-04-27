package cc.niushuai.graduate.mapper;


import cc.niushuai.graduate.entity.admin.Commpara;

import java.util.List;
import java.util.Map;

/**
 * 字典管理
 * 
 * @author niushuai
 * @email qqniushuai951101@gmail.com
 * @date 2018-11-06 14:49:28
 */
public interface CommparaMapper extends BaseMapper<Commpara> {

    List<Commpara> getCodeValues(Map<String, Object> params);

    List<Commpara> findByVerify(Commpara commpara);
}
