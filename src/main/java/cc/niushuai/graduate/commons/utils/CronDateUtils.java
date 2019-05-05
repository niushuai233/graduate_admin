package cc.niushuai.graduate.commons.utils;

import cc.niushuai.graduate.commons.constant.Constant;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.quartz.CronExpression;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 提供Quartz的cron表达式与Date之间的转换
 *
 * @author niushuai
 */
@Slf4j
public class CronDateUtils {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    public static String getCron(final String dateStr) {
        Date date = null;
        try {
            date = DateUtils.parseDate(dateStr, Constant.DATE_DEFAULT_FORMAT);
        } catch (ParseException e) {
            log.error("封装时间出错");
        }
        return getCron(date);
    }

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

    /**
     * 校验定时任务格式
     *
     * @param expressionStr
     * @return
     */
    public static boolean isValidExpressionStr(String expressionStr) {
        if (StringUtils.isEmpty(expressionStr)) {
            return false;
        }
        return CronExpression.isValidExpression(expressionStr);
    }

    /**
     * 校验表达式是否能触发(相对于当前时间)
     *
     * @param expressionStr
     * @return
     * @throws ParseException
     */
    public static boolean isCanDoExpression(String expressionStr) throws ParseException {
        //先判断表达式格式是否正确
        if (!isValidExpressionStr(expressionStr)) {
            return false;
        }
        CronTriggerImpl triggerImpl = new CronTriggerImpl();
        triggerImpl.setCronExpression(expressionStr);
        Date date = triggerImpl.computeFirstFireTime(null);
        return date != null && date.after(new Date());
    }

    /**
     * 获取一段时间内可以运行日期
     *
     * @param expressionStr
     * @param beginDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static List<Date> getCanDoBetween(String expressionStr, Date beginDate, Date endDate) throws ParseException {
        //先判断表达式格式是否正确
        if (!isValidExpressionStr(expressionStr)) {
            return null;
        }
        if (endDate.before(beginDate)) {
            return null;
        }
        CronTriggerImpl triggerImpl = new CronTriggerImpl();
        triggerImpl.setCronExpression(expressionStr);
        return TriggerUtils.computeFireTimesBetween(triggerImpl, null, beginDate, endDate);

    }

    /**
     * 校验时间是否是合法时间
     *
     * @param sendTime
     * @return
     */
    public static boolean isValidDate(String sendTime) {
        try {
            return isCanDoExpression(getCron(sendTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 校验时间是否是合法时间
     *
     * @param sendTime
     * @return
     */
    public static boolean isValidDate(Date sendTime) {
        return isValidDate(DateUtil.formatDateTime(sendTime));
    }

    public static void main(String[] args) {
        String cron = CronDateUtils.getCron(new Date());
        System.out.println(cron);
        Date date = CronDateUtils.getDate(cron);
        System.out.println(DateUtil.formatDateTime(date));
    }

}
