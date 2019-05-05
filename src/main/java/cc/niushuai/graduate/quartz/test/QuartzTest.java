package cc.niushuai.graduate.quartz.test;

import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.utils.CronDateUtils;
import cc.niushuai.graduate.entity.EduEmailsendHistory;
import cc.niushuai.graduate.quartz.job.MailSendJob;
import cn.hutool.core.date.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Description:
 * @Author ns
 * @Date 2019/5/5 10:41
 */
public class QuartzTest {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MailSendJob.class)
                .withIdentity(Constant.MAIL_SEND_JOB_DETAIL_IDENTITY, Scheduler.DEFAULT_GROUP)
                .build();

        String cron = CronDateUtils.getCron(DateUtil.offsetSecond(new Date(), 30));
        System.out.println(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(Constant.MAIL_SEND_CRON_TRIGGER_IDENTITY)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();

        JobDataMap jobDataMap = cronTrigger.getJobDataMap();
        EduEmailsendHistory history = new EduEmailsendHistory();
        history.setEmail("1225803134@qq.com");
        jobDataMap.put("emails", history);

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Date date = scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();

        System.out.println(DateUtil.formatDateTime(date));

    }
}
