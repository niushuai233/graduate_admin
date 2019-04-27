package cc.niushuai.graduate.mapper;


import cc.niushuai.graduate.entity.admin.Area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niushuai
 * @email qqniushuai951101@gmail.com
 * @date 2018-08-11 10:52:35
 */
public interface AreaMapper extends BaseMapper<Area> {

    List<Area> getAreaListByIsShow(HashMap<String, Object> paraMap);

    @Override
    int getCount(Map<String, Object> params);

    List<Area> findByParentId(String pId);
}
