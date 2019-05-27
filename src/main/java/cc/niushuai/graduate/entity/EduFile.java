package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-23 12:14:26
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduFile implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     *
     *
     */
    private Long id;


    /**
     *
     *
     */
    private String name;


    /**
     *
     *
     */
    private String url;


    /**
     *
     *
     */
    private Long courseid;


}
