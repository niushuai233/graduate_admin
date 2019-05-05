package cc.niushuai.graduate.quartz.job;

import cc.niushuai.graduate.commons.utils.ApplicationContextUtils;
import cc.niushuai.graduate.commons.utils.MailSendHelper;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Description:
 * @Author ns
 * @Date 2019/5/5 10:42
 */
@Slf4j
public class MailSendJob implements Job {
    /**
     * @description: job 类执行入口
     * @params: [context]
     * @author: ns
     * @date: 2019/5/5 10:42
     */
    @Override
    public void execute(JobExecutionContext context) {
        log.info("定时执行邮件发送开始：" + DateUtil.now());
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        String[] emails = (String[]) mergedJobDataMap.get("emails");
        String title = (String) mergedJobDataMap.get("title");
        String content = (String) mergedJobDataMap.get("content");
        String from = (String) mergedJobDataMap.get("from");
        log.info("邮件信息准备完毕");
        JavaMailSender javaMailSender = ApplicationContextUtils.getBean(JavaMailSender.class);
        log.info("获取发送机, {}", javaMailSender);
        try {
            log.info("开始发送邮件");
            MailSendHelper.sendMimeMessage(javaMailSender, emails, title, content, from);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("邮件发送失败, {}", e.getMessage());
        }
    }

}
