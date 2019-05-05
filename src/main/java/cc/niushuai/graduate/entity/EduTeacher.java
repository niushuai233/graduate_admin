package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 讲师
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 23:22:24
 */
@Data
public class EduTeacher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * 教师ID
	 */
	private Long id;
	/**
	 *
	 * 教师名称
	 */
	private String name;
	/**
	 *
	 * 教师资历,一句话说明老师
	 */
	private String education;
	/**
	 *
	 * 教师简介
	 */
	private String career;
	/**
	 *
	 * 头衔 1高级讲师2首席讲师
	 */
	private Integer isStar;
	/**
	 *
	 * 图片路径
	 */
	private String picPath;
	/**
	 *
	 * 状态:0正常1删除
	 */
	private Integer status;
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
	 * 专业ID
	 */
	private Integer subjectId;
	/**
	 *
	 * 排序
	 */
	private Integer sort;
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


}
