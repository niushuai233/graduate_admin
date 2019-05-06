package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 问答
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 21:39:25
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduQuestions implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;


    /**
     * 创建人id
     */
    private Long cusId;


    /**
     * 问答标题
     */
    private String title;


    /**
     * 问答内容
     */
    private String content;

    /**
     * md
     */
    private String markdown;

    /**
     * html
     */
    private String html;

    /**
     * 分类 1课程问答 2 学习分享
     */
    private Integer type;


    /**
     * 状态 0可回复1不可回复（采纳最佳答案后改为1 ）
     */
    private Integer status;


    /**
     * 问答回复数量
     */
    private Long replyCount;


    /**
     * 问答浏览次数
     */
    private Long browseCount;


    /**
     * 问答点赞数量
     */
    private Long praiseCount;


    /**
     * 0删除 1启用
     */
    private Integer state;

    /**
     * 添加时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;


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
