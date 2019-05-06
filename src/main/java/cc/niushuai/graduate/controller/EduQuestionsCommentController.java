package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.PathUtil;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduQuestionsComment;
import cc.niushuai.graduate.service.EduQuestionsCommentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 问答评论
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 00:16:25
 */
@Slf4j
@Controller
@RequestMapping("eduquestionscomment")
public class EduQuestionsCommentController {
    @Autowired
    private EduQuestionsCommentService eduQuestionsCommentService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduquestionscomment:list")
    public String list(Model model) {
        model.addAttribute("questionInfoPath", PathUtil.getQuestionInfoPath());
        return "eduquestionscomment/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduquestionscomment:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduQuestionsComment> eduQuestionsCommentList = eduQuestionsCommentService.getList(query);
        int total = eduQuestionsCommentService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduQuestionsCommentList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduquestionscomment:save")
    public String add() {
        return "eduquestionscomment/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduquestionscomment:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduQuestionsComment eduQuestionsComment = eduQuestionsCommentService.get(id);
        model.addAttribute("model", eduQuestionsComment);
        return "eduquestionscomment/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduquestionscomment:info")
    public ResultUtil info(@PathVariable("id") Long id) {
        EduQuestionsComment eduQuestionsComment = eduQuestionsCommentService.get(id);
        return ResultUtil.ok().put("eduQuestionsComment", eduQuestionsComment);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存问答评论")
    @RequestMapping("/save")
    @RequiresPermissions("eduquestionscomment:save")
    public ResultUtil save(@RequestBody EduQuestionsComment eduQuestionsComment) {
        eduQuestionsCommentService.save(eduQuestionsComment);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改问答评论")
    @RequestMapping("/update")
    @RequiresPermissions("eduquestionscomment:update")
    public ResultUtil update(@RequestBody EduQuestionsComment eduQuestionsComment) {
        eduQuestionsCommentService.update(eduQuestionsComment);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用问答评论")
    @RequestMapping("/enable")
    @RequiresPermissions("eduquestionscomment:update")
    public ResultUtil enable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduQuestionsCommentService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用问答评论")
    @RequestMapping("/disable")
    @RequiresPermissions("eduquestionscomment:update")
    public ResultUtil disable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduQuestionsCommentService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除问答评论")
    @RequestMapping("/delete")
    @RequiresPermissions("eduquestionscomment:delete")
    public ResultUtil delete(@RequestBody Long[] ids) {
        eduQuestionsCommentService.deleteBatch(ids);

        return ResultUtil.ok();
    }

}
