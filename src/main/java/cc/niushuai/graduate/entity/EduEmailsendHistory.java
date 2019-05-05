package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 邮件发送记录
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-03 12:16:04
 */
@Data
public class EduEmailsendHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String email;
    /**
     *
     */
    private Integer userId;
    /**
     * 邮箱标题
     */
    private String title;
    /**
     * 邮箱正文
     */
    private String content;
    /**
     *
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 定时发送时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;
    /**
     * 0 发送失败 1 已发送 2 待发送
     */
    private Integer status;
    /**
     * 1 普通 2 定时
     */
    private Integer type;

    /**
     * md正文
     */
    private String markdown;
    /**
     * html正文
     */
    private String html;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 更新日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新人
     */
    private String updateBy;


}
