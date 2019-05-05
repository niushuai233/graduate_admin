package cc.niushuai.graduate.quartz.job;

import cc.niushuai.graduate.commons.utils.ApplicationContextUtils;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.mail.SimpleMailMessage;
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
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("定时执行邮件发送开始：" + DateUtil.now());
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        String[] emails = (String[]) mergedJobDataMap.get("emails");
        String title = (String) mergedJobDataMap.get("title");
        String content = (String) mergedJobDataMap.get("content");
        String from = (String) mergedJobDataMap.get("from");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发送人
        simpleMailMessage.setFrom(from);
        // 接收人
        simpleMailMessage.setTo(emails);
        // 主题
        simpleMailMessage.setSubject(title);
        // 邮件正文
        simpleMailMessage.setText(content);
        log.info("邮件内容", JSONObject.toJSONString(simpleMailMessage));
        JavaMailSender javaMailSender = ApplicationContextUtils.getBean(JavaMailSender.class);

        javaMailSender.send(simpleMailMessage);
        log.info("邮件发送完成, {}", DateUtil.now());
    }
}
