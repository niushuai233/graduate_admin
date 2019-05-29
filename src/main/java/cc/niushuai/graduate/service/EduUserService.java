package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduUser;

import java.util.List;
import java.util.Map;

/**
 * 学生信息表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-13 20:58:42
 */
public interface EduUserService {

    EduUser get(Long userId);

    List<EduUser> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduUser eduUser);

    void update(EduUser eduUser);

    void delete(Long userId);

    void deleteBatch(Long[] userIds);

    void updateState(Long[] ids, String stateValue);

    boolean checkStuNoExist(String 学号);

    void initPassword(Long[] userIds);
}
