package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.utils.ListStringUtils;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.entity.EduEmailsendHistory;
import cc.niushuai.graduate.mapper.EduEmailsendHistoryMapper;
import cc.niushuai.graduate.service.EduEmailsendHistoryService;
import cc.niushuai.graduate.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;


/**
 * @author niushuai
 */
@Slf4j
@Service("eduEmailsendHistoryService")
@Transactional(rollbackFor = Exception.class)
public class EduEmailsendHistoryServiceImpl extends BaseServiceImpl<EduEmailsendHistory> implements EduEmailsendHistoryService {

    @Autowired
    private EduEmailsendHistoryMapper eduEmailsendHistoryMapper;

    @Autowired
    private MailService mailService;

    @Override
    public EduEmailsendHistory get(Integer id) {
        return eduEmailsendHistoryMapper.get(id);
    }

    @Override
    public List<EduEmailsendHistory> getList(Map<String, Object> map) {
        return eduEmailsendHistoryMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduEmailsendHistoryMapper.getCount(map);
    }

    @Override
    public void save(EduEmailsendHistory eduEmailsendHistory) {
        super.addValue(eduEmailsendHistory, false, 0);
        eduEmailsendHistoryMapper.save(eduEmailsendHistory);
    }

    @Override
    public void update(EduEmailsendHistory eduEmailsendHistory) {
        super.addValue(eduEmailsendHistory, false, 1);
        eduEmailsendHistory.setUpdateDate(new Date());
        eduEmailsendHistoryMapper.update(eduEmailsendHistory);
    }

    @Override
    public void delete(Integer id) {
        eduEmailsendHistoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        eduEmailsendHistoryMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduEmailsendHistory eduEmailsendHistory = get(id);
            eduEmailsendHistory.setStatus(Integer.valueOf(stateValue));
            eduEmailsendHistory.setUpdateDate(new Date());
            update(eduEmailsendHistory);
        }
    }

    /**
     * 邮件发送
     *
     * @param email
     * @param title
     * @param sendTime
     * @param type
     * @param markdown
     * @param html
     * @return
     */
    @Override
    public ResultUtil sendEmail(String email, String title, String sendTime, String type, String markdown, String html) {
        // 将每一个email分开
        String[] emails = ListStringUtils.string2Array(email);
        Map<String, Object> idAndEmail = getEmailsFromIdAndEmail(emails);
        // 需要发送的内容
        String emailKey = "emails";

        emails = (String[]) idAndEmail.get(emailKey);
        idAndEmail.remove(emailKey);

        /**
         * 判断类别 识别发送方式
         */
        int status = 1; // 发送成功
        if (Constant.NUMBER_1.equalsIgnoreCase(type)) {
            boolean sendFlag = mailService.sendMailImmediately(emails, title, html);
            // 发送失败 状态位0
            if (!sendFlag) {
                status = 0;
            }
            save2db(idAndEmail, title, markdown, html, status);
        } else if (Constant.NUMBER_2.equalsIgnoreCase(type)) {
            boolean sendFlag = mailService.sendMailTiming(emails, title, html, sendTime);
            // 定时失败 发送失败
            status = 2; // 待发送
            if (!sendFlag) {
                status = 0;
            }
            save2db(idAndEmail, title, sendTime, markdown, html, status);
        }

        return ResultUtil.ok();
    }

    /**
     * @description: 立即发送存储
     * @params: [idAndEmail, markdown, html]
     * @author: ns
     * @date: 2019/5/5 13:19
     */
    private void save2db(Map<String, Object> idAndEmail, String title, String markdown, String html, int status) {
        Set<String> keySet = idAndEmail.keySet();
        for (String key : keySet) {
            String value = (String) idAndEmail.get(key);
            EduEmailsendHistory history = new EduEmailsendHistory();
            history.setUserId(Integer.valueOf(key));
            history.setEmail(value);
            history.setTitle(title);
            history.setContent(markdown);
            history.setMarkdown(markdown);
            history.setHtml(html);
            history.setSendTime(new Date());
            history.setStatus(status);
            history.setType(1);
            save(history);
        }
    }

    /**
     * @description: 定时发送存储
     * @params: [idAndEmail, sendTime, markdown, html]
     * @author: ns
     * @date: 2019/5/5 13:19
     */
    private void save2db(Map<String, Object> idAndEmail, String title, String sendTime, String markdown, String html, int status) {

        Set<String> keySet = idAndEmail.keySet();
        // 将发送时间包装成date
        Date parseDate;
        try {
            parseDate = DateUtils.parseDate(sendTime, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            log.error("包装Date出错: {}", e.getMessage());
            parseDate = new Date();
        }
        for (String key : keySet) {
            String value = (String) idAndEmail.get(key);
            EduEmailsendHistory history = new EduEmailsendHistory();
            history.setUserId(Integer.valueOf(key));
            history.setEmail(value);
            history.setTitle(title);
            history.setContent(markdown);
            history.setMarkdown(markdown);
            history.setHtml(html);
            history.setSendTime(parseDate);
            history.setStatus(status);
            history.setType(2);
            save(history);
        }
    }


    /**
     * @description: 将分离过的id|email 根据|再次分离
     * 并且将分离过后的结果放到map中
     * @params: [emails]
     * @author: ns
     * @date: 2019/5/5 12:55
     */
    private Map<String, Object> getEmailsFromIdAndEmail(String[] emails) {
        Map<String, Object> emailsMap = new HashMap<>();
        List<String> toList = new ArrayList<>();
        for (String email : emails) {
            String[] split = new String[2];
            split[0] = email.substring(0, email.indexOf("|"));
            split[1] = email.substring(email.indexOf("|") + 1);
            // 正确分离出的长度应该是2 如果不是2  下面的代码直接跳过 不能正常走通  否则则数组下标越界异常
            if (Constant.NUMBER_2_INT == split.length) {
                toList.add(split[1]);
                emailsMap.put(split[0], split[1]);
            }
        }
        emailsMap.put("emails", ListStringUtils.list2StringArray(toList));
        return emailsMap;
    }


}
