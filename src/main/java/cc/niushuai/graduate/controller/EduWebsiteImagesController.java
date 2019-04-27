package cc.niushuai.graduate.controller;

import cc.niushuai.graduate.commons.enumresource.StateEnum;
import cc.niushuai.graduate.commons.utils.PageUtils;
import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.config.log.Log;
import cc.niushuai.graduate.entity.EduWebsiteImages;
import cc.niushuai.graduate.service.AttachmentService;
import cc.niushuai.graduate.service.EduWebsiteImagesService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
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
@Controller
@RequestMapping("eduwebsiteimages")
public class EduWebsiteImagesController {
	@Autowired
	private EduWebsiteImagesService eduWebsiteImagesService;

	@Autowired
    private AttachmentService attachmentService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eduwebsiteimages:list")
    public String list() {
        return "eduwebsiteimages/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("eduwebsiteimages:list")
	public ResultUtil listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduWebsiteImages> eduWebsiteImagesList = eduWebsiteImagesService.getList(query);
		int total = eduWebsiteImagesService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(eduWebsiteImagesList, total, query.getLimit(), query.getPage());
		
		return ResultUtil.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eduwebsiteimages:save")
    public String add(){
        return "eduwebsiteimages/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eduwebsiteimages:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		EduWebsiteImages eduWebsiteImages = eduWebsiteImagesService.get(id);
        model.addAttribute("model",eduWebsiteImages);
        return "eduwebsiteimages/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{imageId}")
    @RequiresPermissions("eduwebsiteimages:info")
    public ResultUtil info(@PathVariable("imageId") Integer imageId){
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
	public ResultUtil save(@RequestBody EduWebsiteImages eduWebsiteImages){
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
	public ResultUtil update(@RequestBody EduWebsiteImages eduWebsiteImages){
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
    public ResultUtil enable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		eduWebsiteImagesService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @Log("禁用banner图管理")
    @RequestMapping("/disable")
    @RequiresPermissions("eduwebsiteimages:update")
    public ResultUtil disable(@RequestBody Integer[] ids){
        String stateValue=StateEnum.DIASABLE.getCode();
		eduWebsiteImagesService.updateState(ids,stateValue);
        return ResultUtil.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @Log("删除banner图管理")
	@RequestMapping("/delete")
	@RequiresPermissions("eduwebsiteimages:delete")
	public ResultUtil delete(@RequestBody Integer[] imageIds){
		eduWebsiteImagesService.deleteBatch(imageIds);
		
		return ResultUtil.ok();
	}

	@Log("上传Banner图片")
	@RequestMapping("/imageUpload")
    @ResponseBody
//    @RequiresPermissions("eduwebsiteimages:upload")
	public ResultUtil imageUpload(MultipartFile file){

        StorePath storePath = attachmentService.imageUpload(file);
        if (null != storePath) {
            return ResultUtil.ok(storePath.getFullPath());
        }

        return ResultUtil.error();
    }
	
}
