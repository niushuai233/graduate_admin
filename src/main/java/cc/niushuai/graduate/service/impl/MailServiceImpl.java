package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件发送实现类
 * @author niushuai
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void testSend(String... to){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发送人
        simpleMailMessage.setFrom(username);
        // 接收人
        simpleMailMessage.setTo(to);
        // 主题
        simpleMailMessage.setSubject("Hello Baby");

        simpleMailMessage.setText("Hello World this is a test mail");

        javaMailSender.send(simpleMailMessage);
    }
}
