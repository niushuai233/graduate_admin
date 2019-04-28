package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.enumresource.TopMenuEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.commons.utils.ZtreeBean;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.Organize;
import cc.niushuai.graduate.service.OrganizeService;
import cc.niushuai.graduate.service.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 部门
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018-11-06 17:39:31
 */
@Controller
@RequestMapping("organize")
public class OrganizeController {
    @Autowired
    private OrganizeService organizeService;
    @Autowired
    private SysMenuService sysMenuService;


    @RequestMapping("/list")
    public String list() {
        return "organize/list";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("organize:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<Organize> organizeList = organizeService.queryList(query);
        int total = organizeService.queryTotal(query);
        if (organizeList != null && organizeList.size() > 0) {
            for (int i = 0; i < organizeList.size(); i++) {
                if (TopMenuEnum.TopMenu.getCode().equals(organizeList.get(i).getParentOrgId())) {
                    organizeList.get(i).setParentOrgName(TopMenuEnum.TopMenu.getDesc());
                    organizeList.get(i).setParentOrgId("-");
                }
            }
        }

        PageUtils pageUtil = new PageUtils(organizeList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("organize:save")
    public String add() {
        return "/organize/add";
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @ResponseBody
    @RequestMapping("/select")
    public ResultUtil select() {

        List<Organize> organizeList = organizeService.getList();

        //添加顶级菜单
        Organize root = new Organize();

        root.setOrgId(TopMenuEnum.TopOrg.getCode());
        root.setOrgName(TopMenuEnum.TopOrg.getDesc());
        root.setParentOrgId("-1");
        root.setOpen(true);
        organizeList.add(root);
        List<ZtreeBean> ztreeBeans = new ArrayList<>();
        for (Organize organize : organizeList) {
            ZtreeBean tree = new ZtreeBean();
            tree.setId(organize.getOrgId() + "");
            tree.setpId(organize.getParentOrgId() + "");
            tree.setName(organize.getOrgName());
            tree.setOpen(organize.isOpen() + "");
            tree.setChkDisabled("false");
            ztreeBeans.add(tree);
        }

        return ResultUtil.ok().put("data", ztreeBeans);
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("organize:update")
    public String edit(Model model, @PathVariable("id") String id) {
        Organize organize = organizeService.queryObject(id);
        model.addAttribute("model", organize);
        return "organize/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{orgId}")
    @RequiresPermissions("organize:info")
    public ResultUtil info(@PathVariable("orgId") String orgId) {
        Organize organize = organizeService.queryObject(orgId);
        return ResultUtil.ok().put("organize", organize);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存部门")
    @RequestMapping("/save")
    @RequiresPermissions("organize:save")
    public ResultUtil save(@RequestBody Organize organize) {
        //判断部门编号是否存在
        Organize oldOrganize = organizeService.queryByOrgCode(organize.getOrgCode());
        if (!ObjectUtils.isEmpty(oldOrganize)) {
            return ResultUtil.error("部门编号已存在");
        }

        organizeService.save(organize);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改部门")
    @RequestMapping("/update")
    @RequiresPermissions("organize:update")
    public ResultUtil update(@RequestBody Organize organize) {

        organizeService.update(organize);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用部门")
    @RequestMapping("/enable")
    @RequiresPermissions("organize:update")
    public ResultUtil enable(@RequestBody String[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        organizeService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用部门")
    @RequestMapping("/disable")
    @RequiresPermissions("organize:update")
    public ResultUtil disable(@RequestBody String[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        organizeService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除部门")
    @RequestMapping("/delete")
    @RequiresPermissions("organize:delete")
    public ResultUtil delete(@RequestBody String[] orgIds) {

        for (String orgId : orgIds) {
            organizeService.delete(orgId);
        }

        return ResultUtil.ok();
    }

}
