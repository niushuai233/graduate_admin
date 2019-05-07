package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduComment;
import cc.niushuai.graduate.mapper.EduCommentMapper;
import cc.niushuai.graduate.service.EduCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 课程评论
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:59:37
 */
@Slf4j
@Service("eduCommentService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduCommentServiceImpl extends BaseServiceImpl<EduComment> implements EduCommentService {
    @Autowired
    private EduCommentMapper eduCommentMapper;

    @Override
    public EduComment get(Long commentId) {
        return eduCommentMapper.get(commentId);
    }

    @Override
    public List<EduComment> getList(Map<String, Object> map) {
        return eduCommentMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduCommentMapper.getCount(map);
    }

    @Override
    public void save(EduComment eduComment) {
        super.addValue(eduComment, false, 0);
        eduCommentMapper.save(eduComment);
    }

    @Override
    public void update(EduComment eduComment) {
        super.addValue(eduComment, false, 1);
        eduCommentMapper.update(eduComment);
    }

    @Override
    public void delete(Long commentId) {
        eduCommentMapper.delete(commentId);
    }

    @Override
    public void deleteBatch(Long[] commentIds) {
        eduCommentMapper.deleteBatch(commentIds);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            EduComment eduComment = get(id);
            update(eduComment);
        }
    }

}
