package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduArticle;
import cc.niushuai.graduate.mapper.EduArticleMapper;
import cc.niushuai.graduate.service.EduArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author niush
 */
@Slf4j
@Service("eduArticleService")
@Transactional
public class EduArticleServiceImpl extends BaseServiceImpl<EduArticle> implements EduArticleService {
    @Autowired
    private EduArticleMapper eduArticleMapper;

    @Override
    public EduArticle get(Integer articleId) {
        return eduArticleMapper.get(articleId);
    }

    @Override
    public List<EduArticle> getList(Map<String, Object> map) {
        return eduArticleMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduArticleMapper.getCount(map);
    }

    @Override
    public void save(EduArticle eduArticle) {
        super.addValue(eduArticle, false, 0);
        eduArticle.setPublishTime(new Date());
        eduArticleMapper.save(eduArticle);
    }

    @Override
    public void update(EduArticle eduArticle) {
        super.addValue(eduArticle, false, 1);
        eduArticle.setUpdateDate(new Date());
        eduArticleMapper.update(eduArticle);
    }

    @Override
    public void delete(Integer articleId) {
        eduArticleMapper.delete(articleId);
    }

    @Override
    public void deleteBatch(Integer[] articleIds) {
        eduArticleMapper.deleteBatch(articleIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduArticle eduArticle = get(id);
            eduArticle.setState(Integer.valueOf(stateValue));
            eduArticle.setUpdateDate(new Date());
            update(eduArticle);
        }
    }

}
