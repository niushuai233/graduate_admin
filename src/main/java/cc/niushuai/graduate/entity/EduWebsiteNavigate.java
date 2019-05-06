package cc.niushuai.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 导航表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-02 17:16:49
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EduWebsiteNavigate implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 导航显示名称
     */
    private String name;
    /**
     * 导航显示位置
     */
    private String url;
    /**
     * 是否在新页面打开0是1否
     */
    private Integer newpage;
    /**
     * 类型：INDEX首页、USER个人中心、FRIENDLINK尾部友链、TAB尾部标签
     */
    private String type;
    /**
     * 显示排序
     */
    private Integer ordernum;
    /**
     * 0正常1冻结
     */
    private Integer status;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 更新日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新人
     */
    private String updateBy;


}
