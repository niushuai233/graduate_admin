package cc.niushuai.graduate.mapper;


import cc.niushuai.graduate.entity.admin.SysMenu;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:33:01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenu> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenu> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenu> queryUserList(Long userId);

    List<SysMenu> findByParentId(Long parentId);

    void deleteRoleMenu(Long[] menuIds);
}
