package cc.niushuai.graduate.service;

import cc.niushuai.graduate.entity.EduWebsiteImagesType;

import java.util.List;
import java.util.Map;

/**
 * 图片类型表
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2019-03-19 16:36:50
 */
public interface EduWebsiteImagesTypeService {

    EduWebsiteImagesType get(Integer typeId);

    List<EduWebsiteImagesType> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(EduWebsiteImagesType eduWebsiteImagesType);

    void update(EduWebsiteImagesType eduWebsiteImagesType);

    void delete(Integer typeId);

    void deleteBatch(Integer[] typeIds);

    void updateState(Integer[] ids, String stateValue);
}
