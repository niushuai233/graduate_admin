package cc.niushuai.graduate.controller;

import java.util.List;
import java.util.Map;
import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.config.log.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;

import cc.niushuai.graduate.entity.EduCourseTeacher;
import cc.niushuai.graduate.service.EduCourseTeacherService;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;


/**
 * 课程讲师关联
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 22:06:27
 */
@Slf4j
@Controller
@RequestMapping("educourseteacher")
public class EduCourseTeacherController {
	@Autowired
	private EduCourseTeacherService eduCourseTeacherService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("educourseteacher:list")
    public String list() {
        return "educourseteacher/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("educourseteacher:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduCourseTeacher> eduCourseTeacherList = eduCourseTeacherService.getList(query);
		int total = eduCourseTeacherService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(eduCourseTeacherList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("educourseteacher:save")
    public String add(){
        return "educourseteacher/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("educourseteacher:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		EduCourseTeacher eduCourseTeacher = eduCourseTeacherService.get(id);
        model.addAttribute("model",eduCourseTeacher);
        return "educourseteacher/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{courseId}")
    @RequiresPermissions("educourseteacher:info")
    public ResultUtil info(@PathVariable("courseId") Integer courseId){
        EduCourseTeacher eduCourseTeacher = eduCourseTeacherService.get(courseId);
        return ResultUtil.ok().put("eduCourseTeacher", eduCourseTeacher);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存课程讲师关联")
	@RequestMapping("/save")
	@RequiresPermissions("educourseteacher:save")
	public ResultUtil save(@RequestBody EduCourseTeacher eduCourseTeacher){
		eduCourseTeacherService.save(eduCourseTeacher);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改课程讲师关联")
	@RequestMapping("/update")
	@RequiresPermissions("educourseteacher:update")
	public ResultUtil update(@RequestBody EduCourseTeacher eduCourseTeacher){
		eduCourseTeacherService.update(eduCourseTeacher);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用课程讲师关联")
    @RequestMapping("/enable")
    @RequiresPermissions("educourseteacher:update")
    public ResultUtil enable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		eduCourseTeacherService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用课程讲师关联")
    @RequestMapping("/disable")
    @RequiresPermissions("educourseteacher:update")
    public ResultUtil disable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		eduCourseTeacherService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除课程讲师关联")
	@RequestMapping("/delete")
	@RequiresPermissions("educourseteacher:delete")
	public ResultUtil delete(@RequestBody Integer[] courseIds){
		eduCourseTeacherService.deleteBatch(courseIds);
		
		return ResultUtil.ok();
	}
	
}
