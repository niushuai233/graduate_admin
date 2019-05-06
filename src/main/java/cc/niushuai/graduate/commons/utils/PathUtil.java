package cc.niushuai.graduate.commons.utils;

/**
 * 存储各种路径
 */
public class PathUtil {

    public static String http = "http://IP:PORT/";

    /**
     * fastdfs 访问路径
     */
    public static String fdfsAccessPrefix = "";


    /**
     * 填充为完整的fdfs访问路径
     *
     * @param fullPath
     * @return
     */
    public static String fillFdfsPath(String fullPath) {
        return fdfsAccessPrefix + fullPath;
    }

    /**
     * 问答详情路径(需要拼接前缀)
     */
    public static String questionInfoPath = "/questions/info/";
    /**
     * 问答详情路径(前缀)
     */
    public static String questionInfoPrefix = "";

    /**
     * 跳转到前台访问路径
     *
     * @return
     */
    public static String getQuestionInfoPath() {
        return questionInfoPrefix + questionInfoPath;
    }
}
