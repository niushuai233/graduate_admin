package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 课程表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 13:44:30
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduCourse implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 课程编号
     */
    private Long courseId;


    /**
     * 课程名称
     */
    private String courseName;


    /**
     * 1正常2删除
     */
    private Long isAvaliable;


    /**
     * 课程专业ID
     */
    private Long subjectId;


    /**
     * 课程专业链
     */
    private String subjectLink;


    /**
     * 添加时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;


    /**
     * 课程原价格（只显示）
     */
    private String sourcePrice;


    /**
     * 课程销售价格（实际支付价格）设置为0则可免费观看
     */
    private String currentPrice;


    /**
     * 课程简介
     */
    private String title;


    /**
     * 课程详情
     */
    private String context;


    /**
     * 总课时
     */
    private Integer lessionNum;


    /**
     * 图片路径
     */
    private String logo;


    /**
     * 最后更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    /**
     * 销售数量
     */
    private Integer pageBuycount;


    /**
     * 浏览数量
     */
    private Integer pageViewcount;


    /**
     * 有效结束时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    /**
     * 有效期类型，0：到期时间，1：按天数
     */
    private Integer losetype;


    /**
     * 有效期:商品订单过期时间点
     */
    private String loseTime;


    /**
     * 序列
     */
    private Integer sequence;


    /**
     * 该课程总共卖了多少钱（新加字段暂时没用到）
     */
    private String courseGrossIncome;


    /**
     * md正文
     */
    private String markdown;

    /**
     * html正文
     */
    private String html;


    /**
     * 更新人
     */
    private String updateBy;


    /**
     * 创建人
     */
    private String createBy;

    /**
     * @description: 用于储存临时数据, 该课程和教师的对应关系 以逗号分割
     * @params:
     * @author: ns
     * @date: 2019/5/7 14:34
     */
    private String teachers;

    /**
     * 接收参数使用数组 否则发生异常
     *  Cannot deserialize instance of `java.lang.String` out of START_ARRAY token
     */
    private String[] teacherArray;


}
