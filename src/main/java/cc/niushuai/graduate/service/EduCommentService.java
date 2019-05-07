package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduComment;

import java.util.List;
import java.util.Map;

/**
 * 课程评论
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:59:37
 */
public interface EduCommentService extends BaseService<EduComment> {

    EduComment get(Long commentId);

    List<EduComment> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduComment eduComment);

    void update(EduComment eduComment);

    void delete(Long commentId);

    void deleteBatch(Long[] commentIds);

    void updateState(Long[]ids, String stateValue);
}
