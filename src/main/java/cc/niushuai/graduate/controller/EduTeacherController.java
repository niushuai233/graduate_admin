package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.*;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduTeacher;
import cc.niushuai.graduate.entity.admin.SysUser;
import cc.niushuai.graduate.service.EduTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 讲师
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 23:22:24
 */
@Slf4j
@Controller
@RequestMapping("eduteacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduteacher:list")
    public String list() {
        return "eduteacher/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduteacher:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduTeacher> eduTeacherList = eduTeacherService.getList(query);
        addFdfsPerfix(eduTeacherList);
        int total = eduTeacherService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduTeacherList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 遍历替换图片路径
     *
     * @param eduTeacherList
     */
    private void addFdfsPerfix(List<EduTeacher> eduTeacherList) {
        eduTeacherList.forEach(item -> {
            String imageUrl = item.getPicPath();
            if (StringUtils.isNotEmpty(imageUrl)) {
                item.setPicPath(PathUtil.fillFdfsPath(imageUrl));
            } else {
                item.setPicPath(Constant.DEFAULT_CROPPERJS_IMAGE);
            }
        });

    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduteacher:save")
    public String add() {
        return "eduteacher/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduteacher:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduTeacher eduTeacher = eduTeacherService.get(id);
        model.addAttribute("model", eduTeacher);
        String imageUrl = eduTeacher.getPicPath();
        if (StringUtils.isEmpty(imageUrl)) {
            // 如果为空 放置默认图片
            // 增加图片访问前缀
            model.addAttribute(Constant.FDFS_ACCESS_PREFIX, Constant.DEFAULT_CROPPERJS_IMAGE);
        } else {
            // 如果不为空 放入全路径
            // 增加图片访问前缀
            model.addAttribute(Constant.FDFS_ACCESS_PREFIX, PathUtil.fillFdfsPath(imageUrl));
        }
        return "eduteacher/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduteacher:info")
    public ResultUtil info(@PathVariable("id") Long id) {
        EduTeacher eduTeacher = eduTeacherService.get(id);
        return ResultUtil.ok().put("eduTeacher", eduTeacher);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存讲师")
    @RequestMapping("/save")
    @RequiresPermissions("eduteacher:save")
    public ResultUtil save(@RequestBody EduTeacher eduTeacher) {
        eduTeacherService.save(eduTeacher);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改讲师")
    @RequestMapping("/update")
    @RequiresPermissions("eduteacher:update")
    public ResultUtil update(@RequestBody EduTeacher eduTeacher) {
        eduTeacherService.update(eduTeacher);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用讲师")
    @RequestMapping("/enable")
    @RequiresPermissions("eduteacher:update")
    public ResultUtil enable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduTeacherService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用讲师")
    @RequestMapping("/disable")
    @RequiresPermissions("eduteacher:update")
    public ResultUtil disable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduTeacherService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除讲师")
    @RequestMapping("/delete")
    @RequiresPermissions("eduteacher:delete")
    public ResultUtil delete(@RequestBody Long[] ids) {
        eduTeacherService.deleteBatch(ids);

        return ResultUtil.ok();
    }


    @ResponseBody
    @RequestMapping("/findAllTeacherSelectTool")
    public ResultUtil findAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        List<EduTeacher> list = eduTeacherService.getList(map);

        List<EnumBean> values = new ArrayList<>();
        for (EduTeacher teacher : list) {
            EnumBean enumBean = new EnumBean();
            enumBean.setCode(String.valueOf(teacher.getId()));
            enumBean.setValue(teacher.getName());
            values.add(enumBean);
        }

        return ResultUtil.ok().put("data", values);
    }

}
