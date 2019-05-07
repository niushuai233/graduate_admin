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

import cc.niushuai.graduate.entity.EduCourseSubject;
import cc.niushuai.graduate.service.EduCourseSubjectService;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;


/**
 * 
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 22:08:20
 */
@Slf4j
@Controller
@RequestMapping("educoursesubject")
public class EduCourseSubjectController {
	@Autowired
	private EduCourseSubjectService eduCourseSubjectService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("educoursesubject:list")
    public String list() {
        return "educoursesubject/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("educoursesubject:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduCourseSubject> eduCourseSubjectList = eduCourseSubjectService.getList(query);
		int total = eduCourseSubjectService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(eduCourseSubjectList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("educoursesubject:save")
    public String add(){
        return "educoursesubject/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("educoursesubject:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		EduCourseSubject eduCourseSubject = eduCourseSubjectService.get(id);
        model.addAttribute("model",eduCourseSubject);
        return "educoursesubject/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("educoursesubject:info")
    public ResultUtil info(@PathVariable("id") Integer id){
        EduCourseSubject eduCourseSubject = eduCourseSubjectService.get(id);
        return ResultUtil.ok().put("eduCourseSubject", eduCourseSubject);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存")
	@RequestMapping("/save")
	@RequiresPermissions("educoursesubject:save")
	public ResultUtil save(@RequestBody EduCourseSubject eduCourseSubject){
		eduCourseSubjectService.save(eduCourseSubject);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改")
	@RequestMapping("/update")
	@RequiresPermissions("educoursesubject:update")
	public ResultUtil update(@RequestBody EduCourseSubject eduCourseSubject){
		eduCourseSubjectService.update(eduCourseSubject);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("educoursesubject:update")
    public ResultUtil enable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		eduCourseSubjectService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用")
    @RequestMapping("/disable")
    @RequiresPermissions("educoursesubject:update")
    public ResultUtil disable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		eduCourseSubjectService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("educoursesubject:delete")
	public ResultUtil delete(@RequestBody Integer[] ids){
		eduCourseSubjectService.deleteBatch(ids);
		
		return ResultUtil.ok();
	}
	
}
