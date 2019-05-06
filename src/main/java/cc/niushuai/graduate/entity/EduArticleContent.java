package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 文章内容表
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 01:07:31
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduArticleContent implements Serializable {
	private static final long serialVersionUID = 1L;
	



	/**
	 *
	 * 文章ID
	 */
		private Integer articleId;



	/**
	 *
	 * 文章内容
	 */
		private String content;


}
