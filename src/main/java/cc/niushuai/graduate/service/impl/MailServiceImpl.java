package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件发送实现类
 *
 * @author niushuai
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void testSend(String... to) {

    }

    /**
     * 简单的邮件主题
     *
     * @param to 接收人
     * @param title 主题
     * @param content 正文
     * @return
     */
    private SimpleMailMessage getSimpleMailMessage(String[] to, String title, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发送人
        simpleMailMessage.setFrom(username);
        // 接收人
        simpleMailMessage.setTo(to);
        // 主题
        simpleMailMessage.setSubject(title);
        // 邮件正文
        simpleMailMessage.setText(content);
        return simpleMailMessage;
    }

    /**
     * 定时发送
     *
     * @param emails
     * @param title
     * @param content
     * @param sendTime
     * @return
     */
    @Override
    public boolean sendMailTiming(String[] emails, String title, String content, String sendTime) {
        try {
            SimpleMailMessage simpleMailMessage = getSimpleMailMessage(emails, title, content);
            javaMailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            log.error("立即发送邮件失败: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 立即发送
     *
     * @param emails
     * @param title
     * @param content
     * @return
     */
    @Override
    public boolean sendMailImmediately(String[] emails, String title, String content) {
        try {
            SimpleMailMessage simpleMailMessage = getSimpleMailMessage(emails, title, content);
            javaMailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            log.error("立即发送邮件失败: {}", e.getMessage());
            return false;
        }
    }

}
