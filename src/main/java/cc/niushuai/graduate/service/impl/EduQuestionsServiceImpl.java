package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.ShiroUtils;
import cc.niushuai.graduate.entity.EduQuestions;
import cc.niushuai.graduate.mapper.EduQuestionsMapper;
import cc.niushuai.graduate.service.EduQuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 问答
 *
 * @author niushuai
 */
@Slf4j
@Service("eduQuestionsService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduQuestionsServiceImpl extends BaseServiceImpl<EduQuestions> implements EduQuestionsService {
    @Autowired
    private EduQuestionsMapper eduQuestionsMapper;

    @Override
    public EduQuestions get(Long id) {
        return eduQuestionsMapper.get(id);
    }

    @Override
    public List<EduQuestions> getList(Map<String, Object> map) {
        return eduQuestionsMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduQuestionsMapper.getCount(map);
    }

    @Override
    public void save(EduQuestions eduQuestions) {
        super.addValue(eduQuestions, false, 0);
        eduQuestions.setAddTime(new Date());
        eduQuestions.setCusId(ShiroUtils.getUserId());
        eduQuestions.setContent(eduQuestions.getEditormdDiv_html_code());
        eduQuestionsMapper.save(eduQuestions);
    }

    @Override
    public void update(EduQuestions eduQuestions) {
        super.addValue(eduQuestions, false, 1);
        eduQuestions.setUpdateTime(new Date());
        eduQuestions.setContent(eduQuestions.getEditormdDiv_html_code());
        eduQuestionsMapper.update(eduQuestions);
    }

    @Override
    public void delete(Long id) {
        eduQuestionsMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        eduQuestionsMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            EduQuestions eduQuestions = get(id);
            eduQuestions.setState(Integer.valueOf(stateValue));
            eduQuestions.setUpdateTime(new Date());
            update(eduQuestions);
        }
    }

}
