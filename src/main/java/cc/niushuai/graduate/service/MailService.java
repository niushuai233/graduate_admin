package cc.niushuai.graduate.service;

/**
 * email 服务配置
 *
 * @author niushuai
 * @date
 */
public interface MailService {

    /**
     * 发送邮件才测试类
     *
     * @param to
     */
    void testSend(String... to);

    /**
     * 定时发送邮件
     * @param emails
     * @param title
     * @param content
     * @param sendTime
     * @return
     */
    boolean sendMailTiming(String[] emails, String title, String content, String sendTime);

    /**
     * 立即发送邮件
     *
     * @param emails
     * @param title
     * @param content
     * @return
     */
    boolean sendMailImmediately(String[] emails, String title, String content);
}
