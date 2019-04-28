package cc.niushuai.graduate.service;


import cc.niushuai.graduate.entity.admin.Area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018-08-10 16:00:04
 */
public interface AreaService {

    Area queryObject(String areaId);

    List<Area> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(Area area);

    void update(Area area);

    void delete(String areaId);

    void deleteBatch(String[] areaIds);

    List<Area> getAreaListByIsShow(HashMap<String, Object> paraMap);

    int getCount(Map<String, Object> params);

    void updateState(String[] ids, String stateValue);

    String getAreaNameStr(String area_id_str);
}
