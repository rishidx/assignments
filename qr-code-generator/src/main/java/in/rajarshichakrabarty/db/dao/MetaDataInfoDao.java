package in.rajarshichakrabarty.db.dao;

import java.util.List;

import in.rajarshichakrabarty.db.model.MetaDataInfo;

public interface MetaDataInfoDao extends Dao<MetaDataInfo, Integer> {

	void saveMetaDataInfo(MetaDataInfo metaDataInfo);

	List<MetaDataInfo> getAllMetaDataInfo();
}
