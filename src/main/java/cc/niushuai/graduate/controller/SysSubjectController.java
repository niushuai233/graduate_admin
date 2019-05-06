package cc.niushuai.graduate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.enumresource.TopMenuEnum;
import cc.niushuai.graduate.commons.utils.ZtreeBean;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.SysMenu;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;

import cc.niushuai.graduate.entity.SysSubject;
import cc.niushuai.graduate.service.SysSubjectService;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;


/**
 * 专业信息
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 12:46:32
 */
@Slf4j
@Controller
@RequestMapping("syssubject")
public class SysSubjectController {
	@Autowired
	private SysSubjectService sysSubjectService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("syssubject:list")
    public String list() {
        return "syssubject/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("syssubject:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysSubject> sysSubjectList = sysSubjectService.getList(query);
		int total = sysSubjectService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(sysSubjectList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("syssubject:save")
    public String add(){
        return "syssubject/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("syssubject:update")
    public String edit(Model model, @PathVariable("id") Long id){
		SysSubject sysSubject = sysSubjectService.get(id);
        model.addAttribute("model",sysSubject);
        return "syssubject/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{subjectId}")
    @RequiresPermissions("syssubject:info")
    public ResultUtil info(@PathVariable("subjectId") Long subjectId){
        SysSubject sysSubject = sysSubjectService.get(subjectId);
        return ResultUtil.ok().put("sysSubject", sysSubject);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存专业信息")
	@RequestMapping("/save")
	@RequiresPermissions("syssubject:save")
	public ResultUtil save(@RequestBody SysSubject sysSubject){
		sysSubjectService.save(sysSubject);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改专业信息")
	@RequestMapping("/update")
	@RequiresPermissions("syssubject:update")
	public ResultUtil update(@RequestBody SysSubject sysSubject){
		sysSubjectService.update(sysSubject);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用专业信息")
    @RequestMapping("/enable")
    @RequiresPermissions("syssubject:update")
    public ResultUtil enable(@RequestBody Long[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		sysSubjectService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用专业信息")
    @RequestMapping("/disable")
    @RequiresPermissions("syssubject:update")
    public ResultUtil disable(@RequestBody Long[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		sysSubjectService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除专业信息")
	@RequestMapping("/delete")
	@RequiresPermissions("syssubject:delete")
	public ResultUtil delete(@RequestBody Long[] subjectIds){
		sysSubjectService.deleteBatch(subjectIds);
		
		return ResultUtil.ok();
	}

    /**
     * 选择菜单(添加、修改菜单)
     */
    @ResponseBody
    @RequestMapping("/selectTreeTool")
    @RequiresPermissions("syssubject:list")
    public ResultUtil select() {
        //查询列表数据
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("status", 1);
        List<SysSubject> subjectList = sysSubjectService.getList(queryMap);

        //添加顶级菜单
        SysSubject root = new SysSubject();
        root.setSubjectId(Long.parseLong(TopMenuEnum.TopMenu.getCode()));
        root.setSubjectName(TopMenuEnum.TopMenu.getDesc());
        root.setParentId((long) -1);
        root.setOpen(true);
        subjectList.add(root);
        List<ZtreeBean> ztreeBeans = new ArrayList<>();
        for (SysSubject subject : subjectList) {
            ZtreeBean tree = new ZtreeBean();
            tree.setId(subject.getSubjectId() + "");
            tree.setpId(subject.getParentId() + "");
            tree.setName(subject.getSubjectName());
            tree.setOpen(subject.getOpen() + "");
            tree.setChkDisabled("false");
            ztreeBeans.add(tree);
        }

        return ResultUtil.ok().put("data", ztreeBeans);
    }
	
}
