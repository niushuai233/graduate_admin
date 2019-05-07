package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteCourseDetail;
import cc.niushuai.graduate.service.EduWebsiteCourseDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 推荐课程表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:08:50
 */
@Slf4j
@Controller
@RequestMapping("eduwebsitecoursedetail")
public class EduWebsiteCourseDetailController {
    @Autowired
    private EduWebsiteCourseDetailService eduWebsiteCourseDetailService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsitecoursedetail:list")
    public String list() {
        return "eduwebsitecoursedetail/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduwebsitecoursedetail:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduWebsiteCourseDetail> eduWebsiteCourseDetailList = eduWebsiteCourseDetailService.getList(query);
        int total = eduWebsiteCourseDetailService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduWebsiteCourseDetailList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsitecoursedetail:save")
    public String add() {
        return "eduwebsitecoursedetail/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsitecoursedetail:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduWebsiteCourseDetail eduWebsiteCourseDetail =eduWebsiteCourseDetailService.get(id);
        model.addAttribute("model",eduWebsiteCourseDetail);
        return "eduwebsitecoursedetail/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduwebsitecoursedetail:info")
    public ResultUtil info(@PathVariable("id") Long id) {
        EduWebsiteCourseDetail eduWebsiteCourseDetail =eduWebsiteCourseDetailService.get(id);
        return ResultUtil.ok().put("eduWebsiteCourseDetail", eduWebsiteCourseDetail);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存推荐课程表")
    @RequestMapping("/save")
    @RequiresPermissions("eduwebsitecoursedetail:save")
    public ResultUtil save(@RequestBody EduWebsiteCourseDetail eduWebsiteCourseDetail) {
            eduWebsiteCourseDetailService.save(eduWebsiteCourseDetail);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改推荐课程表")
    @RequestMapping("/update")
    @RequiresPermissions("eduwebsitecoursedetail:update")
    public ResultUtil update(@RequestBody EduWebsiteCourseDetail eduWebsiteCourseDetail) {
            eduWebsiteCourseDetailService.update(eduWebsiteCourseDetail);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用推荐课程表")
    @RequestMapping("/enable")
    @RequiresPermissions("eduwebsitecoursedetail:update")
    public ResultUtil enable(@RequestBody Long[]ids) {
        String stateValue = StateEnum.ENABLE.getCode();
            eduWebsiteCourseDetailService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用推荐课程表")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsitecoursedetail:update")
    public ResultUtil disable(@RequestBody Long[]ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
            eduWebsiteCourseDetailService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除推荐课程表")
    @RequestMapping("/delete")
    @RequiresPermissions("eduwebsitecoursedetail:delete")
    public ResultUtil delete(@RequestBody Long[] ids) {
            eduWebsiteCourseDetailService.deleteBatch(ids);

        return ResultUtil.ok();
    }

    /**
     * 批量添加
     */
    @ResponseBody
    @Log("批量添加推荐课程")
    @RequestMapping("/batchAdd")
    public ResultUtil batchAdd(@RequestBody Long[] ids) {
        eduWebsiteCourseDetailService.batchAdd(ids, "2");
        return ResultUtil.ok();
    }

}
