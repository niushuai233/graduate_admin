package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.utils.ShiroUtils;
import cc.niushuai.graduate.entity.admin.SysUser;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller公共组件
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年11月9日 下午9:42:26
 */
@Slf4j
public abstract class AbstractController {

	protected SysUser getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
