package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.PathUtil;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteImages;
import cc.niushuai.graduate.service.EduWebsiteImagesService;
import cc.niushuai.graduate.service.UploadService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
 * banner图管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
@Slf4j
@Controller
@RequestMapping("eduwebsiteimages")
public class EduWebsiteImagesController {
    @Autowired
    private EduWebsiteImagesService eduWebsiteImagesService;

    @Autowired
    private UploadService uploadService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsiteimages:list")
    public String list(Model model) {
        // 增加图片访问前缀
        model.addAttribute(Constant.FDFS_ACCESS_PREFIX, PathUtil.fdfsAccessPrefix);
        return "eduwebsiteimages/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("eduwebsiteimages:list")
    public ResultUtil listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EduWebsiteImages> eduWebsiteImagesList = eduWebsiteImagesService.getList(query);
        addFdfsPerfix(eduWebsiteImagesList);
        int total = eduWebsiteImagesService.getCount(query);

        PageUtils pageUtil = new PageUtils(eduWebsiteImagesList, total, query.getLimit(), query.getPage());

        return ResultUtil.ok().put("page", pageUtil);
    }

    /**
     * 遍历替换图片路径
     *
     * @param eduWebsiteImagesList
     */
    private void addFdfsPerfix(List<EduWebsiteImages> eduWebsiteImagesList) {
        eduWebsiteImagesList.forEach(item -> {
            String imageUrl = item.getImageUrl();
            if (StringUtils.isNotEmpty(imageUrl)) {
                item.setImageUrl(PathUtil.fillFdfsPath(imageUrl));
            } else {
                item.setImageUrl(Constant.DEFAULT_CROPPERJS_IMAGE);
            }
        });

    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsiteimages:save")
    public String add() {
        return "eduwebsiteimages/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsiteimages:update")
    public String edit(Model model, @PathVariable("id") Integer id) {
        EduWebsiteImages eduWebsiteImages = eduWebsiteImagesService.get(id);
        String imageUrl = eduWebsiteImages.getImageUrl();
        if (StringUtils.isEmpty(imageUrl)) {
            // 如果为空 放置默认图片
            // 增加图片访问前缀
            model.addAttribute(Constant.FDFS_ACCESS_PREFIX, Constant.DEFAULT_CROPPERJS_IMAGE);
        } else {
            // 如果不为空 放入全路径
            // 增加图片访问前缀
            model.addAttribute(Constant.FDFS_ACCESS_PREFIX, PathUtil.fillFdfsPath(imageUrl));
        }
        model.addAttribute("model", eduWebsiteImages);
        return "eduwebsiteimages/edit";
    }

    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{imageId}")
    @RequiresPermissions("eduwebsiteimages:info")
    public ResultUtil info(@PathVariable("imageId") Integer imageId) {
        EduWebsiteImages eduWebsiteImages = eduWebsiteImagesService.get(imageId);
        return ResultUtil.ok().put("eduWebsiteImages", eduWebsiteImages);
    }

    /**
     * 保存
     */
    @ResponseBody
    @Log("保存banner图管理")
    @RequestMapping("/save")
    @RequiresPermissions("eduwebsiteimages:save")
    public ResultUtil save(@RequestBody EduWebsiteImages eduWebsiteImages) {
        eduWebsiteImagesService.save(eduWebsiteImages);

        return ResultUtil.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @Log("修改banner图管理")
    @RequestMapping("/update")
    @RequiresPermissions("eduwebsiteimages:update")
    public ResultUtil update(@RequestBody EduWebsiteImages eduWebsiteImages) {
        eduWebsiteImagesService.update(eduWebsiteImages);

        return ResultUtil.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @Log("启用banner图管理")
    @RequestMapping("/enable")
    @RequiresPermissions("eduwebsiteimages:update")
    public ResultUtil enable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        eduWebsiteImagesService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用banner图管理")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsiteimages:update")
    public ResultUtil disable(@RequestBody Integer[] ids) {
        String stateValue = StateEnum.DIASABLE.getCode();
        eduWebsiteImagesService.updateState(ids, stateValue);
        return ResultUtil.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @Log("删除banner图管理")
    @RequestMapping("/delete")
    @RequiresPermissions("eduwebsiteimages:delete")
    public ResultUtil delete(@RequestBody Integer[] imageIds) {
        eduWebsiteImagesService.deleteBatch(imageIds);

        return ResultUtil.ok();
    }

    @Log("上传Banner图片")
    @RequestMapping("/imageUpload")
    @ResponseBody
//    @RequiresPermissions("eduwebsiteimages:upload")
    public ResultUtil imageUpload(MultipartFile file) {
        try {
            StorePath storePath = eduWebsiteImagesService.uploadImage(file);
            if (null != storePath) {
                return ResultUtil.ok(storePath.getFullPath());
            }
        } catch (Exception e) {
            log.error("上传Banner图片失败: {}", e.getMessage());
        }

        return ResultUtil.error();
    }

}
