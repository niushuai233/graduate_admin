package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.CronDateUtils;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduEmailsendHistory;
import cc.niushuai.graduate.service.EduEmailsendHistoryService;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 邮件发送记录
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-03 12:16:04
 */
@Slf4j
@Controller
@RequestMapping("eduemailsendhistory")
public class EduEmailsendHistoryController {
    @Autowired
    private EduEmailsendHistoryService eduEmailsendHistoryService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduemailsendhistory:list")
    public String list() {
        return "eduemailsendhistory/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduemailsendhistory:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduEmailsendHistory> eduEmailsendHistoryList = eduEmailsendHistoryService.getList(query);
        int total = eduEmailsendHistoryService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduEmailsendHistoryList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduemailsendhistory:save")
    public String add() {
        return "eduemailsendhistory/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduemailsendhistory:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduEmailsendHistory eduEmailsendHistory = eduEmailsendHistoryService.get(id);
        model.addAttribute("model", eduEmailsendHistory);
        return "eduemailsendhistory/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eduemailsendhistory:info")
    public String info(Model model, @PathVariable("id") Integer id) {
        EduEmailsendHistory eduEmailsendHistory = eduEmailsendHistoryService.get(id);
        model.addAttribute("model",eduEmailsendHistory);
        model.addAttribute("sendTime", DateUtil.formatDateTime(eduEmailsendHistory.getSendTime()));
        model.addAttribute("readOnly","readOnly");
        return "eduemailsendhistory/sendShow";
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存邮件发送记录")
    @RequestMapping("/save")
    @RequiresPermissions("eduemailsendhistory:save")
    public ResultUtil save(@RequestBody EduEmailsendHistory eduEmailsendHistory) {
        eduEmailsendHistoryService.save(eduEmailsendHistory);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改邮件发送记录")
    @RequestMapping("/update")
    @RequiresPermissions("eduemailsendhistory:update")
    public ResultUtil update(@RequestBody EduEmailsendHistory eduEmailsendHistory) {
        eduEmailsendHistoryService.update(eduEmailsendHistory);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用邮件发送记录")
    @RequestMapping("/enable")
    @RequiresPermissions("eduemailsendhistory:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduEmailsendHistoryService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用邮件发送记录")
    @RequestMapping("/disable")
    @RequiresPermissions("eduemailsendhistory:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduEmailsendHistoryService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除邮件发送记录")
    @RequestMapping("/delete")
    @RequiresPermissions("eduemailsendhistory:delete")
    public ResultUtil delete(@RequestBody Integer[] ids) {
        eduEmailsendHistoryService.deleteBatch(ids);

        return ResultUtil.ok();
    }


    /**
     * 转向到邮件发送页面
     *
     * @return
     */
    @GetMapping("/send")
    public String send() {

        return "eduemailsendhistory/send";
    }

    /**
     * 邮件发送
     *
     * @return
     */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public ResultUtil send(@RequestBody String bodyJson) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(bodyJson);

            /**
             * 接收人邮件
             */
            String email = jsonObject.getString("email");
            if (StringUtils.isEmpty(email) || email.equalsIgnoreCase(",")) {
                return ResultUtil.error("接收人不能为空");
            }
            email = email.replace("\"", "").replace("[", "").replace("]", "");

            /**
             * 邮箱标题
             */
            String title = jsonObject.getString("title");
            if (StringUtils.isEmpty(title)) {
                return ResultUtil.error("标题不能为空");
            }

            /**
             * 类型 1 立即发送 2定时发送
             */
            String type = jsonObject.getString("type");
            if (StringUtils.isEmpty(type)) {
                return ResultUtil.error("发送类型不能为空");
            }

            /**
             * 邮箱定时发送时间 只有type为2时会用到
             */
            String sendTime = jsonObject.getString("sendTime");
            if ("2".equalsIgnoreCase(type) && StringUtils.isEmpty(sendTime)) {
                return ResultUtil.error("定时发送时间不能为空");
            }
            // 校验日期是否能被定时处理
            if ("2".equalsIgnoreCase(type) && !CronDateUtils.isValidDate(sendTime)) {
                return ResultUtil.error("定时发送时间[" + sendTime + "]永远不可能到达");
            }


            /**
             * md格式正文
             */
            String markdown = jsonObject.getString("markdown");
            if (StringUtils.isEmpty(markdown)) {
                return ResultUtil.error("正文不能为空");
            }

            /**
             * html正文
             */
            String html = jsonObject.getString("html");
            if (StringUtils.isEmpty(html)) {
                return ResultUtil.error("正文不能为空");
            }

            return eduEmailsendHistoryService.sendEmail(email, title, sendTime, type, markdown, html);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("邮件发送失败:{}", e.getMessage());
        }
        return ResultUtil.error("邮件发送失败");
    }

}
