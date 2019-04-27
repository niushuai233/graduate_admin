package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 图片类型表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
@Data
public class EduWebsiteImagesType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    private Integer typeId;
    /**
     * 类型名
     */
    private String typeName;
    /**
     * 状态 0禁用 1启用
     */
    private Integer state;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;


}
