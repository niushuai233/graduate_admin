package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteProfile;
import cc.niushuai.graduate.service.EduWebsiteProfileService;
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
 * @date 2019-04-29 12:58:02
 */
@Controller
@RequestMapping("eduwebsiteprofile")
public class EduWebsiteProfileController {
    @Autowired
    private EduWebsiteProfileService eduWebsiteProfileService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsiteprofile:list")
    public String list() {
        return "eduwebsiteprofile/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduwebsiteprofile:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduWebsiteProfile> eduWebsiteProfileList = eduWebsiteProfileService.getList(query);
        int total = eduWebsiteProfileService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduWebsiteProfileList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsiteprofile:save")
    public String add() {
        return "eduwebsiteprofile/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsiteprofile:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduWebsiteProfile eduWebsiteProfile = eduWebsiteProfileService.get(id);
        model.addAttribute("model", eduWebsiteProfile);
        return "eduwebsiteprofile/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduwebsiteprofile:info")
    public ResultUtil info(@PathVariable("id") Integer id) {
        EduWebsiteProfile eduWebsiteProfile = eduWebsiteProfileService.get(id);
        return ResultUtil.ok().put("eduWebsiteProfile", eduWebsiteProfile);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存")
    @RequestMapping("/save")
    @RequiresPermissions("eduwebsiteprofile:save")
    public ResultUtil save(@RequestBody EduWebsiteProfile eduWebsiteProfile) {
        eduWebsiteProfileService.save(eduWebsiteProfile);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改")
    @RequestMapping("/update")
    @RequiresPermissions("eduwebsiteprofile:update")
    public ResultUtil update(@RequestBody EduWebsiteProfile eduWebsiteProfile) {
        eduWebsiteProfileService.update(eduWebsiteProfile);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("eduwebsiteprofile:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduWebsiteProfileService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsiteprofile:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduWebsiteProfileService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除")
    @RequestMapping("/delete")
    @RequiresPermissions("eduwebsiteprofile:delete")
    public ResultUtil delete(@RequestBody Integer[] ids) {
        eduWebsiteProfileService.deleteBatch(ids);

        return ResultUtil.ok();
    }

}
