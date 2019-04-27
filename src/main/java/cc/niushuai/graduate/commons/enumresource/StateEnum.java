package cc.niushuai.graduate.commons.enumresource;

public enum StateEnum implements EnumMessage {
    ENABLE("1", "启用"),
    DIASABLE("0", "禁用");
    private final String code;
    private final String value;

    private StateEnum(String code, String value) {
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
