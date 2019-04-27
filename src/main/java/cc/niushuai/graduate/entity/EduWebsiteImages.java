package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * banner图管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
@Data
public class EduWebsiteImages implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer imageId;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 图链接地址
     */
    private String linkAddress;
    /**
     * 图标题
     */
    private String title;
    /**
     * 图片类型
     */
    private Integer typeId;
    /**
     * 序列号
     */
    private Integer seriesNumber;
    /**
     * 略缩图片地址
     */
    private String previewUrl;
    /**
     * 背景色
     */
    private String color;
    /**
     * 图片描述
     */
    private String describe;
    /**
     * 状态 0禁用 1启用
     */
    private Integer state;
    /**
     *
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     *
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}
