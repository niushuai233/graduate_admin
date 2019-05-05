package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 专业信息
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 01:56:41
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysSubject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * 主键
	 */
	private Long subjectId;
	/**
	 *
	 * 专业名称
	 */
	private String subjectName;
	/**
	 *
	 * 父ID
	 */
	private Long parentId;
	/**
	 *
	 * 排序
	 */
	private Integer sort;
	/**
	 *
	 * 状态 0:默认 1:删除
	 */
	private Integer status;
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


}
