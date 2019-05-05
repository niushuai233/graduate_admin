package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 22:47:34
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduWebsiteEhcache implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * 主键
	 */
	private Integer id;
	/**
	 *
	 * ehcache key
	 */
	private String ehcacheKey;
	/**
	 *
	 * 描述
	 */
	private String ehcacheDesc;


}
