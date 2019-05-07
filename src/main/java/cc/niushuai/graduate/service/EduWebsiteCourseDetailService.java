package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduWebsiteCourseDetail;

import java.util.List;
import java.util.Map;

/**
 * 推荐课程表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:08:50
 */
public interface EduWebsiteCourseDetailService extends BaseService<EduWebsiteCourseDetail> {

    EduWebsiteCourseDetail get(Long id);

    List<EduWebsiteCourseDetail> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduWebsiteCourseDetail eduWebsiteCourseDetail);

    void update(EduWebsiteCourseDetail eduWebsiteCourseDetail);

    void delete(Long id);

    void deleteBatch(Long[] ids);

    void updateState(Long[] ids, String stateValue);

    void batchAdd(Long[] ids, String s);
}
