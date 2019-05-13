package com.lyyh.greenhouse.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.lyyh.greenhouse.pojo.GHController;

public interface ControllerSettingService {


	List<GHController> queryControllersByZoneName(String zoneName);

	GHController queryControllerById(Integer controllerId);

	List<GHController> queryHouseLeftJoinControllerByZoneName(String zoneName);

	String saveController(GHController controller);

	String updateController(GHController controller);

	List<Integer> readFromController(Integer controllerId,byte read[],byte type[]) throws Exception;

	void writeToController(Integer controllerId, int[] Values,byte[] type, byte[] writehead) throws UnknownHostException, IOException;
}
