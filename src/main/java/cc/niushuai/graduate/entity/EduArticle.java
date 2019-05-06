package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 文章信息表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 01:07:31
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduArticle implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 文章ID
     */
    private Integer articleId;


    /**
     * 文章标题
     */
    private String title;


    /**
     * 文章摘要
     */
    private String summary;

    /**
     * md正文
     */
    private String markdown;

    /**
     * html正文
     */
    private String html;


    /**
     * 文章关键字
     */
    private String keyWord;


    /**
     * 文章图片URL
     */
    private String imageUrl;


    /**
     * 文章来源
     */
    private String source;


    /**
     * 文章作者
     */
    private String author;


    /**
     * 文章发布时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;


    /**
     * 文章访问链接
     */
    private String link;


    /**
     * 文章类型 2文章
     */
    private Integer articleType;


    /**
     * 文章点击量
     */
    private Integer clickNum;


    /**
     * 点赞数量
     */
    private Integer praiseCount;


    /**
     * 评论数
     */
    private Integer commentNum;


    /**
     * 排序值
     */
    private Long sort;


    /**
     * 0禁用 1启用
     */
    private Integer state;


    /**
     * 创建人
     */
    private String createBy;


    /**
     * 文章创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    /**
     * 更新人
     */
    private String updateBy;


    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;


}
