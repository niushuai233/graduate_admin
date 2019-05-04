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
}
