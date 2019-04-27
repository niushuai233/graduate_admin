package cc.niushuai.graduate.commons.enumresource;

public enum ReverseStateEnum implements EnumMessage {
    ENABLE("0", "启用"),
    DIASABLE("1", "禁用");
    private final String code;
    private final String value;

    private ReverseStateEnum(String code, String value) {
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
