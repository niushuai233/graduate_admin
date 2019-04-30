package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduWebsiteProfile;

import java.util.List;
import java.util.Map;

/**
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-04-29 12:58:02
 */
public interface EduWebsiteProfileService extends BaseService<EduWebsiteProfile> {

    EduWebsiteProfile get(Integer id);

    List<EduWebsiteProfile> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduWebsiteProfile eduWebsiteProfile);

    void update(EduWebsiteProfile eduWebsiteProfile);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    void updateState(Integer[] ids, String stateValue);
}
