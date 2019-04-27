package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.mapper.SysUserRoleMapper;
import cc.niushuai.graduate.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年9月18日 上午9:45:48
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if (roleIdList == null || roleIdList.size() == 0) {
            return;
        }
        //先删除用户与角色关系
        sysUserRoleMapper.delete(userId);

        //保存用户与角色关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        sysUserRoleMapper.save(map);
    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return sysUserRoleMapper.queryRoleIdList(userId);
    }

    @Override
    public void delete(Long userId) {
        sysUserRoleMapper.delete(userId);
    }
}
