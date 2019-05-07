package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.enumresource.TopMenuEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.commons.utils.ZtreeBean;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduCourseKpoint;
import cc.niushuai.graduate.service.EduCourseKpointService;
import lombok.extern.slf4j.Slf4j;
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
 * 章节管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 02:51:58
 */
@Slf4j
@Controller
@RequestMapping("educoursekpoint")
public class EduCourseKpointController {
    @Autowired
    private EduCourseKpointService eduCourseKpointService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("educoursekpoint:list")
    public String list() {
        return "educoursekpoint/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("educoursekpoint:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduCourseKpoint> eduCourseKpointList = eduCourseKpointService.getList(query);
        int total = eduCourseKpointService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduCourseKpointList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("educoursekpoint:save")
    public String add() {
        return "educoursekpoint/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("educoursekpoint:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduCourseKpoint eduCourseKpoint = eduCourseKpointService.get(id);
        model.addAttribute("model", eduCourseKpoint);
        return "educoursekpoint/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{kpointId}")
    @RequiresPermissions("educoursekpoint:info")
    public ResultUtil info(@PathVariable("kpointId") Integer kpointId) {
        EduCourseKpoint eduCourseKpoint = eduCourseKpointService.get(kpointId);
        return ResultUtil.ok().put("eduCourseKpoint", eduCourseKpoint);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存章节管理")
    @RequestMapping("/save")
    @RequiresPermissions("educoursekpoint:save")
    public ResultUtil save(@RequestBody EduCourseKpoint eduCourseKpoint) {
        eduCourseKpointService.save(eduCourseKpoint);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改章节管理")
    @RequestMapping("/update")
    @RequiresPermissions("educoursekpoint:update")
    public ResultUtil update(@RequestBody EduCourseKpoint eduCourseKpoint) {
        eduCourseKpointService.update(eduCourseKpoint);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用章节管理")
    @RequestMapping("/enable")
    @RequiresPermissions("educoursekpoint:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduCourseKpointService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用章节管理")
    @RequestMapping("/disable")
    @RequiresPermissions("educoursekpoint:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduCourseKpointService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除章节管理")
    @RequestMapping("/delete")
    @RequiresPermissions("educoursekpoint:delete")
    public ResultUtil delete(@RequestBody Integer[] kpointIds) {
        eduCourseKpointService.deleteBatch(kpointIds);

        return ResultUtil.ok();
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @ResponseBody
    @RequestMapping("/selectTreeTool}")
    public ResultUtil select() {
        //查询列表数据
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("status", 1);
        List<EduCourseKpoint> subjectList = eduCourseKpointService.getList(queryMap);
        List<ZtreeBean> ztreeBeans = getZtreeBeans(subjectList);

        return ResultUtil.ok().put("data", ztreeBeans);
    }

    private List<ZtreeBean> getZtreeBeans(List<EduCourseKpoint> kpList) {
        //添加顶级菜单
        EduCourseKpoint root = new EduCourseKpoint();
        root.setKpointId(Integer.parseInt(TopMenuEnum.TopMenu.getCode()));
        root.setName(TopMenuEnum.TopMenu.getDesc());
        root.setParentId(-1);
        root.setOpen(true);
        kpList.add(root);
        List<ZtreeBean> ztreeBeans = new ArrayList<>();
        for (EduCourseKpoint kpoint : kpList) {
            ZtreeBean tree = new ZtreeBean();
            tree.setId(kpoint.getKpointId() + "");
            tree.setpId(kpoint.getParentId() + "");
            tree.setName(kpoint.getName());
            tree.setOpen(kpoint.getOpen() + "");
            tree.setChkDisabled("false");
            ztreeBeans.add(tree);
        }
        return ztreeBeans;
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @ResponseBody
    @RequestMapping("/selectTreeTool/{courseId}")
    public ResultUtil select(@PathVariable Long courseId) {
        //查询列表数据
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("courseId", courseId);
        queryMap.put("status", 1);
        List<EduCourseKpoint> subjectList = eduCourseKpointService.getList(queryMap);

        //添加顶级菜单
        List<ZtreeBean> ztreeBeans = getZtreeBeans(subjectList);

        return ResultUtil.ok().put("data", ztreeBeans);
    }

}
