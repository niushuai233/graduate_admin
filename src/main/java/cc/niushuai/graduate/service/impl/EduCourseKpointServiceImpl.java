package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.Query;
import cc.niushuai.graduate.entity.EduCourseKpoint;
import cc.niushuai.graduate.mapper.EduCourseKpointMapper;
import cc.niushuai.graduate.mapper.EduCourseTeacherMapper;
import cc.niushuai.graduate.service.EduCourseKpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 章节管理
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 02:51:58
 */
@Slf4j
@Service("eduCourseKpointService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduCourseKpointServiceImpl extends BaseServiceImpl<EduCourseKpoint> implements EduCourseKpointService {
    @Autowired
    private EduCourseKpointMapper eduCourseKpointMapper;
    @Autowired
    private EduCourseTeacherMapper eduCourseTeacherMapper;

    @Override
    public EduCourseKpoint get(Integer kpointId) {

        EduCourseKpoint eduCourseKpoint = eduCourseKpointMapper.get(kpointId);
//        // 增加teacher的赋值
//        Map<String, Object> map = new HashMap<>();
//        map.put("", eduCourseKpoint.getKpointId());
//        eduCourseTeacherMapper.getList(new Query(map, false));

        return eduCourseKpoint;
    }

    @Override
    public List<EduCourseKpoint> getList(Map<String, Object> map) {
        return eduCourseKpointMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduCourseKpointMapper.getCount(map);
    }

    @Override
    public void save(EduCourseKpoint eduCourseKpoint) {
        super.addValue(eduCourseKpoint, false, 0);
        eduCourseKpointMapper.save(eduCourseKpoint);
    }

    @Override
    public void update(EduCourseKpoint eduCourseKpoint) {
        super.addValue(eduCourseKpoint, false, 1);

        eduCourseKpointMapper.update(eduCourseKpoint);
    }

    @Override
    public void delete(Integer kpointId) {
        eduCourseKpointMapper.delete(kpointId);
    }

    @Override
    public void deleteBatch(Integer[] kpointIds) {
        eduCourseKpointMapper.deleteBatch(kpointIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            EduCourseKpoint eduCourseKpoint = get(id);
            update(eduCourseKpoint);
        }
    }


}
