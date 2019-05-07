package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.entity.EduArticle;
import cc.niushuai.graduate.entity.EduArticleContent;
import cc.niushuai.graduate.mapper.EduArticleContentMapper;
import cc.niushuai.graduate.mapper.EduArticleMapper;
import cc.niushuai.graduate.service.EduArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private EduArticleContentMapper eduArticleContentMapper;

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
        saveContent(eduArticle);
    }

    /**
     * @description: 保存content内容
     * @params: [eduArticle]
     * @author: ns
     * @date: 2019/5/7 13:18
     */
    private void saveContent(EduArticle eduArticle) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", eduArticle.getTitle());
        map.put("imageUrl", eduArticle.getImageUrl());
        Query query = new Query(map, false);
        List<EduArticle> eduArticles = getList(query);
        if (!CollectionUtils.isEmpty(eduArticles)) {
            EduArticleContent content = new EduArticleContent();
            content.setArticleId(eduArticles.get(0).getArticleId());
            content.setContent(eduArticle.getHtml());
            eduArticleContentMapper.save(content);
        }
    }

    @Override
    public void update(EduArticle eduArticle) {
        super.addValue(eduArticle, false, 1);
        eduArticle.setUpdateDate(new Date());
        eduArticleMapper.update(eduArticle);

        updateContent(eduArticle);
    }

    private void updateContent(EduArticle eduArticle) {
        Map<String, Object> map = new HashMap<>();
        map.put("articleId", eduArticle.getArticleId());
        Query query = new Query(map, false);
        List<EduArticleContent> eduArticleContents = eduArticleContentMapper.getList(query);
        if (!CollectionUtils.isEmpty(eduArticleContents)) {
            EduArticleContent content = eduArticleContents.get(0);
            content.setContent(eduArticle.getHtml());
            eduArticleContentMapper.update(content);
        }
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
