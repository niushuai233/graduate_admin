package cc.niushuai.graduate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;
import java.util.Map;

import cc.niushuai.graduate.mapper.EduFileMapper;
import cc.niushuai.graduate.entity.EduFile;
import cc.niushuai.graduate.service.EduFileService;

/**
 * 
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-23 12:14:26
 */
@Slf4j
@Service("eduFileService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EduFileServiceImpl extends BaseServiceImpl<EduFile> implements EduFileService {
    @Autowired
    private EduFileMapper eduFileMapper;

    @Override
    public EduFile get(Long id) {
        return eduFileMapper.get(id);
    }

    @Override
    public List<EduFile> getList(Map<String, Object> map) {
        return eduFileMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return eduFileMapper.getCount(map);
    }

    @Override
    public void save(EduFile eduFile) {
        super.addValue(eduFile, false, 0);
            eduFileMapper.save(eduFile);
    }

    @Override
    public void update(EduFile eduFile) {
        super.addValue(eduFile, false, 1);
        eduFileMapper.update(eduFile);
    }

    @Override
    public void delete(Long id) {
            eduFileMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
            eduFileMapper.deleteBatch(ids);
    }

    @Override
    public void updateState(Long[]ids, String stateValue) {
        for (Long id : ids) {
            EduFile eduFile=get(id);

            update(eduFile);
        }
    }

}
