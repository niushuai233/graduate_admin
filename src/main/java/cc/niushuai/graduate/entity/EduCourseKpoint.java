package cc.niushuai.graduate.entity;

import cc.niushuai.graduate.entity.admin.SysMenu;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 章节管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 02:51:58
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduCourseKpoint implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     *
     */
    private Integer kpointId;


    /**
     * 课程id
     */
    private Integer courseId;


    /**
     * 节点名称
     */
    private String name;


    /**
     * 父级ID
     */
    private Integer parentId;


    /**
     * 添加时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;


    /**
     * 显示排序
     */
    private Integer sort;


    /**
     * 播放次数
     */
    private Integer playCount;


    /**
     * 是否可以试听1免费2收费
     */
    private Integer isFree;


    /**
     * 视频地址
     */
    private String videoUrl;


    /**
     * 讲师id
     */
    private Integer teacherId;


    /**
     * 播放时间
     */
    private String playTime;


    /**
     * 节点类型 0文件目录 1视频
     */
    private Integer kpointType;


    /**
     * 视频类型
     */
    private String videoType;


    /**
     * VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集
     */
    private String fileType;


    /**
     * 文本
     */
    private String content;


    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    /**
     * 创建人
     */
    private String createBy;


    /**
     * 更新人
     */
    private String updateBy;


    /**
     * ztree属性
     */
    private Boolean open;

    private List<?> list;

    private List<SysMenu> children;

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

}
