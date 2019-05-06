package cc.niushuai.graduate.commons.constant;

import java.util.UUID;

/**
 * @ClassName Constant
 * @Description:
 * @Author niushuai
 * @email niushuai951101@gmail.com
 * @Date 2019/3/13
 */
public class Constant {

    /**
     * @description: 时间格式化样式
     * @params:
     * @author: ns
     * @date: 2019/5/5 13:41
     */
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String randomUUID = UUID.randomUUID().toString();

    /**
     * 主键
     */
    public static final String ID = "id";

    /**
     * 基本类型
     */
    public static final String BYTE_TYPE = "java.lang.Byte";
    public static final String SHORT_TYPE = "java.lang.Short";
    public static final String INTEGER_TYPE = "java.lang.Integer";
    public static final String LONG_TYPE = "java.lang.Long";
    public static final String BOOLEAN_TYPE = "java.lang.Boolean";
    public static final String FLOAT_TYPE = "java.lang.Float";
    public static final String DOUBLE_TYPE = "java.lang.Double";
    public static final String STRING_TYPE = "java.lang.String";

    /**
     * 通用字段
     */
    public static final String CREATE_BY = "createBy";
    public static final String CREATE_DATE = "createDate";
    public static final String CREATE_TIME = "createTime";
    public static final String UPDATE_BY = "updateBy";
    public static final String UPDATE_DATE = "updateDate";
    public static final String UPDATE_TIME = "updateTime";


    /**
     * 文件名称
     */
    public static final String MAIN_CONFIG_YAML = "application.yml";
    public static final String PROFILES_CONFIG_YAML = "application-mysql.yml";

    /**
     * keys
     */
    public static final String FDFS_TRACKER_URL = "fdfs.trackerList";
    public static final String IP_STRING_KEY = "IP";
    public static final String PORT_STRING_KEY = "PORT";
    public static final String HTTP_PORT = "80";
    public static final String FDFS_ACCESS_PREFIX = "fdfsAccessPrefix";

    public static final String DEFAULT_CROPPERJS_IMAGE = "/statics/plugins/cropperjs/images/picture.jpg";

    /**
     * 数字keys
     */
    public static final String NUMBER_0 = "0";
    public static final String NUMBER_1 = "1";
    public static final String NUMBER_2 = "2";
    public static final String NUMBER_3 = "3";
    public static final String NUMBER_4 = "4";
    public static final String NUMBER_5 = "5";
    public static final String NUMBER_6 = "6";
    public static final String NUMBER_7 = "7";
    public static final String NUMBER_8 = "8";
    public static final String NUMBER_9 = "9";

    /**
     * 数字keys
     */
    public static final int NUMBER_0_INT = 0;
    public static final int NUMBER_1_INT = 1;
    public static final int NUMBER_2_INT = 2;
    public static final int NUMBER_3_INT = 3;
    public static final int NUMBER_4_INT = 4;
    public static final int NUMBER_5_INT = 5;
    public static final int NUMBER_6_INT = 6;
    public static final int NUMBER_7_INT = 7;
    public static final int NUMBER_8_INT = 8;
    public static final int NUMBER_9_INT = 9;

    /**
     * @description: 定时任务使用
     * @author: ns
     * @date: 2019/5/5 11:17
     */
    public static final String MAIL_SEND_JOB_DETAIL_IDENTITY = "mailSendJobDefaultIdentity";
    public static final String MAIL_SEND_CRON_TRIGGER_IDENTITY = "cronTriggerIdentity";

    /**
     * @description: 一堆可以用作分隔符的符号
     * @params:
     * @author: ns
     * @date: 2019/5/5 13:04
     */
    public static final String REGEX_LINE = "|";
    public static final String REGEX_POINT = ".";
    public static final String REGEX_COMMA = ",";
    public static final String REGEX_PERCENT = "%";
    public static final String REGEX_DOLLAR = "$";
    public static final String REGEX_RMD = "￥";
    public static final String REGEX_ASTERISK = "*";
    public static final String REGEX_LEFT_BRACKETS = "(";
    public static final String REGEX_RIGHT_BRACKETS = ")";
    public static final String REGEX_SMALL_RIGHT_BRACKETS = "}";
    public static final String REGEX_BIG_RIGHT_BRACKETS = "}";
    public static final String REGEX_AI_TE = "@";
    public static final String REGEX_EXCLAMATION_MARK = "!";
    public static final String REGEX_ADD_MARK = "+";
    public static final String REGEX_MINUS_MARK = "-";
    public static final String REGEX_POSITIVE_SLASH = "/";
    public static final String REGEX_BACKSLASH = "\\";


}
