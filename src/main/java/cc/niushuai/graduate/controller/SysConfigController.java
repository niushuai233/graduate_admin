package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.SysConfig;
import cc.niushuai.graduate.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * 系统配置信息表
 *
 * @author niushuai
 * @email qqniushuai951101@gmail.com
 * @date 2018-08-02 17:19:29
 */
@Controller
@RequestMapping("sys/config")
public class SysConfigController extends AbstractController{
	@Autowired
	private SysConfigService sysConfigService;

	@RequestMapping("/list")
	public String list() {
		return "config/list";
	}
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("sys:config:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);

		List<SysConfig> sysConfigList = sysConfigService.queryList(query);
		int total = sysConfigService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(sysConfigList, total, query.getLimit(), query.getPage());

		return ResultUtil.ok().put("page", pageUtil);
	}

	/**
	 * 跳转到新增页面
	 **/
	@RequestMapping("/add")
	@RequiresPermissions("sys:config:list")
	public String add(){
		return "config/add";
	}

	/**
	 *   跳转到修改页面
	 **/
	@RequestMapping("/edit/{id}")
	@RequiresPermissions("sys:config:list")
	public String edit(HttpServletRequest request, Model model, @PathVariable("id") Long id){
		SysConfig sysConfig = sysConfigService.queryObject(id);
		model.addAttribute("model", sysConfig);
		return "config/edit";
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:config:info")
	public ResultUtil info(@PathVariable("id") Long id){
		SysConfig sysConfig = sysConfigService.queryObject(id);

		return ResultUtil.ok().put("sysConfig", sysConfig);
	}

	/**
	 * 获取规则管理信息
	 */
	@ResponseBody
	@RequestMapping("/rule")
	@RequiresPermissions("sys:config:info")
	public ResultUtil rule(@RequestParam Map<String, Object> params){
		List<SysConfig> sysConfigList = sysConfigService.findRule(params);

		return ResultUtil.ok().put("data", sysConfigList);
	}


	/**
	 * 保存
	 */
	@ResponseBody
	@Log("保存参数")
	@RequestMapping("/save")
	@RequiresPermissions("sys:config:save")
	public ResultUtil save(@RequestBody SysConfig sysConfig){
		List<SysConfig> sysConfigList=sysConfigService.findByCode(sysConfig.getCode());
		if(sysConfigList!=null&&sysConfigList.size()>0){
			throw new MyException("参数名已存在");
		}
		sysConfigService.save(sysConfig);

		return ResultUtil.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@Log("修改参数管理")
	@RequestMapping("/update")
	@RequiresPermissions("sys:config:update")
	public ResultUtil update(@RequestBody SysConfig sysConfig){
		SysConfig oldConfig=sysConfigService.queryObject(sysConfig.getId());
		if(!oldConfig.getCode().equals(sysConfig.getCode())){
			List<SysConfig> sysConfigList=sysConfigService.findByCode(sysConfig.getCode());
			if(sysConfigList!=null&&sysConfigList.size()>0){
				throw new MyException("参数名已存在");
			}
		}
		sysConfigService.update(sysConfig);

		return ResultUtil.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@Log("删除参数管理")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:config:delete")
	public ResultUtil delete(@RequestBody Long[] ids){
		sysConfigService.deleteBatch(ids);

		return ResultUtil.ok();
	}

}
