package cc.niushuai.graduate.mapper;

import cc.niushuai.graduate.entity.admin.Organize;

import java.util.List;

/**
 * 记录组织机构管理信息
 *
 * @author niushuai
 * @email qqniushuai951101@gmail.com
 * @date 2018-11-06 17:39:31
 */
public interface OrganizeMapper extends BaseMapper<Organize> {

    List<Organize> getList();

    List<Organize> queryByParentId(String orgId);

    Organize queryByOrgCode(String orgCode);
}
