package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.admin.Area;
import cc.niushuai.graduate.mapper.AreaMapper;
import cc.niushuai.graduate.service.AreaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("areaService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public Area queryObject(String areaId) {
        return areaMapper.queryObject(areaId);
    }

    @Override
    public List<Area> queryList(Map<String, Object> map) {
        return areaMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return areaMapper.queryTotal(map);
    }

    @Override
    public void save(Area area) {
        areaMapper.save(area);
    }

    @Override
    public void update(Area area) {
        areaMapper.update(area);
    }

    @Override
    public void delete(String areaId) {
        areaMapper.delete(areaId);
    }


    /**
     * @param
     * @author chenjiabin
     * @Description 根据分类ID中转成分类名称串
     */
    @Override
    public String getAreaNameStr(String area_id_str) {
        String area_name_str = "";
        if (StringUtils.isEmpty(area_id_str)) {
            return area_name_str;
        }
        if (area_id_str.indexOf(",") > -1) {
            String[] menu_id = area_id_str.split(",");
            for (int i = 0; i < menu_id.length; i++) {
                area_name_str += getAreaName(menu_id[i]);
                if (i != menu_id.length - 1) {
                    area_name_str += ",";
                }
            }
        } else {
            area_name_str += getAreaName(area_id_str);
        }
        return area_name_str;
    }

    /**
     * @param
     * @author chenjiabin
     * @Description 根据菜单ID获取菜单名称
     */
    public String getAreaName(String areaId) {
        String areaName = "";
        Area area = queryObject(areaId);
        if (area != null) {
        }
        areaName = area.getAreaName();

        return areaName;
    }

    @Override
    public void deleteBatch(String[] areaIds) {
        for (String id : areaIds) {
            delete(id);
            //删除下级地区
            deleteSon(id);
        }
        areaMapper.deleteBatch(areaIds);
    }

    //删除下级
    private void deleteSon(String pId) {
        List<Area> areaList = findByParentId(pId);
        if (areaList != null) {
            for (Area area : areaList) {
                delete(area.getAreaId());
                //删除下级地区
                deleteSon(area.getAreaId());
            }
        }
    }

    //禁用或启用
    public void updateState(String[] ids, String stateValue) {
        for (String id : ids) {
            Area area = queryObject(id);
            area.setState(stateValue);
            update(area);
            //禁用或启用下级
            updateSon(id, stateValue);
        }
    }

    //禁用或启用下级
    private void updateSon(String pId, String stateValue) {
        List<Area> areaList = findByParentId(pId);
        if (areaList != null) {
            for (int i = 0; i < areaList.size(); i++) {
                Area area = areaList.get(i);
                area.setState(stateValue);
                update(area);
                //禁用下级地区
                updateSon(area.getAreaId(), stateValue);
            }
        }
    }

    private List<Area> findByParentId(String pId) {
        return areaMapper.findByParentId(pId);
    }

    @Override
    public List<Area> getAreaListByIsShow(HashMap<String, Object> paraMap) {
        return areaMapper.getAreaListByIsShow(paraMap);
    }

    @Override
    public int getCount(Map<String, Object> params) {
        return areaMapper.getCount(params);
    }

}
