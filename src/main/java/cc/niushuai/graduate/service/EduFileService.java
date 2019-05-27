package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduFile;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-05-23 12:14:26
 */
public interface EduFileService extends BaseService<EduFile> {

    EduFile get(Long id);

    List<EduFile> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduFile eduFile);

    void update(EduFile eduFile);

    void delete(Long id);

    void deleteBatch(Long[] ids);

    void updateState(Long[]ids, String stateValue);
}
