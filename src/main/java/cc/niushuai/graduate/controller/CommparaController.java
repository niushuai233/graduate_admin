package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.exception.MyException;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.admin.Commpara;
import cc.niushuai.graduate.service.CommparaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 字典管理
 * 
 * @author niushuai
 * @email qqniushuai951101@gmail.com
 * @date 2018-11-06 14:49:28
 */
@Controller
@RequestMapping("commpara")
public class CommparaController extends AbstractController{
	@Autowired
	private CommparaService commparaService;

    @RequestMapping("/list")
    public String list() {
        return "commpara/list";
    }
	/**
	 * 列表
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("commpara:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Commpara> commparaList = commparaService.queryList(query);
		int total = commparaService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(commparaList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("commpara:save")
    public String add(){
        return "commpara/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("commpara:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		Commpara commpara = commparaService.queryObject(id);
        model.addAttribute("model",commpara);
        return "commpara/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{paraId}")
    @RequiresPermissions("commpara:info")
    public ResultUtil info(@PathVariable("paraId") Integer paraId){
        Commpara commpara = commparaService.queryObject(paraId);
        return ResultUtil.ok().put("commpara", commpara);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存字典管理")
	@RequestMapping("/save")
	@RequiresPermissions("commpara:save")
	public ResultUtil save(@RequestBody Commpara commpara){
        //同一参数编码 下的 参数值不能相同
        List<Commpara> commparaList=commparaService.findByVerify(commpara);
        if(commparaList!=null&&commparaList.size()>0){
           throw  new MyException(commpara.getParaCode()+"下已存在该参数值");
        }

        commparaService.save(commpara);
		
		return ResultUtil.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @Log("修改字典管理")
	@RequestMapping("/update")
	@RequiresPermissions("commpara:update")
	public ResultUtil update(@RequestBody Commpara commpara){
        Commpara oldCommpara=commparaService.queryObject(commpara.getParaId());
        if(!oldCommpara.getParaCode().equals(commpara.getParaCode())||!oldCommpara.getParaKey().equals(commpara.getParaKey())){
            //同一参数编码 下的 参数值不能相同
            List<Commpara> commparaList=commparaService.findByVerify(commpara);
            if(commparaList!=null&&commparaList.size()>0){
                throw  new MyException(commpara.getParaCode()+"下已存在该参数值");
            }
        }

        commparaService.update(commpara);
		
		return ResultUtil.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用字典管理")
    @RequestMapping("/enable")
    @RequiresPermissions("commpara:update")
    public ResultUtil enable(@RequestBody Integer[] ids){
        String stateValue= StateEnum.ENABLE.getCode();
		commparaService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用字典管理")
    @RequestMapping("/disable")
    @RequiresPermissions("commpara:update")
    public ResultUtil disable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		commparaService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除字典管理")
	@RequestMapping("/delete")
	@RequiresPermissions("commpara:delete")
	public ResultUtil delete(@RequestBody Integer[] paraIds){
		commparaService.deleteBatch(paraIds);
		
		return ResultUtil.ok();
	}
	
}
