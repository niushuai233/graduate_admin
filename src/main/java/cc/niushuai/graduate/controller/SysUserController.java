package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.DefaultEnum;
import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.commons.utils.*;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.SysUser;
import cc.niushuai.graduate.service.SysUserRoleService;
import cc.niushuai.graduate.service.SysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年10月31日 上午10:40:10
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 所有用户列表
     */

    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public String list() {
        return "user/list";
    }

    /**
     * 所有用户列表
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("sys:user:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() != ConstantMethod.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysUser> userList = sysUserService.queryList(query);
        int total = sysUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    /**
     * @param
     * @author niushuai
     * @Description 跳转到修改页面
     * @date 2018/6/27 11:17
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("sys:user:list")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") Long id) {
        SysUser user = sysUserService.queryObject(id);
        model.addAttribute("model", user);
        //获取所属角色
        List<Long> roleIds = sysUserRoleService.queryRoleIdList(user.getUserId());
        //将list转为字符串
        String roleIdList = StringUtils.join(roleIds.toArray(), ",");
        model.addAttribute("roleIdList", roleIdList);
        return "/user/edit";
    }

    /**
     * 获取登录的用户信息
     */
    @ResponseBody
    @RequestMapping("/info")
    public ResultUtil info() {
        return ResultUtil.ok().put("user", getUser());
    }

    /**
     * 修改登录用户密码
     */
    @ResponseBody
    @Log("修改密码")
    @RequestMapping("/password")
    public ResultUtil password(String password, String newPassword) {


        //sha256加密
        password = new Sha256Hash(password).toHex();
        //sha256加密
        newPassword = new Sha256Hash(newPassword).toHex();

        //更新密码
        int count = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (count == 0) {
            return ResultUtil.error("原密码不正确");
        }

        //退出
        ShiroUtils.logout();

        return ResultUtil.ok();
    }

    /**
     * 用户信息
     */
    @ResponseBody
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:list")
    public ResultUtil info(@PathVariable("userId") Long userId) {
        SysUser user = sysUserService.queryObject(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return ResultUtil.ok().put("user", user);
    }

    /**
     * 保存用户
     */
    @ResponseBody
    @Log("保存用户")
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:list")
    public ResultUtil save(@RequestBody SysUser user) {
        verifyForm(user);
        SysUser existUser = sysUserService.queryByUserName(user.getUsername());
        if (existUser != null) {
            return ResultUtil.error("用户名已存在!");
        }
        user.setPassword(DefaultEnum.PASSWORD.getCode());
        user.setCreateUserId(getUserId());
        sysUserService.save(user);

        return ResultUtil.ok();
    }

    /**
     * 修改用户
     */
    @ResponseBody
    @Log("修改用户")
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:list")
    public ResultUtil update(@RequestBody SysUser user) {
        verifyForm(user);
        user.setCreateUserId(getUserId());
        sysUserService.update(user);
        //todo kj

        return ResultUtil.ok();
    }

    /**
     * 删除用户
     */
    @ResponseBody
    @Log("删除用户")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:list")
    public ResultUtil delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return ResultUtil.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return ResultUtil.error("当前用户不能删除");
        }

        sysUserService.deleteBatch(userIds);

        return ResultUtil.ok();
    }

    /**
     * 初始化密码
     */
    @ResponseBody
    @Log("初始化密码")
    @RequestMapping("/initPassword")
    @RequiresPermissions("sys:user:list")
    public ResultUtil initPassword(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return ResultUtil.error("系统管理员不能初始化密码");
        }
        sysUserService.initPassword(userIds);

        return ResultUtil.ok();
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysUser user) {

        if (StringUtils.isEmpty(user.getMobile())) {
            throw new MyException("手机号不能为空");
        }

        if (StringUtils.isEmpty(user.getEmail())) {
            throw new MyException("邮箱不能为空");
        }
    }

    @ResponseBody
    @RequestMapping("/findAllUseSelectTool")
    @RequiresPermissions("sys:user:list")
    public ResultUtil findAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        List<SysUser> list = sysUserService.queryList(map);

        List<EnumBean> values = new ArrayList<>();
        for (SysUser user : list) {
            EnumBean enumBean = new EnumBean();
            enumBean.setCode(user.getUserId() + "|" + user.getEmail());
            enumBean.setValue(user.getUsername() + "|" + user.getEmail());
            values.add(enumBean);
        }

        return ResultUtil.ok().put("data", values);
    }
}
