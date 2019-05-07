package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 推荐课程表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:08:50
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduWebsiteCourseDetail implements Serializable{
private static final long serialVersionUID=1L;




/**
 *
 * 主键
 */
    private Long id;



/**
 *
 * 推荐分类的id
 */
    private Integer recommendId;



/**
 *
 * 课程id
 */
    private Long courseId;



/**
 *
 * 课程显示排序
 */
    private Integer orderNum;



/**
 *
 * 创建时间
 */
        @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



/**
 *
 * 更新时间
 */
        @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



/**
 *
 * 创建人
 */
    private String createBy;



/**
 *
 * 更新人
 */
    private String updateBy;

/**
 *
 * 更新人
 */
    private String courseName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
