package cc.niushuai.graduate.commons.utils;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 提供Quartz的cron表达式与Date之间的转换
 *
 * @author niushuai
 */
public class CronDateUtils {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    /***
     *
     * @param date 时间
     * @return cron类型的日期
     */
    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     *
     * @param cron Quartz cron的类型的日期
     * @return Date日期
     */
    public static Date getDate(final String cron) {

        if (cron == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        Date date;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            // 此处缺少异常处理,自己根据需要添加
            return null;
        }
        return date;
    }

    public static void main(String[] args) {
        String cron = CronDateUtils.getCron(new Date());
        System.out.println(cron);
        Date date = CronDateUtils.getDate(cron);
        System.out.println(DateUtil.formatDateTime(date));
    }
}
