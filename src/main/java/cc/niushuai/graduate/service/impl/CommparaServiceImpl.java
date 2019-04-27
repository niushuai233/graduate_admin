package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.entity.admin.Commpara;
import cc.niushuai.graduate.mapper.CommparaMapper;
import cc.niushuai.graduate.service.CommparaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("commparaService")
@Transactional
public class CommparaServiceImpl implements CommparaService {
    @Autowired
    private CommparaMapper commparaMapper;

    @Override
    public Commpara queryObject(Integer paraId) {
        return commparaMapper.queryObject(paraId);
    }

    @Override
    public List<Commpara> queryList(Map<String, Object> map) {
        return commparaMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return commparaMapper.queryTotal(map);
    }

    @Override
    public void save(Commpara commpara) {
        commparaMapper.save(commpara);
    }

    @Override
    public void update(Commpara commpara) {
        commparaMapper.update(commpara);
    }

    @Override
    public void delete(Integer paraId) {
        commparaMapper.delete(paraId);
    }

    @Override
    public void deleteBatch(Integer[] paraIds) {
        commparaMapper.deleteBatch(paraIds);
    }

    @Override
    public void updateState(Integer[] ids, String stateValue) {
        for (Integer id : ids) {
            Commpara commpara = queryObject(id);
            commpara.setState(stateValue);
            update(commpara);
        }
    }

    @Override
    public List<Commpara> getCodeValues(Map<String, Object> params) {
        return commparaMapper.getCodeValues(params);
    }

    @Override
    public List<Commpara> findByVerify(Commpara commpara) {
        return commparaMapper.findByVerify(commpara);
    }

}
