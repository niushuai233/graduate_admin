package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 问答标签
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 13:48:05
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduQuestionsTag implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer questionsTagId;
    /**
     * 标签名
     */
    private String questionsTagName;
    /**
     * 父级id
     */
    private String parentId;
    /**
     * 父级标签名称
     */
    private String parentName;
    /**
     * 状态0默认1删除
     */
    private Integer status;
    /**
     * 标签创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     *
     */
    private String createBy;
    /**
     *
     */
    private String updateBy;


}
