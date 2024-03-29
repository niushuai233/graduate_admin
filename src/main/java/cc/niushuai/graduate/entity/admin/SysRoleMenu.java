package cc.niushuai.graduate.entity.admin;


import java.io.Serializable;

/**
 * 角色与菜单对应关系
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 */
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 设置：
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取：角色ID
     *
     * @return Long
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置：菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取：菜单ID
     *
     * @return Long
     */
    public Long getMenuId() {
        return menuId;
    }

}
