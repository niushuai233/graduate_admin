package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.SysOss;
import cc.niushuai.graduate.service.SysOssService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * oss配置
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018-12-13 10:07:04
 */
@Controller
@RequestMapping("sysoss")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;

    @RequestMapping("/list")
    public String list() {
        return "sysoss/list";
    }
	/**
	 * 列表
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("sysoss:list")
    @Log
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysOss> sysOssList = sysOssService.getList(query);
		int total = sysOssService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(sysOssList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("sysoss:save")
    public String add(){
        return "sysoss/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("sysoss:update")
    public String edit(Model model, @PathVariable("id") String id){
		SysOss sysOss = sysOssService.get(id);
        model.addAttribute("model",sysOss);
        return "sysoss/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{bucket}")
    @RequiresPermissions("sysoss:info")
    public ResultUtil info(@PathVariable("bucket") String bucket){
        SysOss sysOss = sysOssService.get(bucket);
        return ResultUtil.ok().put("sysOss", sysOss);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存oss配置")
	@RequestMapping("/save")
	@RequiresPermissions("sysoss:save")
	public ResultUtil save(@RequestBody SysOss sysOss){
        SysOss sysoss=sysOssService.get(sysOss.getBucket());
        if(sysoss!=null){
            throw new MyException("该bucket已存在");
        }
        sysOss.setCreateTime(new Date());
		sysOssService.save(sysOss);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改oss配置")
	@RequestMapping("/update")
	@RequiresPermissions("sysoss:update")
	public ResultUtil update(@RequestBody SysOss sysOss){
		sysOssService.update(sysOss);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用oss配置")
    @RequestMapping("/enable")
    @RequiresPermissions("sysoss:update")
    public ResultUtil enable(@RequestBody String[] ids){
        String stateValue= StateEnum.ENABLE.getCode();
		sysOssService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用oss配置")
    @RequestMapping("/disable")
    @RequiresPermissions("sysoss:update")
    public ResultUtil disable(@RequestBody String[] ids){
        String stateValue= StateEnum.DIASABLE.getCode();
		sysOssService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除oss配置")
	@RequestMapping("/delete")
	@RequiresPermissions("sysoss:delete")
	public ResultUtil delete(@RequestBody String[] buckets){
		sysOssService.deleteBatch(buckets);
		
		return ResultUtil.ok();
	}
	
}
