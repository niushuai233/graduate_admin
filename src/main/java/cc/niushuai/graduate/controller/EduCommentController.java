package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduComment;
import cc.niushuai.graduate.entity.EduUser;
import cc.niushuai.graduate.service.EduCommentService;
import cc.niushuai.graduate.service.EduUserService;
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
 * 课程评论
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:59:37
 */
@Slf4j
@Controller
@RequestMapping("educomment")
public class EduCommentController {
    @Autowired
    private EduCommentService eduCommentService;
    @Autowired
    private EduUserService eduUserService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("educomment:list")
    public String list() {
        return "educomment/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("educomment:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduComment> eduCommentList = eduCommentService.getList(query);
        int total = eduCommentService.getCount(query);

        PageUtils pageUtil = new PageUtils(replace2Username(eduCommentList), total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 替换id换成name
     * @param eduCourseList
     * @return
     */
    private List<EduComment> replace2Username(List<EduComment> eduCourseList) {
        List<EduUser> list = eduUserService.getList(new Query(new HashMap<>(), false));
        Map<Long, String> map = new HashMap<>();
        for (EduUser user : list) {
            map.put(user.getUserId(), user.getUserName());
        }

        List<EduComment> newList = new ArrayList<>();
        for (EduComment comment : eduCourseList) {
            comment.setFatherId(String.valueOf(comment.getPCommentId()));
            comment.setCreateBy(map.get(comment.getUserId()));
            newList.add(comment);
        }

        return newList;


    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("educomment:save")
    public String add() {
        return "educomment/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("educomment:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduComment eduComment =eduCommentService.get(id);
        model.addAttribute("model",eduComment);
        return "educomment/edit";
    }

    /**
     * 信息
     */
    @GetMapping("/info/{commentId}")
    @RequiresPermissions("educomment:info")
    public String info(Model model, @PathVariable("commentId") Long commentId) {
        EduComment eduComment =eduCommentService.get(commentId);
        EduUser user = eduUserService.get(eduComment.getUserId());
        if (null != user) {
            eduComment.setCreateBy(user.getUserName());
        }
        model.addAttribute("model", eduComment);
        return "educomment/info";
    }

    /**
     * 信息
     */
    @ResponseBody
    @PostMapping("/info/{commentId}")
    @RequiresPermissions("educomment:info")
    public ResultUtil info(@PathVariable("commentId") Long commentId) {
        EduComment eduComment =eduCommentService.get(commentId);
        return ResultUtil.ok().put("eduComment", eduComment);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @Log("保存课程评论")
    @RequestMapping("/save")
    @RequiresPermissions("educomment:save")
    public ResultUtil save(@RequestBody EduComment eduComment) {
            eduCommentService.save(eduComment);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改课程评论")
    @RequestMapping("/update")
    @RequiresPermissions("educomment:update")
    public ResultUtil update(@RequestBody EduComment eduComment) {
            eduCommentService.update(eduComment);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用课程评论")
    @RequestMapping("/enable")
    @RequiresPermissions("educomment:update")
    public ResultUtil enable(@RequestBody Long[]ids) {
        String stateValue = StateEnum.ENABLE.getCode();
            eduCommentService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用课程评论")
    @RequestMapping("/disable")
    @RequiresPermissions("educomment:update")
    public ResultUtil disable(@RequestBody Long[]ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
            eduCommentService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除课程评论")
    @RequestMapping("/delete")
    @RequiresPermissions("educomment:delete")
    public ResultUtil delete(@RequestBody Long[] commentIds) {
            eduCommentService.deleteBatch(commentIds);

        return ResultUtil.ok();
    }

}
