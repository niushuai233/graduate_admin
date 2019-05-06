package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.SysJob;
import cc.niushuai.graduate.service.SysJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Cron任务
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 10:06:03
 */
@Controller
@RequestMapping("sysjob")
public class SysJobController {
    @Autowired
    private SysJobService sysJobService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysjob:list")
    public String list() {
        return "sysjob/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("sysjob:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysJob> sysJobList = sysJobService.getList(query);
        int total = sysJobService.getCount(query);

        PageUtils pageUtil = new PageUtils(sysJobList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("sysjob:save")
    public String add() {
        return "sysjob/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("sysjob:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        SysJob sysJob = sysJobService.get(id);
        model.addAttribute("model", sysJob);
        return "sysjob/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysjob:info")
    public ResultUtil info(@PathVariable("id") Long id) {
        SysJob sysJob = sysJobService.get(id);
        return ResultUtil.ok().put("sysJob", sysJob);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存Cron任务")
    @RequestMapping("/save")
    @RequiresPermissions("sysjob:save")
    public ResultUtil save(@RequestBody SysJob sysJob) {
        sysJobService.save(sysJob);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改Cron任务")
    @RequestMapping("/update")
    @RequiresPermissions("sysjob:update")
    public ResultUtil update(@RequestBody SysJob sysJob) {
        sysJobService.update(sysJob);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用Cron任务")
    @RequestMapping("/enable")
    @RequiresPermissions("sysjob:update")
    public ResultUtil enable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        sysJobService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用Cron任务")
    @RequestMapping("/disable")
    @RequiresPermissions("sysjob:update")
    public ResultUtil disable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        sysJobService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除Cron任务")
    @RequestMapping("/delete")
    @RequiresPermissions("sysjob:delete")
    public ResultUtil delete(@RequestBody Long[] ids) {
        sysJobService.deleteBatch(ids);

        return ResultUtil.ok();
    }

}
