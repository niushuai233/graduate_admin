package cc.niushuai.graduate.mapper;

import cc.niushuai.graduate.entity.admin.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户与角色对应关系
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:34:46
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}
