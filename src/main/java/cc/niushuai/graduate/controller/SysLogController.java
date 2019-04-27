package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.entity.admin.SysLog;
import cc.niushuai.graduate.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统日志
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018-03-08 10:40:56
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/list")
    public String list() {
        return "log/list";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("sys:log:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysLog> sysLogList = sysLogService.queryList(query);
        int total = sysLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysLogList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }


    /**
     * @param
     * @author niushuai
     * @Description 新增
     * @date 2018/6/27 11:17
     **/
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("sys:log:add")
    public ResultUtil save(@RequestBody SysLog syslog) {
        syslog.setCreateDate(new Date());
        syslog.setIp("1231454685");
        syslog.setMethod("asd");
        syslog.setOperation("asdawd");
        syslog.setParams("asdawdaw");
        sysLogService.save(syslog);

        return ResultUtil.ok();
    }

    /**
     * @param
     * @author niushuai
     * @Description 修改
     * @date 2018/6/27 11:17
     **/
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("sys:log:edit")
    public ResultUtil update(@RequestBody SysLog syslog) {
        sysLogService.update(syslog);
        return ResultUtil.ok();
    }

    /**
     * @param
     * @author niushuai
     * @Description 跳转到新增页面
     * @date 2018/6/27 11:17
     **/
    @RequestMapping("/add")
    @RequiresPermissions("sys:log:add")
    public String add() {
        return "syslog/add.jsp";
    }

    /**
     * @param
     * @author niushuai
     * @Description 跳转到修改页面
     * @date 2018/6/27 11:17
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("sys:log:edit")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") Long id) {
        SysLog sysLog = sysLogService.queryObject(id);
        model.addAttribute("model", sysLog);
        return "syslog/edit.jsp";
    }

    /**
     * @param
     * @author niushuai
     * @Description 删除
     * @date 2018/6/27 11:37
     **/
    @ResponseBody
    @RequestMapping("/deleteBatch")
    @RequiresPermissions("sys:log:delete")
    public ResultUtil deleteBatch(@RequestBody Long[] ids) {
        sysLogService.deleteBatch(ids);
        return ResultUtil.ok();
    }
}
