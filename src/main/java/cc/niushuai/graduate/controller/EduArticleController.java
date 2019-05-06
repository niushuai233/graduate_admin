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

import cc.niushuai.graduate.entity.EduArticle;
import cc.niushuai.graduate.service.EduArticleService;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;


/**
 * 文章信息表
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 01:07:31
 */
@Slf4j
@Controller
@RequestMapping("eduarticle")
public class EduArticleController {
	@Autowired
	private EduArticleService eduArticleService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduarticle:list")
    public String list() {
        return "eduarticle/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("eduarticle:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduArticle> eduArticleList = eduArticleService.getList(query);
		int total = eduArticleService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(eduArticleList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduarticle:save")
    public String add(){
        return "eduarticle/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduarticle:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		EduArticle eduArticle = eduArticleService.get(id);
        model.addAttribute("model",eduArticle);
        return "eduarticle/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{articleId}")
    @RequiresPermissions("eduarticle:info")
    public ResultUtil info(@PathVariable("articleId") Integer articleId){
        EduArticle eduArticle = eduArticleService.get(articleId);
        return ResultUtil.ok().put("eduArticle", eduArticle);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存文章信息表")
	@RequestMapping("/save")
	@RequiresPermissions("eduarticle:save")
	public ResultUtil save(@RequestBody EduArticle eduArticle){
		eduArticleService.save(eduArticle);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改文章信息表")
	@RequestMapping("/update")
	@RequiresPermissions("eduarticle:update")
	public ResultUtil update(@RequestBody EduArticle eduArticle){
		eduArticleService.update(eduArticle);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用文章信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("eduarticle:update")
    public ResultUtil enable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		eduArticleService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用文章信息表")
    @RequestMapping("/disable")
    @RequiresPermissions("eduarticle:update")
    public ResultUtil disable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		eduArticleService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除文章信息表")
	@RequestMapping("/delete")
	@RequiresPermissions("eduarticle:delete")
	public ResultUtil delete(@RequestBody Integer[] articleIds){
		eduArticleService.deleteBatch(articleIds);
		
		return ResultUtil.ok();
	}
	
}
