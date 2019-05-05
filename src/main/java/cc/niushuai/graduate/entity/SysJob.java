package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * Cron任务
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 10:06:03
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysJob implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * id
	 */
	private Long id;
	/**
	 *
	 * 任务名称
	 */
	private String jobName;
	/**
	 *
	 * cron表达式
	 */
	private String cron;
	/**
	 *
	 * 是否启动 0 未启动 1 已启动
	 */
	private Integer started;
	/**
	 *
	 * 是否需要重复执行
	 */
	private Integer recycle;
	/**
	 *
	 * 执行路径
	 */
	private String clazzPath;
	/**
	 *
	 * 任务描述
	 */
	private String jobDesc;
	/**
	 *
	 * 删除标志 0已删除 1未删除
	 */
	private Integer state;
	/**
	 *
	 * 创建日期
	 */
	private Date createDate;
	/**
	 *
	 * 更新日期
	 */
	private Date updateDate;
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
