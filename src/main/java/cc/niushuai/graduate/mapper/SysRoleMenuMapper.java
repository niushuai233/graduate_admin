package cc.niushuai.graduate.mapper;


import cc.niushuai.graduate.entity.admin.SysRoleMenu;

import java.util.List;

/**
 * 角色与菜单对应关系
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:33:46
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);
}
