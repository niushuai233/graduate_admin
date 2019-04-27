package cc.niushuai.graduate.mapper;

import cc.niushuai.graduate.entity.admin.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:33:33
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);

    List<SysRole> findAll(Map<String, Object> params);

    void deleteRoleMenu(Long[] roleIds);

    void deleteUserRole(Long[] roleIds);
}
