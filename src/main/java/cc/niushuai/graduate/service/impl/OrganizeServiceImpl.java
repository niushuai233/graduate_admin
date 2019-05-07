package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.RandomCharUtil;
import cc.niushuai.graduate.entity.admin.Organize;
import cc.niushuai.graduate.mapper.OrganizeMapper;
import cc.niushuai.graduate.service.OrganizeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("organizeService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OrganizeServiceImpl implements OrganizeService {
    @Autowired
    private OrganizeMapper organizeMapper;

    @Override
    public Organize queryObject(String orgId) {
        return organizeMapper.queryObject(orgId);
    }

    @Override
    public List<Organize> queryList(Map<String, Object> map) {
        return organizeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return organizeMapper.queryTotal(map);
    }

    @Override
    public void save(Organize organize) {
        organize.setOrgId(RandomCharUtil.getNumberRand());
        organize.setInDate(new Date());
        organizeMapper.save(organize);
    }

    @Override
    public void update(Organize organize) {
        organizeMapper.update(organize);
    }

    @Override
    public void delete(String orgId) {
        organizeMapper.delete(orgId);
        List<Organize> organizes = organizeMapper.queryByParentId(orgId);
        for (Organize organize : organizes) {

            if (StringUtils.isEmpty(organize.getParentOrgId())) {
                organizeMapper.delete(orgId);
            }
            {
                this.delete(organize.getOrgId());
            }
        }
    }

    @Override
    public void deleteBatch(String[] orgIds) {
        organizeMapper.deleteBatch(orgIds);
    }

    @Override
    public void updateState(String[] ids, String stateValue) {
        for (String id : ids) {
            Organize organize = queryObject(id);
            organize.setState(stateValue);
            update(organize);
        }
    }

    @Override
    public List<Organize> getList() {
        return organizeMapper.getList();
    }

    @Override
    public Organize queryByOrgCode(String orgCode) {
        return organizeMapper.queryByOrgCode(orgCode);
    }

}
