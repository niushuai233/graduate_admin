package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 学员表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-27 14:18:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduUser implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    private Long userId;


    /**
     * 学号
     */
    private String stuNo;


    /**
     * 手机号
     */
    private String mobile;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 密码
     */
    private String password;


    /**
     * 用户名
     */
    private String userName;


    /**
     * 显示名 （昵称）
     */
    private String showName;


    /**
     * 性别  1男  2女
     */
    private Integer sex;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 注册时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    /**
     * 是否可用
     */
    private Integer isAvalible;


    /**
     * 用户头像
     */
    private String picImg;


    /**
     *
     */
    private String bannerUrl;


    /**
     *
     */
    private Integer msgNum;


    /**
     *
     */
    private Integer sysMsgNum;


    /**
     *
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastSystemTime;


}
