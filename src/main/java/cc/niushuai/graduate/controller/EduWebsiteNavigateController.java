package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteNavigate;
import cc.niushuai.graduate.service.EduWebsiteNavigateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 导航表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-02 17:16:49
 */
@Controller
@RequestMapping("eduwebsitenavigate")
public class EduWebsiteNavigateController {
    @Autowired
    private EduWebsiteNavigateService eduWebsiteNavigateService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsitenavigate:list")
    public String list() {
        return "eduwebsitenavigate/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduwebsitenavigate:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduWebsiteNavigate> eduWebsiteNavigateList = eduWebsiteNavigateService.getList(query);
        int total = eduWebsiteNavigateService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduWebsiteNavigateList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsitenavigate:save")
    public String add() {
        return "eduwebsitenavigate/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsitenavigate:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduWebsiteNavigate eduWebsiteNavigate = eduWebsiteNavigateService.get(id);
        model.addAttribute("model", eduWebsiteNavigate);
        return "eduwebsitenavigate/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduwebsitenavigate:info")
    public ResultUtil info(@PathVariable("id") Integer id) {
        EduWebsiteNavigate eduWebsiteNavigate = eduWebsiteNavigateService.get(id);
        return ResultUtil.ok().put("eduWebsiteNavigate", eduWebsiteNavigate);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存导航表")
    @RequestMapping("/save")
    @RequiresPermissions("eduwebsitenavigate:save")
    public ResultUtil save(@RequestBody EduWebsiteNavigate eduWebsiteNavigate) {
        eduWebsiteNavigateService.save(eduWebsiteNavigate);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改导航表")
    @RequestMapping("/update")
    @RequiresPermissions("eduwebsitenavigate:update")
    public ResultUtil update(@RequestBody EduWebsiteNavigate eduWebsiteNavigate) {
        eduWebsiteNavigateService.update(eduWebsiteNavigate);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用导航表")
    @RequestMapping("/enable")
    @RequiresPermissions("eduwebsitenavigate:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduWebsiteNavigateService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用导航表")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsitenavigate:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduWebsiteNavigateService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除导航表")
    @RequestMapping("/delete")
    @RequiresPermissions("eduwebsitenavigate:delete")
    public ResultUtil delete(@RequestBody Integer[] ids) {
        eduWebsiteNavigateService.deleteBatch(ids);

        return ResultUtil.ok();
    }

}
