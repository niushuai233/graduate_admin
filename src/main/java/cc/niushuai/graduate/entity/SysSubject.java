package cc.niushuai.graduate.entity;

import cc.niushuai.graduate.entity.admin.SysMenu;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 专业信息
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 12:46:32
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysSubject implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long subjectId;
    /**
     * 专业名称
     */
    private String subjectName;
    /**
     * 父ID
     */
    private Long parentId;

    /**
     * @description: `父级菜单
     * @params: `
     * @author: ns `
     * @date: 2019/5/6 12:59 `
     */
    private String parentName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态 0:默认 1:删除
     */
    private Integer status;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 创建时间
     */

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * ztree属性
     */
    private Boolean open;

    private List<?> list;

    private List<SysMenu> children;

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }


}
