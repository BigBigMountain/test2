package com.lyyh.fertilizer.backup.dao;

import java.util.List;

import com.lyyh.tzgk.pojo.TgateWay;
import com.lyyh.tzgk.pojo.Tvalve;

public interface EquipmentDao {

	List<TgateWay> getTGateWayByUserId(Integer userId);

	void addGateWay(TgateWay gateWay);

	void updateGateWay(TgateWay gateWay);

	void deleteGateWay(Integer gateWayId);

	
	
	
	List<Tvalve> getTvalveListByFertilizerId(Integer fertilizerId);

	void addValve(Tvalve tvalve);

	void updateValve(Tvalve tvalve);

	void deleteTvalve(Integer tvalveId);

}
