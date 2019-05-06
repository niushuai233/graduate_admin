package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 问答评论
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 00:16:25
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduQuestionsComment implements Serializable {
	private static final long serialVersionUID = 1L;
	



	/**
	 *
	 * 主键id
	 */
		private Long id;



	/**
	 *
	 * 评论人id
	 */
		private Long cusId;



	/**
	 *
	 * 评论人昵称
	 */
		private String cusName;



	/**
	 *
	 * 问答id
	 */
		private Long questionId;



	/**
	 *
	 * 评论内容
	 */
		private String content;



	/**
	 *
	 * 是否最佳答案 0否1是
	 */
		private Integer isBest;



	/**
	 *
	 * 回复数量
	 */
		private Long replyCount;



	/**
	 *
	 * 点赞数
	 */
		private Long praiseCount;



	/**
	 *
	 * 回复时间
	 */
		@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
		private Date addTime;



	/**
	 *
	 * 父级评论id
	 */
		private Long commentId;



	/**
	 *
	 * 0禁用 1启用
	 */
		private Integer state;



	/**
	 *
	 * 更新时间
	 */
		@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
		private Date updateTime;



	/**
	 *
	 * 更新人
	 */
		private String updateBy;


}
