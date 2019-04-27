package cc.niushuai.graduate.commons.utils;

import cc.niushuai.graduate.commons.enumresource.EnumMessage;

/**
 * @ClassName EnumUtil
 * @Description: 枚举工具类，通过Code返回枚举
 * @Author niushuai
 * @email niushuai951101@gmail.com
 * @Date 2019/3/13
 */
public class EnumUtil {

    /**
     * 根据code获取value值
     * @param code
     * @return
     */
    public static <T extends EnumMessage> String getValueByCode(String code, Class<T> enumClass){

        T[] enumConstants = enumClass.getEnumConstants();
        String value = "";
        for (T t : enumConstants) {
            if (code.equals(t.getCode())) {
                value = t.getValue();
                break;
            }
        }
        return value;
    }


    public static <T extends Enum> String getCodeByValue(String value, Class<T> enumClass){
        String code = "";

        T[] enumConstants = enumClass.getEnumConstants();


        return code;
    }

}
