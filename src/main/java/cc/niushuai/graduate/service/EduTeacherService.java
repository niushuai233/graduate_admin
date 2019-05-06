package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduTeacher;

import java.util.List;
import java.util.Map;

/**
 * 讲师
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-05 23:22:24
 */
public interface EduTeacherService extends BaseService<EduTeacher> {

    EduTeacher get(Long id);

    List<EduTeacher> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduTeacher eduTeacher);

    void update(EduTeacher eduTeacher);

    void delete(Long id);

    void deleteBatch(Long[] ids);

    void updateState(Long[] ids, String stateValue);
}
