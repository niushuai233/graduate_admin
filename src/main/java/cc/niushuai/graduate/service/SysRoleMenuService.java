package cc.niushuai.graduate.service;

import java.util.List;


/**
 * 角色与菜单对应关系
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:42:30
 */
public interface SysRoleMenuService {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
	
}
