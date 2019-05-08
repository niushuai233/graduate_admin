package cc.niushuai.graduate.commons.utils;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list与string互转工具类
 *
 * @author niushuai
 */
public class ListStringUtils {

    public static String defaultSeparator = ",";

    /**
     * str 转 list 使用指定分隔符
     *
     * @param source
     * @param separator
     * @return
     */
    public static List<String> string2List(String source, String separator) {

        if (verifyString(source, separator)) {
            return Arrays.asList(source.split(separator));
        }
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(source);
        return stringArrayList;
    }

    /**
     * str 转 list 使用默认分隔符 ','
     *
     * @param source
     * @return
     */
    public static List<String> string2List(String source) {
        return string2List(source, defaultSeparator);
    }

    /**
     * str 转 array 使用指定分隔符
     *
     * @param source
     * @param separator
     * @return
     */
    public static String[] string2Array(String source, String separator) {
        if (verifyString(source, separator)) {
            return source.split(separator);
        }
        return new String[]{source};
    }

    /**
     * str 转 array 使用默认分隔符 ','
     *
     * @param source
     * @return
     */
    public static String[] string2Array(String source) {
        return string2Array(source, defaultSeparator);
    }

    /**
     * list 转 string 指定分隔符
     *
     * @param list
     * @param separator
     * @return
     */
    public static String list2String(List list, String separator) {
        if (!verifyList(list)) {
            return list.toString();
        }

        String result = "";
        for (Object s : list) {
            result += s + separator;
        }
        return result;
    }

    /**
     * list 转 string 使用默认分隔符 ','
     *
     * @param list
     * @return
     */
    public static String list2String(List list) {
        return list2String(list, defaultSeparator);
    }

    /**
     * 校验字符串
     *
     * @param strs
     * @return
     */
    private static boolean verifyString(String... strs) {
        return Arrays.stream(strs).allMatch(s -> StringUtils.isNotEmpty(s));
    }

    /**
     * 校验集合
     *
     * @param list
     * @return
     */
    private static boolean verifyList(List list) {
        return CollectionUtil.isNotEmpty(list);
    }

    /**
     * @description: list 转 string arr
     * @params: [toList]
     * @author: ns
     * @date: 2019/5/5 14:05
     */
    public static String[] list2StringArray(List<String> toList) {
        String[] strs = new String[toList.size()];
        for (int i = 0; i < toList.size(); i++) {
            strs[i] = toList.get(i);
        }
        return strs;
    }

    /**
     * str 数组 转 str
     *
     * @param arr
     * @param flag 是否要带引号
     * @return
     */
    public static String array2String(String[] arr, boolean flag) {
        return array2String(arr, defaultSeparator, flag);
    }

    /**
     * str 数组 转 str
     *
     * @param arr
     * @param separator
     * @param flag      是否要带引号
     * @return
     */
    public static String array2String(String[] arr, String separator, boolean flag) {
        if (null == arr) {
            return null;
        }
        StringBuffer bfr = new StringBuffer();
        String flagStr = "";
        if (flag) {
            flagStr = "'";
        }
        for (String tmp : arr) {
            bfr.append(flagStr);
            bfr.append(tmp);
            bfr.append(flagStr + separator);
        }
        return bfr.toString().substring(0, bfr.length() - 1);
    }
}
