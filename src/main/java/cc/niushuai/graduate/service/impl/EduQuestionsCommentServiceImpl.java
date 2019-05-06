package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.ShiroUtils;
import cc.niushuai.graduate.entity.EduQuestionsComment;
import cc.niushuai.graduate.mapper.EduQuestionsCommentMapper;
import cc.niushuai.graduate.service.EduQuestionsCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("eduQuestionsCommentService")
@Transactional
public class EduQuestionsCommentServiceImpl extends BaseServiceImpl<EduQuestionsComment> implements EduQuestionsCommentService {
	@Autowired
	private EduQuestionsCommentMapper eduQuestionsCommentMapper;
	
	@Override
	public EduQuestionsComment get(Long id){
		return eduQuestionsCommentMapper.get(id);
	}

	@Override
	public List<EduQuestionsComment> getList(Map<String, Object> map){
		return eduQuestionsCommentMapper.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return eduQuestionsCommentMapper.getCount(map);
	}

	@Override
	public void save(EduQuestionsComment eduQuestionsComment){
		super.addValue(eduQuestionsComment,false,0);
		eduQuestionsComment.setAddTime(new Date());
		eduQuestionsComment.setCusId(ShiroUtils.getUserId());
		eduQuestionsComment.setCusName(ShiroUtils.getUserName());
		eduQuestionsCommentMapper.save(eduQuestionsComment);
	}

	@Override
	public void update(EduQuestionsComment eduQuestionsComment){
		super.addValue(eduQuestionsComment,false,1);
		eduQuestionsComment.setUpdateTime(new Date());
		eduQuestionsCommentMapper.update(eduQuestionsComment);
	}

	@Override
	public void delete(Long id){
		eduQuestionsCommentMapper.delete(id);
	}

	@Override
	public void deleteBatch(Long[] ids){
		eduQuestionsCommentMapper.deleteBatch(ids);
	}

    @Override
    public void updateState(Long[] ids,String stateValue) {
        for (Long id:ids){
			EduQuestionsComment eduQuestionsComment=get(id);
			eduQuestionsComment.setState(Integer.valueOf(stateValue));
			eduQuestionsComment.setUpdateTime(new Date());
            update(eduQuestionsComment);
        }
    }
	
}
