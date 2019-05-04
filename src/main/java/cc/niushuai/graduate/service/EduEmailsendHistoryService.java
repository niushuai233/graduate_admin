package cc.niushuai.graduate.service;

import cc.niushuai.graduate.commons.utils.ResultUtil;
import cc.niushuai.graduate.entity.EduEmailsendHistory;

import java.util.List;
import java.util.Map;

/**
 * 邮件发送记录
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-03 12:16:04
 */
public interface EduEmailsendHistoryService extends BaseService<EduEmailsendHistory>{
	
	EduEmailsendHistory get(Integer id);
	
	List<EduEmailsendHistory> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EduEmailsendHistory eduEmailsendHistory);
	
	void update(EduEmailsendHistory eduEmailsendHistory);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    void updateState(Integer[] ids, String stateValue);

    ResultUtil sendEmail(String email, String title, String sendTime, String type, String markdown, String html);
}
