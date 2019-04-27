package cc.niushuai.graduate.mapper;


import cc.niushuai.graduate.entity.admin.File;

import java.util.List;

/**
 * 地产附件表
 *
 * @author niushuai
 * @email qqniushuai951101@gmail.com
 * @date 2018-11-17 11:52:01
 */
public interface FileMapper extends BaseMapper<File> {

    List<File> getByRelationId(String relationId);

    List<File> getFileList(String imgUUID);

    List<File> getFileListByUUID(List<String> list);

    void deleteByRelationId(String relationId);
}
