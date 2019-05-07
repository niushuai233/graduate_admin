package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.EduWebsiteCourseDetail;
import cc.niushuai.graduate.mapper.EduWebsiteCourseDetailMapper;
import cc.niushuai.graduate.service.EduWebsiteCourseDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 推荐课程表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-08 01:08:50
 */
@Slf4j
@Service("eduWebsiteCourseDetailService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduWebsiteCourseDetailServiceImpl extends BaseServiceImpl<EduWebsiteCourseDetail> implements EduWebsiteCourseDetailService {
    @Autowired
    private EduWebsiteCourseDetailMapper eduWebsiteCourseDetailMapper;

    @Override
    public EduWebsiteCourseDetail get(Long id) {
        return eduWebsiteCourseDetailMapper.get(id);
    }

    @Override
    public List<EduWebsiteCourseDetail> getList(Map<String, Object> map) {
        return eduWebsiteCourseDetailMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduWebsiteCourseDetailMapper.getCount(map);
    }

    @Override
    public void save(EduWebsiteCourseDetail eduWebsiteCourseDetail) {
        super.addValue(eduWebsiteCourseDetail, false, 0);
            eduWebsiteCourseDetailMapper.save(eduWebsiteCourseDetail);
    }

    @Override
    public void update(EduWebsiteCourseDetail eduWebsiteCourseDetail) {
        super.addValue(eduWebsiteCourseDetail, false, 1);
            eduWebsiteCourseDetailMapper.update(eduWebsiteCourseDetail);
    }

    @Override
    public void delete(Long id) {
            eduWebsiteCourseDetailMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
            eduWebsiteCourseDetailMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Long[]ids, String stateValue) {
        for (Long id:
                            ids) {
            EduWebsiteCourseDetail eduWebsiteCourseDetail=get(id);
            update(eduWebsiteCourseDetail);
        }
    }

    @Override
    public void batchAdd(Long[] ids, String s) {
        for (Long id : ids) {
            EduWebsiteCourseDetail eduWebsiteCourseDetail = new EduWebsiteCourseDetail();
            super.addValue(eduWebsiteCourseDetail, false, 0);
            eduWebsiteCourseDetail.setCourseId(id);
            eduWebsiteCourseDetail.setOrderNum(1);
            eduWebsiteCourseDetail.setRecommendId(2);
            eduWebsiteCourseDetailMapper.save(eduWebsiteCourseDetail);
        }
    }

}
