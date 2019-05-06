package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduQuestionsTag;

import java.util.List;
import java.util.Map;

/**
 * 问答标签
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-06 13:48:05
 */
public interface EduQuestionsTagService extends BaseService<EduQuestionsTag> {

    EduQuestionsTag get(Integer questionsTagId);

    List<EduQuestionsTag> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduQuestionsTag eduQuestionsTag);

    void update(EduQuestionsTag eduQuestionsTag);

    void delete(Integer questionsTagId);

    void deleteBatch(Integer[] questionsTagIds);

    void updateState(Integer[] ids, String stateValue);
}
