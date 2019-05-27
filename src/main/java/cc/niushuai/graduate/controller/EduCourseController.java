package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.PathUtil;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.utils.*;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduCourse;
import cc.niushuai.graduate.entity.SysSubject;
import cc.niushuai.graduate.service.EduCourseService;
import cc.niushuai.graduate.service.SysSubjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private SysSubjectService subjectService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("educourse:list")
    public String list(Model model) {
        model.addAttribute("courseAccessPath", PathUtil.getCourseAccessPath());
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
        addFdfsPerfix(eduCourseList);

        int total = eduCourseService.getCount(query);

        PageUtils pageUtil = new PageUtils(replaceSubjectId2Name(eduCourseList), total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 替换id换成name
     * @param eduCourseList
     * @return
     */
    private List<EduCourse> replaceSubjectId2Name(List<EduCourse> eduCourseList) {
        List<SysSubject> list = subjectService.getList(new Query(new HashMap<>(), false));
        HashMap<Long, String> map = new HashMap<>();
        for (SysSubject subject : list) {
            map.put(subject.getSubjectId(), subject.getSubjectName());
        }

        List<EduCourse> newList = new ArrayList<>();
        for (EduCourse eduCourse : eduCourseList) {
            eduCourse.setSubjectLink(map.get(eduCourse.getSubjectId()));
            newList.add(eduCourse);
        }

        return newList;


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
     * 遍历替换图片路径
     *
     * @param eduWebsiteImagesList
     */
    private void addFdfsPerfix(List<EduCourse> eduWebsiteImagesList) {
        eduWebsiteImagesList.forEach(item -> {
            String imageUrl = item.getLogo();
            if (StringUtils.isNotEmpty(imageUrl)) {
                item.setLogo(PathUtil.fillFdfsPath(imageUrl));
            } else {
                item.setLogo(Constant.DEFAULT_CROPPERJS_IMAGE);
            }
        });

    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("educourse:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduCourse eduCourse = eduCourseService.get(id);
        eduCourse.setTeachers(eduCourseService.getTeacherIds(id));
        model.addAttribute("model", eduCourse);
        model.addAttribute("fdfsAccessPrefix", PathUtil.fillFdfsPath(eduCourse.getLogo()));

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


    /**
     * 列表数据 edu_website_course_detail
     */
    @ResponseBody
    @RequestMapping("/listEWCDData")
    @RequiresPermissions("educourse:list")
    public ResultUtil listEWCDData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduCourse> eduCourseList = eduCourseService.getEWCDList(query);
        int total = eduCourseService.getEWCDCount(query);

        PageUtils pageUtil = new PageUtils(eduCourseList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    @ResponseBody
    @RequestMapping("/findAllCourseSelectTool")
    public ResultUtil findAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        List<EduCourse> list = eduCourseService.getList(map);

        List<EnumBean> values = new ArrayList<>();
        for (EduCourse course : list) {
            EnumBean enumBean = new EnumBean();
            enumBean.setCode(String.valueOf(course.getCourseId()));
            enumBean.setValue(course.getCourseName());
            values.add(enumBean);
        }

        return ResultUtil.ok().put("data", values);
    }

}
