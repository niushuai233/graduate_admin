package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 课程评论
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:59:37
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduComment implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 评论表
     */
    private Long commentId;


    /**
     * 用户id
     */
    private Long userId;


    /**
     * 父级评论id(为0则是一级评论,不为0则是回复)
     */
    private Long pCommentId;

    private String fatherId;


    /**
     * 评论内容
     */
    private String content;


    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;


    /**
     * 评论的相关id
     */
    private Long otherId;


    /**
     * 点赞数量
     */
    private Integer praiseCount;


    /**
     * 回复数量
     */
    private Integer replyCount;


    /**
     * 1文章 2课程
     */
    private Integer type;


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


}
