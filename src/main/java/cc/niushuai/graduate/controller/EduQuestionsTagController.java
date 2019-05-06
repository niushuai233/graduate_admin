package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduQuestionsTag;
import cc.niushuai.graduate.service.EduQuestionsTagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 问答标签
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 13:48:05
 */
@Slf4j
@Controller
@RequestMapping("eduquestionstag")
public class EduQuestionsTagController {
    @Autowired
    private EduQuestionsTagService eduQuestionsTagService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduquestionstag:list")
    public String list() {
        return "eduquestionstag/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduquestionstag:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduQuestionsTag> eduQuestionsTagList = eduQuestionsTagService.getList(query);
        int total = eduQuestionsTagService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduQuestionsTagList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduquestionstag:save")
    public String add() {
        return "eduquestionstag/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduquestionstag:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduQuestionsTag eduQuestionsTag = eduQuestionsTagService.get(id);
        model.addAttribute("model", eduQuestionsTag);
        return "eduquestionstag/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{questionsTagId}")
    @RequiresPermissions("eduquestionstag:info")
    public ResultUtil info(@PathVariable("questionsTagId") Integer questionsTagId) {
        EduQuestionsTag eduQuestionsTag = eduQuestionsTagService.get(questionsTagId);
        return ResultUtil.ok().put("eduQuestionsTag", eduQuestionsTag);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存问答标签")
    @RequestMapping("/save")
    @RequiresPermissions("eduquestionstag:save")
    public ResultUtil save(@RequestBody EduQuestionsTag eduQuestionsTag) {
        eduQuestionsTagService.save(eduQuestionsTag);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改问答标签")
    @RequestMapping("/update")
    @RequiresPermissions("eduquestionstag:update")
    public ResultUtil update(@RequestBody EduQuestionsTag eduQuestionsTag) {
        eduQuestionsTagService.update(eduQuestionsTag);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用问答标签")
    @RequestMapping("/enable")
    @RequiresPermissions("eduquestionstag:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduQuestionsTagService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用问答标签")
    @RequestMapping("/disable")
    @RequiresPermissions("eduquestionstag:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduQuestionsTagService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除问答标签")
    @RequestMapping("/delete")
    @RequiresPermissions("eduquestionstag:delete")
    public ResultUtil delete(@RequestBody Integer[] questionsTagIds) {
        eduQuestionsTagService.deleteBatch(questionsTagIds);

        return ResultUtil.ok();
    }

}
