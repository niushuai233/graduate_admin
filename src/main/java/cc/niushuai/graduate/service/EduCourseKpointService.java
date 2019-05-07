package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduCourseKpoint;

import java.util.List;
import java.util.Map;

/**
 * 章节管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 02:51:58
 */
public interface EduCourseKpointService extends BaseService<EduCourseKpoint> {

    EduCourseKpoint get(Integer kpointId);

    List<EduCourseKpoint> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduCourseKpoint eduCourseKpoint);

    void update(EduCourseKpoint eduCourseKpoint);

    void delete(Integer kpointId);

    void deleteBatch(Integer[] kpointIds);

    void updateState(Integer[]ids, String stateValue);
}
