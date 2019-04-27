package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.utils.*;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.SysRole;
import cc.niushuai.graduate.service.SysRoleMenuService;
import cc.niushuai.graduate.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * 角色管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年11月8日 下午2:18:33
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("/list")
    public String list() {
        return "role/list";
    }

    /**
     * 角色列表
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("sys:role:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != ConstantMethod.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysRole> list = sysRoleService.queryList(query);
        int total = sysRoleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到添加页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("sys:role:list")
    public String add() {
        return "role/add";
    }

    /**
     * @param
     * @author niushuai
     * @Description 跳转到修改页面
     * @date 2018/6/27 11:17
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("sys:role:list")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") Long id) {
        SysRole role = sysRoleService.queryObject(id);
        model.addAttribute("model", role);
        return "/role/edit";
    }

    /**
     * 角色列表
     */
    @ResponseBody
    @RequestMapping("/findAll")
    @RequiresPermissions("sys:user:list")
    public ResultUtil findAll() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if (getUserId() != ConstantMethod.SUPER_ADMIN) {
            map.put("createUserId", getUserId());
        }
        List<SysRole> list = sysRoleService.queryList(map);
        List<EnumBean> values = new ArrayList<>();
        for (SysRole role : list) {
            EnumBean enumBean = new EnumBean();
            enumBean.setCode(role.getRoleId() + "");
            enumBean.setValue(role.getRoleName());
            values.add(enumBean);
        }

        return ResultUtil.ok().put("data", values);
    }

    /**
     * 角色列表
     */
    @ResponseBody
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public ResultUtil select() {
        Map<String, Object> map = new HashMap<>();

        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if (getUserId() != ConstantMethod.SUPER_ADMIN) {
            map.put("createUserId", getUserId());
        }
        List<SysRole> list = sysRoleService.queryList(map);

        return ResultUtil.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @ResponseBody
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public ResultUtil info(@PathVariable("roleId") Long roleId) {
        SysRole role = sysRoleService.queryObject(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);

        return ResultUtil.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @ResponseBody
    @Log("保存角色")
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public ResultUtil save(@RequestBody SysRole role) {

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return ResultUtil.ok();
    }

    /**
     * 修改角色
     */
    @ResponseBody
    @Log("修改角色")
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResultUtil update(@RequestBody SysRole role) {

        role.setCreateUserId(getUserId());
        sysRoleService.update(role);

        return ResultUtil.ok();
    }

    /**
     * 删除角色
     */
    @ResponseBody
    @Log("删除角色")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public ResultUtil delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);

        return ResultUtil.ok();
    }
}
