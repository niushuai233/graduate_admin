package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.constant.Constant;
import cc.niushuai.graduate.commons.utils.ListStringUtils;
import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.entity.EduEmailsendHistory;
import cc.niushuai.graduate.mapper.EduEmailsendHistoryMapper;
import cc.niushuai.graduate.service.EduEmailsendHistoryService;
import cc.niushuai.graduate.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author niushuai
 */
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
        String[] emails = ListStringUtils.string2Array(email);

        /**
         * 判断类别 识别发送方式
         */
        if (Constant.NUMBER_1.equalsIgnoreCase(type)) {
            mailService.sendMailImmediately(emails, title, html);
        } else if (Constant.NUMBER_2.equalsIgnoreCase(type)) {
            mailService.sendMailTiming(emails, title, html, sendTime);
        }

        return ResultUtil.ok();
    }

}
