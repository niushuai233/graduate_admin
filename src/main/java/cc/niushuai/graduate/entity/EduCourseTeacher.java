package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * 课程讲师关联
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-07 22:06:27
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduCourseTeacher implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 课程id
     */
    private Long courseId;


    /**
     * 讲师id
     */
    private Long teacherId;


}
