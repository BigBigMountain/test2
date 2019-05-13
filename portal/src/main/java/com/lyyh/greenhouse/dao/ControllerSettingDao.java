package com.lyyh.greenhouse.dao;

import java.util.List;

import com.lyyh.greenhouse.pojo.GHController;

public interface ControllerSettingDao {

	List<GHController> queryControllersByZoneName(String zoneName);

	List<GHController> queryHouseLeftJoinControllerByZoneName(String zoneName);

	void saveController(GHController controller);

	void updateController(GHController controller);

	GHController queryControllerById(int controllerId);

}
