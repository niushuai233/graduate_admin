package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduCourse;
import cc.niushuai.graduate.service.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 课程表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 13:44:30
 */
@Slf4j
@Controller
@RequestMapping("educourse")
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("educourse:list")
    public String list() {
        return "educourse/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("educourse:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduCourse> eduCourseList = eduCourseService.getList(query);
        int total = eduCourseService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduCourseList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("educourse:save")
    public String add() {
        return "educourse/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("educourse:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduCourse eduCourse = eduCourseService.get(id);
        model.addAttribute("model", eduCourse);
        return "educourse/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{courseId}")
    @RequiresPermissions("educourse:info")
    public ResultUtil info(@PathVariable("courseId") Long courseId) {
        EduCourse eduCourse = eduCourseService.get(courseId);
        return ResultUtil.ok().put("eduCourse", eduCourse);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存课程表")
    @RequestMapping("/save")
    @RequiresPermissions("educourse:save")
    public ResultUtil save(@RequestBody EduCourse eduCourse) {
        eduCourseService.save(eduCourse);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改课程表")
    @RequestMapping("/update")
    @RequiresPermissions("educourse:update")
    public ResultUtil update(@RequestBody EduCourse eduCourse) {
        eduCourseService.update(eduCourse);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用课程表")
    @RequestMapping("/enable")
    @RequiresPermissions("educourse:update")
    public ResultUtil enable(@RequestBody Long[] ids) {
        eduCourseService.updateState(ids, "1");
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用课程表")
    @RequestMapping("/disable")
    @RequiresPermissions("educourse:update")
    public ResultUtil disable(@RequestBody Long[] ids) {
        eduCourseService.updateState(ids, "2");
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除课程表")
    @RequestMapping("/delete")
    @RequiresPermissions("educourse:delete")
    public ResultUtil delete(@RequestBody Long[] courseIds) {
        eduCourseService.deleteBatch(courseIds);

        return ResultUtil.ok();
    }

}
