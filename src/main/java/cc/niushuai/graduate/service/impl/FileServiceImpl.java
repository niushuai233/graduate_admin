package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.mapper.FileMapper;
import cc.niushuai.graduate.service.FileService;
import cc.niushuai.graduate.entity.admin.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService {
	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public File get(String id){
		return fileMapper.get(id);
	}

	@Override
	public List<File> getList(Map<String, Object> map){
		return fileMapper.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return fileMapper.getCount(map);
	}

	@Override
	public void save(File file){
		fileMapper.save(file);
	}

	@Override
	public void update(File file){
		fileMapper.update(file);
	}

	@Override
	public void delete(String id){
		fileMapper.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		fileMapper.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			File file=get(id);
			//file.setState(stateValue);
            update(file);
        }
    }

	@Override
	public List<File> getByRelationId(String relationId) {
		return fileMapper.getByRelationId(relationId);
	}

	@Override
	public List<File> getFileList(String imgUUID) {
		return fileMapper.getFileList(imgUUID);
	}

	@Override
	public List<File> getFileListByUUID(List<String> uuidList) {
		return fileMapper.getFileListByUUID(uuidList);
	}

	@Override
	public void deleteByRelationId(String relationId) {
		fileMapper.deleteByRelationId(relationId);
	}

}
