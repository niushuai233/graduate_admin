package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduArticleContent;
import cc.niushuai.graduate.mapper.EduArticleContentMapper;
import cc.niushuai.graduate.service.EduArticleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author niush
 */
@Slf4j
@Service("eduArticleContentService")
@Transactional
public class EduArticleContentServiceImpl extends BaseServiceImpl<EduArticleContent> implements EduArticleContentService {
    @Autowired
    private EduArticleContentMapper eduArticleContentMapper;

    @Override
    public EduArticleContent get(Integer articleId) {
        return eduArticleContentMapper.get(articleId);
    }

    @Override
    public List<EduArticleContent> getList(Map<String, Object> map) {
        return eduArticleContentMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduArticleContentMapper.getCount(map);
    }

    @Override
    public void save(EduArticleContent eduArticleContent) {
        super.addValue(eduArticleContent, false, 0);
        eduArticleContentMapper.save(eduArticleContent);
    }

    @Override
    public void update(EduArticleContent eduArticleContent) {
        super.addValue(eduArticleContent, false, 1);
        eduArticleContentMapper.update(eduArticleContent);
    }

    @Override
    public void delete(Integer articleId) {
        eduArticleContentMapper.delete(articleId);
    }

    @Override
    public void deleteBatch(Integer[] articleIds) {
        eduArticleContentMapper.deleteBatch(articleIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduArticleContent eduArticleContent = get(id);
            update(eduArticleContent);
        }
    }

}
