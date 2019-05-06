package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduQuestionsTag;
import cc.niushuai.graduate.mapper.EduQuestionsTagMapper;
import cc.niushuai.graduate.service.EduQuestionsTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("eduQuestionsTagService")
@Transactional
public class EduQuestionsTagServiceImpl extends BaseServiceImpl<EduQuestionsTag> implements EduQuestionsTagService {
    @Autowired
    private EduQuestionsTagMapper eduQuestionsTagMapper;

    @Override
    public EduQuestionsTag get(Integer questionsTagId) {
        return eduQuestionsTagMapper.get(questionsTagId);
    }

    @Override
    public List<EduQuestionsTag> getList(Map<String, Object> map) {
        return eduQuestionsTagMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduQuestionsTagMapper.getCount(map);
    }

    @Override
    public void save(EduQuestionsTag eduQuestionsTag) {
        super.addValue(eduQuestionsTag, false, 0);
        eduQuestionsTagMapper.save(eduQuestionsTag);
    }

    @Override
    public void update(EduQuestionsTag eduQuestionsTag) {
        super.addValue(eduQuestionsTag, false, 1);
        eduQuestionsTag.setUpdateTime(new Date());
        eduQuestionsTagMapper.update(eduQuestionsTag);
    }

    @Override
    public void delete(Integer questionsTagId) {
        eduQuestionsTagMapper.delete(questionsTagId);
    }

    @Override
    public void deleteBatch(Integer[] questionsTagIds) {
        eduQuestionsTagMapper.deleteBatch(questionsTagIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduQuestionsTag eduQuestionsTag = get(id);
            eduQuestionsTag.setStatus(Integer.valueOf(stateValue));
            eduQuestionsTag.setUpdateTime(new Date());
            update(eduQuestionsTag);
        }
    }

}
