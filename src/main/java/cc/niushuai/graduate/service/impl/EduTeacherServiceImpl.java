package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduTeacher;
import cc.niushuai.graduate.mapper.EduTeacherMapper;
import cc.niushuai.graduate.service.EduTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 讲师 service实现类
 *
 * @author niushuai
 */
@Slf4j
@Service("eduTeacherService")
@Transactional
public class EduTeacherServiceImpl extends BaseServiceImpl<EduTeacher> implements EduTeacherService {
    @Autowired
    private EduTeacherMapper eduTeacherMapper;

    @Override
    public EduTeacher get(Long id) {
        return eduTeacherMapper.get(id);
    }

    @Override
    public List<EduTeacher> getList(Map<String, Object> map) {
        return eduTeacherMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduTeacherMapper.getCount(map);
    }

    @Override
    public void save(EduTeacher eduTeacher) {
        super.addValue(eduTeacher, false, 0);
        eduTeacherMapper.save(eduTeacher);
    }

    @Override
    public void update(EduTeacher eduTeacher) {
        super.addValue(eduTeacher, false, 1);
        eduTeacher.setUpdateTime(new Date());
        eduTeacherMapper.update(eduTeacher);
    }

    @Override
    public void delete(Long id) {
        eduTeacherMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        eduTeacherMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Long[] ids, String stateValue) {
        for (Long id : ids) {
            EduTeacher eduTeacher = get(id);
            eduTeacher.setStatus(Integer.valueOf(stateValue));
            eduTeacher.setUpdateTime(new Date());
            update(eduTeacher);
        }
    }

}
