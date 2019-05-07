package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.admin.SysOss;
import cc.niushuai.graduate.mapper.SysOssMapper;
import cc.niushuai.graduate.service.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("sysOssService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SysOssServiceImpl implements SysOssService {
    @Autowired
    private SysOssMapper sysOssMapper;

    @Override
    public SysOss get(String bucket) {
        return sysOssMapper.get(bucket);
    }

    @Override
    public List<SysOss> getList(Map<String, Object> map) {
        return sysOssMapper.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return sysOssMapper.getCount(map);
    }

    @Override
    public void save(SysOss sysOss) {
        sysOssMapper.save(sysOss);
    }

    @Override
    public void update(SysOss sysOss) {
        sysOssMapper.update(sysOss);
    }

    @Override
    public void delete(String bucket) {
        sysOssMapper.delete(bucket);
    }

    @Override
    public void deleteBatch(String[] buckets) {
        sysOssMapper.deleteBatch(buckets);
    }

    @Override
    public void updateState(String[] ids, String stateValue) {
        for (String id : ids) {
            SysOss sysOss = get(id);
            sysOss.setState(stateValue);
            update(sysOss);
        }
    }

}
