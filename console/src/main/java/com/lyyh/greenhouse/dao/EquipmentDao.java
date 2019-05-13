package com.lyyh.greenhouse.dao;

import java.util.List;

import com.lyyh.greenhouse.pojo.Equipment2;

public interface EquipmentDao {

	List<Equipment2> queryAllByHouseId(int houseId);

	void saveEquipment(Equipment2 equipment);

	void updateEquipment(Equipment2 equipment);

	void delEquipmentById(int equipmentId);

}
