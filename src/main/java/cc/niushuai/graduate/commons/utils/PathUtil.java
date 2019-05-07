package cc.niushuai.graduate.commons.utils;

/**
 * 存储各种路径
 */
public class PathUtil {

    public static String http = "http://IP:PORT/";

    /**
     * 前台项目地址(前缀)
     */
    public static String frontPath = "";

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
     * 文章详情路径(需要拼接前缀)
     */
    public static String articleAccessPath = "/front/articleinfo/";

    /**
     * 课程详情路径(需要拼接前缀)
     */
    public static String courseAccessPath = "/front/couinfo/";

    /**
     * 跳转到文章详情页
     *
     * @return
     */
    public static String getArticleAccessPath() {
        return frontPath + articleAccessPath;
    }

    /**
     * 跳转到课程详情页
     * @return
     */
    public static String getCourseAccessPath() {
        return frontPath + courseAccessPath;
    }


    /**
     * 跳转到问答访问路径
     *
     * @return
     */
    public static String getQuestionInfoPath() {
        return frontPath + questionInfoPath;
    }
}
