package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteEhcache;
import cc.niushuai.graduate.service.EduWebsiteEhcacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 22:47:34
 */
@Slf4j
@Controller
@RequestMapping("eduwebsiteehcache")
public class EduWebsiteEhcacheController {
    @Autowired
    private EduWebsiteEhcacheService eduWebsiteEhcacheService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsiteehcache:list")
    public String list() {
        return "eduwebsiteehcache/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduwebsiteehcache:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduWebsiteEhcache> eduWebsiteEhcacheList = eduWebsiteEhcacheService.getList(query);
        int total = eduWebsiteEhcacheService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduWebsiteEhcacheList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsiteehcache:save")
    public String add() {
        return "eduwebsiteehcache/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsiteehcache:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduWebsiteEhcache eduWebsiteEhcache = eduWebsiteEhcacheService.get(id);
        model.addAttribute("model", eduWebsiteEhcache);
        return "eduwebsiteehcache/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduwebsiteehcache:info")
    public ResultUtil info(@PathVariable("id") Integer id) {
        EduWebsiteEhcache eduWebsiteEhcache = eduWebsiteEhcacheService.get(id);
        return ResultUtil.ok().put("eduWebsiteEhcache", eduWebsiteEhcache);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存")
    @RequestMapping("/save")
    @RequiresPermissions("eduwebsiteehcache:save")
    public ResultUtil save(@RequestBody EduWebsiteEhcache eduWebsiteEhcache) {
        eduWebsiteEhcacheService.save(eduWebsiteEhcache);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改")
    @RequestMapping("/update")
    @RequiresPermissions("eduwebsiteehcache:update")
    public ResultUtil update(@RequestBody EduWebsiteEhcache eduWebsiteEhcache) {
        eduWebsiteEhcacheService.update(eduWebsiteEhcache);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("eduwebsiteehcache:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduWebsiteEhcacheService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsiteehcache:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduWebsiteEhcacheService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除")
    @RequestMapping("/delete")
    @RequiresPermissions("eduwebsiteehcache:delete")
    public ResultUtil delete(@RequestBody Integer[] ids) {
        eduWebsiteEhcacheService.deleteBatch(ids);

        return ResultUtil.ok();
    }

}
