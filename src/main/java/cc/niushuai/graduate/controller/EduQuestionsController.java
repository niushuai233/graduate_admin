package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.PathUtil;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduQuestions;
import cc.niushuai.graduate.service.EduQuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 问答
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 21:39:25
 */
@Slf4j
@Controller
@RequestMapping("eduquestions")
public class EduQuestionsController {
	@Autowired
	private EduQuestionsService eduQuestionsService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduquestions:list")
    public String list(Model model) {
        model.addAttribute("questionInfoPath", PathUtil.getQuestionInfoPath());
        return "eduquestions/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("eduquestions:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduQuestions> eduQuestionsList = eduQuestionsService.getList(query);
		int total = eduQuestionsService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(eduQuestionsList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduquestions:save")
    public String add(){
        return "eduquestions/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduquestions:update")
    public String edit(Model model, @PathVariable("id") Long id){
		EduQuestions eduQuestions = eduQuestionsService.get(id);
        model.addAttribute("model",eduQuestions);
        return "eduquestions/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduquestions:info")
    public ResultUtil info(@PathVariable("id") Long id){
        EduQuestions eduQuestions = eduQuestionsService.get(id);
        return ResultUtil.ok().put("eduQuestions", eduQuestions);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存问答")
	@RequestMapping("/save")
	@RequiresPermissions("eduquestions:save")
	public ResultUtil save(@RequestBody EduQuestions eduQuestions){
		eduQuestionsService.save(eduQuestions);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改问答")
	@RequestMapping("/update")
	@RequiresPermissions("eduquestions:update")
	public ResultUtil update(@RequestBody EduQuestions eduQuestions){
		eduQuestionsService.update(eduQuestions);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用问答")
    @RequestMapping("/enable")
    @RequiresPermissions("eduquestions:update")
    public ResultUtil enable(@RequestBody Long[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		eduQuestionsService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用问答")
    @RequestMapping("/disable")
    @RequiresPermissions("eduquestions:update")
    public ResultUtil disable(@RequestBody Long[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		eduQuestionsService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除问答")
	@RequestMapping("/delete")
	@RequiresPermissions("eduquestions:delete")
	public ResultUtil delete(@RequestBody Long[] ids){
		eduQuestionsService.deleteBatch(ids);
		
		return ResultUtil.ok();
	}
	
}
