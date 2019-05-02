package cc.niushuai.graduate.commons.enumresource;

/**
 * @author niushuai
 */
public enum NavigateTypeEnum implements EnumMessage {
    /**
     * INDEX首页
     */
    INDEX("INDEX", "首页"),
    /**
     * USER个人中心
     */
    USER("USER", "个人中心"),
    /**
     * FRIENDLINK尾部友链
     */
    FRIENDLINK("FRIENDLINK", "尾部友链"),
    /**
     * TAB尾部标签
     */
    TAB("TAB", "底部标签");

    private final String code;
    private final String value;

    NavigateTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return value;
    }
}
