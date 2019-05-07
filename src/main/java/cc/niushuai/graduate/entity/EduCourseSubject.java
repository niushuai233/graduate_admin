package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 22:08:20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduCourseSubject implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     *
     */
    private Long id;


    /**
     * 课程id
     */
    private Long courseId;


    /**
     * 分类id
     */
    private Long subjectId;


}
