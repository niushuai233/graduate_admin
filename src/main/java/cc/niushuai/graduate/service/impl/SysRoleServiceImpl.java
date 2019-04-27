package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.mapper.SysRoleMapper;
import cc.niushuai.graduate.service.SysRoleMenuService;
import cc.niushuai.graduate.service.SysRoleService;
import cc.niushuai.graduate.service.SysUserRoleService;
import cc.niushuai.graduate.service.SysUserService;
import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.commons.utils.ConstantMethod;
import cc.niushuai.graduate.entity.admin.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysUserService sysUserService;

	@Override
	public SysRole queryObject(Long roleId) {
		return sysRoleMapper.queryObject(roleId);
	}

	@Override
	public List<SysRole> queryList(Map<String, Object> map) {
		return sysRoleMapper.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleMapper.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysRole role) {
		role.setCreateTime(new Date());
		sysRoleMapper.save(role);
		
		//检查权限是否越权
		checkPrems(role);
		
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void update(SysRole role) {
		sysRoleMapper.update(role);
		
		//检查权限是否越权
		checkPrems(role);
		
		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] roleIds) {
		sysRoleMapper.deleteBatch(roleIds);
		sysRoleMapper.deleteRoleMenu(roleIds);
		sysRoleMapper.deleteUserRole(roleIds);
	}
	
	@Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return sysRoleMapper.queryRoleIdList(createUserId);
	}

	@Override
	public List<SysRole> findAll(Map<String, Object> params) {
		return sysRoleMapper.findAll(params);
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRole role){
		//如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if(role.getCreateUserId() == ConstantMethod.SUPER_ADMIN){
			return ;
		}
		
		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());
		
		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			throw new MyException("新增角色的权限，已超出你的权限范围");
		}
	}
}
