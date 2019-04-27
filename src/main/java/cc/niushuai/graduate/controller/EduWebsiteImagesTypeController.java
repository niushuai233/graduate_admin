package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteImagesType;
import cc.niushuai.graduate.service.EduWebsiteImagesTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 图片类型表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
@Controller
@RequestMapping("eduwebsiteimagestype")
public class EduWebsiteImagesTypeController {
    @Autowired
    private EduWebsiteImagesTypeService eduWebsiteImagesTypeService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsiteimagestype:list")
    public String list() {
        return "eduwebsiteimagestype/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduwebsiteimagestype:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduWebsiteImagesType> eduWebsiteImagesTypeList = eduWebsiteImagesTypeService.getList(query);
        int total = eduWebsiteImagesTypeService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduWebsiteImagesTypeList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsiteimagestype:save")
    public String add() {
        return "eduwebsiteimagestype/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsiteimagestype:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduWebsiteImagesType eduWebsiteImagesType = eduWebsiteImagesTypeService.get(id);
        model.addAttribute("model", eduWebsiteImagesType);
        return "eduwebsiteimagestype/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{typeId}")
    @RequiresPermissions("eduwebsiteimagestype:info")
    public ResultUtil info(@PathVariable("typeId") Integer typeId) {
        EduWebsiteImagesType eduWebsiteImagesType = eduWebsiteImagesTypeService.get(typeId);
        return ResultUtil.ok().put("eduWebsiteImagesType", eduWebsiteImagesType);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存图片类型表")
    @RequestMapping("/save")
    @RequiresPermissions("eduwebsiteimagestype:save")
    public ResultUtil save(@RequestBody EduWebsiteImagesType eduWebsiteImagesType) {
        eduWebsiteImagesTypeService.save(eduWebsiteImagesType);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改图片类型表")
    @RequestMapping("/update")
    @RequiresPermissions("eduwebsiteimagestype:update")
    public ResultUtil update(@RequestBody EduWebsiteImagesType eduWebsiteImagesType) {
        eduWebsiteImagesTypeService.update(eduWebsiteImagesType);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用图片类型表")
    @RequestMapping("/enable")
    @RequiresPermissions("eduwebsiteimagestype:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduWebsiteImagesTypeService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用图片类型表")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsiteimagestype:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduWebsiteImagesTypeService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除图片类型表")
    @RequestMapping("/delete")
    @RequiresPermissions("eduwebsiteimagestype:delete")
    public ResultUtil delete(@RequestBody Integer[] typeIds) {
        eduWebsiteImagesTypeService.deleteBatch(typeIds);

        return ResultUtil.ok();
    }


    @ResponseBody
    @RequestMapping("/getImageTypeJson")
    public ResultUtil getImageTypeJson() {

        try {
            Map<String, Object> params = new HashMap<String, Object>();
            //查询出状态为1的 即启用的类型
            params.put("state", 1);
            Query query = new Query(params, false);

            return ResultUtil.correct()
                    .put("val", eduWebsiteImagesTypeService.getList(query));
        } catch (Exception e) {
            e.printStackTrace();

            return ResultUtil.wrong()
                    .put("val", "系统繁忙");
        }

    }

}
