package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduWebsiteNavigate;

import java.util.List;
import java.util.Map;

/**
 * 导航表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-02 17:16:49
 */
public interface EduWebsiteNavigateService extends BaseService<EduWebsiteNavigate> {

    EduWebsiteNavigate get(Integer id);

    List<EduWebsiteNavigate> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduWebsiteNavigate eduWebsiteNavigate);

    void update(EduWebsiteNavigate eduWebsiteNavigate);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    void updateState(Integer[] ids, String stateValue);
}
