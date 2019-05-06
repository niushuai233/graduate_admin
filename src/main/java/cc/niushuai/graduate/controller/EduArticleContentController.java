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

import cc.niushuai.graduate.entity.EduArticleContent;
import cc.niushuai.graduate.service.EduArticleContentService;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;


/**
 * 文章内容表
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 01:07:31
 */
@Slf4j
@Controller
@RequestMapping("eduarticlecontent")
public class EduArticleContentController {
	@Autowired
	private EduArticleContentService eduArticleContentService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduarticlecontent:list")
    public String list() {
        return "eduarticlecontent/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("eduarticlecontent:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduArticleContent> eduArticleContentList = eduArticleContentService.getList(query);
		int total = eduArticleContentService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(eduArticleContentList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduarticlecontent:save")
    public String add(){
        return "eduarticlecontent/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduarticlecontent:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		EduArticleContent eduArticleContent = eduArticleContentService.get(id);
        model.addAttribute("model",eduArticleContent);
        return "eduarticlecontent/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{articleId}")
    @RequiresPermissions("eduarticlecontent:info")
    public ResultUtil info(@PathVariable("articleId") Integer articleId){
        EduArticleContent eduArticleContent = eduArticleContentService.get(articleId);
        return ResultUtil.ok().put("eduArticleContent", eduArticleContent);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存文章内容表")
	@RequestMapping("/save")
	@RequiresPermissions("eduarticlecontent:save")
	public ResultUtil save(@RequestBody EduArticleContent eduArticleContent){
		eduArticleContentService.save(eduArticleContent);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改文章内容表")
	@RequestMapping("/update")
	@RequiresPermissions("eduarticlecontent:update")
	public ResultUtil update(@RequestBody EduArticleContent eduArticleContent){
		eduArticleContentService.update(eduArticleContent);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用文章内容表")
    @RequestMapping("/enable")
    @RequiresPermissions("eduarticlecontent:update")
    public ResultUtil enable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		eduArticleContentService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用文章内容表")
    @RequestMapping("/disable")
    @RequiresPermissions("eduarticlecontent:update")
    public ResultUtil disable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		eduArticleContentService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除文章内容表")
	@RequestMapping("/delete")
	@RequiresPermissions("eduarticlecontent:delete")
	public ResultUtil delete(@RequestBody Integer[] articleIds){
		eduArticleContentService.deleteBatch(articleIds);
		
		return ResultUtil.ok();
	}
	
}
