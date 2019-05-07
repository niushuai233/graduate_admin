package cc.niushuai.graduate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Date;
import java.util.Map;

import cc.niushuai.graduate.mapper.EduCourseMapper;
import cc.niushuai.graduate.entity.EduCourse;
import cc.niushuai.graduate.service.EduCourseService;

@Slf4j
@Service("eduCourseService")
@Transactional
public class EduCourseServiceImpl extends BaseServiceImpl<EduCourse> implements EduCourseService {
	@Autowired
	private EduCourseMapper eduCourseMapper;
	
	@Override
	public EduCourse get(Long courseId){
		return eduCourseMapper.get(courseId);
	}

	@Override
	public List<EduCourse> getList(Map<String, Object> map){
		return eduCourseMapper.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return eduCourseMapper.getCount(map);
	}

	@Override
	public void save(EduCourse eduCourse){
		super.addValue(eduCourse,false,0);
		eduCourseMapper.save(eduCourse);
	}

	@Override
	public void update(EduCourse eduCourse){
		super.addValue(eduCourse,false,1);
		eduCourse.setUpdateTime(new Date());
		eduCourseMapper.update(eduCourse);
	}

	@Override
	public void delete(Long courseId){
		eduCourseMapper.delete(courseId);
	}

	@Override
	public void deleteBatch(Long[] courseIds){
		eduCourseMapper.deleteBatch(courseIds);
	}

    @Override
    public void updateState(Long[] ids,String stateValue) {
        for (Long id:ids){
			EduCourse eduCourse=get(id);
			eduCourse.setIsAvaliable(Long.valueOf(stateValue));
			eduCourse.setUpdateTime(new Date());
            update(eduCourse);
        }
    }
	
}
