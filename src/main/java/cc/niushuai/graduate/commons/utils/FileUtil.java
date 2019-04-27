package cc.niushuai.graduate.commons.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author niushuai
 * 2017/11/18.
 */
public class FileUtil {
    /**
     * 判断文件是否为图片
     *
     * @param fileName 文件名
     * @return 检查后的结果
     * @throws Exception
     * @author niushuai
     */
    public static boolean isPicture(String fileName) throws Exception {
        // 文件名称为空的场合
        if (StringUtils.isEmpty(fileName)) {
            // 返回不和合法
            return false;
        }
        // 获得文件后缀名
        String tmpName = fileName.substring(fileName.lastIndexOf(".") + 1
        );
        // 声明图片后缀名数组
        String[] imgeArray = {"bmp", "gif", "jpe", "jpeg", "jpg", "png", "tif", "tiff", "ico"};
        // 遍历名称数组
        for (int i = 0; i < imgeArray.length; i++) {
            // 判断单个类型文件的场合
            if (imgeArray[i].equals(tmpName.toLowerCase())) {
                return true;
            }

        }
        return false;
    }
}
