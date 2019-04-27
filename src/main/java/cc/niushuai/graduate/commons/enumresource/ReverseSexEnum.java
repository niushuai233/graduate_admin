package cc.niushuai.graduate.commons.enumresource;


public enum ReverseSexEnum implements EnumMessage {

    MEN("男", "1"),
    WOMEN("女", "2"),
    UNKNOWN("保密", "0");

    private final String code;
    private final String value;

    ReverseSexEnum(String code, String value) {
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
