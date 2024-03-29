package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.ConstantMethod;
import cc.niushuai.graduate.entity.admin.SysMenu;
import cc.niushuai.graduate.mapper.SysMenuMapper;
import cc.niushuai.graduate.service.SysMenuService;
import cc.niushuai.graduate.service.SysRoleMenuService;
import cc.niushuai.graduate.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author niushuai
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenu> menuList = sysMenuMapper.queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }

        List<SysMenu> userMenuList = new ArrayList<>();
        for (SysMenu menu : menuList) {
            if (menuIdList.contains(menu.getMenuId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<SysMenu> queryNotButtonList() {
        return sysMenuMapper.queryNotButtonList();
    }

    @Override
    public List<SysMenu> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == 1) {
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    @Override
    public SysMenu queryObject(Long menuId) {
        return sysMenuMapper.queryObject(menuId);
    }

    @Override
    public List<SysMenu> queryList(Map<String, Object> map) {
        return sysMenuMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysMenuMapper.queryTotal(map);
    }

    @Override
    public void save(SysMenu menu) {
        sysMenuMapper.save(menu);
    }

    @Override
    public void update(SysMenu menu) {
        sysMenuMapper.update(menu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteBatch(Long[] menuIds) {
        sysMenuMapper.deleteBatch(menuIds);
        sysMenuMapper.deleteRoleMenu(menuIds);
    }

    @Override
    public List<SysMenu> queryUserList(Long userId) {
        return sysMenuMapper.queryUserList(userId);
    }

    @Override
    public List<SysMenu> findByParentId(Long parentId) {
        return sysMenuMapper.findByParentId(parentId);
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenu> getAllMenuList(List<Long> menuIdList) {
        //查询根菜单列表
        List<SysMenu> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<Long> menuIdList) {
        List<SysMenu> subMenuList = new ArrayList<SysMenu>();

        for (SysMenu entity : menuList) {
            if (entity.getType() == ConstantMethod.MenuType.CATALOG.getValue()) {//目录
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
