package cc.niushuai.graduate.service;

/**
 * email 服务发送 包含立即发送和定时发送 不包含附件内容 可以富文本显示
 *
 * @author niushuai
 * @date
 */
public interface MailService {


    /**
     * 定时发送邮件
     *
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
