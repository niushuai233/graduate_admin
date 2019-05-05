package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-04-29 12:58:02
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduWebsiteProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * 
	 */
	private Integer id;
	/**
	 *
	 * 类型
	 */
	private String type;
	/**
	 *
	 * 内容JSON格式
	 */
	private String desciption;
	/**
	 *
	 * 说明
	 */
	private String explain;
	/**
	 *
	 * 0禁用 1启用
	 */
	private String state;
	/**
	 *
	 * 创建人
	 */
	private String createBy;
	/**
	 *
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	/**
	 *
	 * 更新人
	 */
	private String updateBy;
	/**
	 *
	 * 更新时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;


}
