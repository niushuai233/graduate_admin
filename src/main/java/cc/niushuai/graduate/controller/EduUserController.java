package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.MD5;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduUser;
import cc.niushuai.graduate.service.EduUserService;
import cc.niushuai.graduate.vo.UserImportVo;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 学生信息表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-13 20:58:42
 */
@Controller
@RequestMapping("eduuser")
public class EduUserController {
    @Autowired
    private EduUserService eduUserService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduuser:list")
    public String list() {
        return "eduuser/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduuser:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduUser> eduUserList = eduUserService.getList(query);
        int total = eduUserService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduUserList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduuser:save")
    public String add() {
        return "eduuser/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduuser:update")
    public String edit(Model model, @PathVariable("id") Long id) {
        EduUser eduUser = eduUserService.get(id);
        model.addAttribute("model", eduUser);
        return "eduuser/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("eduuser:info")
    public ResultUtil info(@PathVariable("userId") Long userId) {
        EduUser eduUser = eduUserService.get(userId);
        return ResultUtil.ok().put("eduUser", eduUser);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存学生信息表")
    @RequestMapping("/save")
    @RequiresPermissions("eduuser:save")
    public ResultUtil save(@RequestBody EduUser eduUser) {
        eduUserService.save(eduUser);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改学生信息表")
    @RequestMapping("/update")
    @RequiresPermissions("eduuser:update")
    public ResultUtil update(@RequestBody EduUser eduUser) {
        eduUserService.update(eduUser);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用学生信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("eduuser:update")
    public ResultUtil enable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduUserService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用学生信息表")
    @RequestMapping("/disable")
    @RequiresPermissions("eduuser:update")
    public ResultUtil disable(@RequestBody Long[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduUserService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除学生信息表")
    @RequestMapping("/delete")
    @RequiresPermissions("eduuser:delete")
    public ResultUtil delete(@RequestBody Long[] userIds) {
        eduUserService.deleteBatch(userIds);

        return ResultUtil.ok();
    }


    /**
     * 用户导入
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/userImport")
    @ResponseBody
    public ResultUtil userImport(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        ExcelReader reader = ExcelUtil.getReader(inputStream);

        List<UserImportVo> userImportVos = reader.readAll(UserImportVo.class);
        System.out.println(JSONObject.toJSONString(userImportVos));

        List<String> stuNos = new ArrayList<String>();
        for (UserImportVo userImportVo : userImportVos) {
            EduUser user = new EduUser();
            user.setStuNo(userImportVo.get学号());

            boolean stuNoExistFlag = eduUserService.checkStuNoExist(userImportVo.get学号());
            if (stuNoExistFlag) {
                stuNos.add(userImportVo.get学号());
                continue;
            }

            user.setUserName(userImportVo.get姓名());
            user.setShowName(userImportVo.get姓名());
            user.setEmail(userImportVo.get邮箱());
            user.setPassword(MD5.getMD5("123456"));
            user.setMobile(userImportVo.get手机号());
            user.setSex(userImportVo.get性别().equalsIgnoreCase("男")?1:2);
            user.setIsAvalible(1);

            eduUserService.save(user);
        }

        return ResultUtil.ok("导入"+userImportVos.size()+"条数据成功, 其中学号为"+JSONObject.toJSONString(stuNos)+"的学生导入失败");
    }

}
