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

import cc.niushuai.graduate.entity.EduFile;
import cc.niushuai.graduate.service.EduFileService;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;


/**
 * 
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-23 12:14:26
 */
@Slf4j
@Controller
@RequestMapping("edufile")
public class EduFileController {
    @Autowired
    private EduFileService eduFileService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("edufile:list")
    public String list() {
        return "edufile/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("edufile:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduFile> eduFileList = eduFileService.getList(query);
        int total = eduFileService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduFileList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("edufile:save")
    public String add() {
        return "edufile/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("edufile:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduFile eduFile =eduFileService.get(id);
        model.addAttribute("model",eduFile);
        return "edufile/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("edufile:info")
    public ResultUtil info(@PathVariable("id") Long id) {
        EduFile eduFile =eduFileService.get(id);
        return ResultUtil.ok().put("eduFile", eduFile);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存")
    @RequestMapping("/save")
    @RequiresPermissions("edufile:save")
    public ResultUtil save(@RequestBody EduFile eduFile) {
            eduFileService.save(eduFile);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改")
    @RequestMapping("/update")
    @RequiresPermissions("edufile:update")
    public ResultUtil update(@RequestBody EduFile eduFile) {
            eduFileService.update(eduFile);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("edufile:update")
    public ResultUtil enable(@RequestBody Long[]ids) {
        String stateValue = StateEnum.ENABLE.getCode();
            eduFileService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用")
    @RequestMapping("/disable")
    @RequiresPermissions("edufile:update")
    public ResultUtil disable(@RequestBody Long[]ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
            eduFileService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除")
    @RequestMapping("/delete")
    @RequiresPermissions("edufile:delete")
    public ResultUtil delete(@RequestBody Long[] ids) {
            eduFileService.deleteBatch(ids);

        return ResultUtil.ok();
    }

}
