package cc.niushuai.graduate.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * 邮件发送帮助类
 *
 * @author niushuai
 */
@Slf4j
public class MailSendHelper {

    /**
     * 发送富文本邮件
     *
     * @param emails
     * @param title
     * @param content
     * @param from
     */
    public static void sendMimeMessage(JavaMailSender javaMailSender, String[] emails, String title, String content, String from) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(emails);
        helper.setSubject(title);
        helper.setText(content, true);
        log.info("邮件发送中...");
        javaMailSender.send(mimeMessage);
        log.info("邮件发送完毕");

    }

    /**
     * 发送简单邮件
     *
     * @param javaMailSender
     * @param emails
     * @param title
     * @param content
     * @param from
     */
    public static void sendSimpleMessage(JavaMailSender javaMailSender, String[] emails, String title, String content, String from) throws Exception {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发送人
        simpleMailMessage.setFrom(from);
        // 接收人
        simpleMailMessage.setTo(emails);
        // 主题
        simpleMailMessage.setSubject(title);
        // 邮件正文
        simpleMailMessage.setText(content);

        javaMailSender.send(simpleMailMessage);
    }
}
