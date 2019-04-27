package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 学生信息表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-13 20:58:42
 */
@Data
public class EduUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
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
     * 邮箱号
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
     * 昵称
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
     * 上次登录时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    /**
     * 上次登录IP
     */
    private String lastLoginIp;
    /**
     * 是否可用 1正常  0冻结
     */
    private Integer isAvalible;
    /**
     * 用户头像
     */
    private String picImg;
    /**
     * 个人中心用户背景图片
     */
    private String bannerUrl;
    /**
     * 站内信未读消息数
     */
    private Integer msgNum;
    /**
     * 系统发送的消息数量
     */
    private Integer sysMsgNum;
    /**
     * 上次查询系统消息时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastSystemTime;


}
