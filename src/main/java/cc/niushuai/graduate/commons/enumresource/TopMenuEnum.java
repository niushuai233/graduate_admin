package cc.niushuai.graduate.commons.enumresource;


public enum TopMenuEnum {
    TopMenu("0", "顶级菜单"),
    TopOrg("0", "顶级部门");
    private final String desc;
    private final String code;

    TopMenuEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }
}
