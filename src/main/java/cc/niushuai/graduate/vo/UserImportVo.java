package cc.niushuai.graduate.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author niush
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserImportVo implements Serializable {

    private String 学号;
    private String 姓名;
    private String 性别;
    private String 手机号;
    private String 邮箱;
}
