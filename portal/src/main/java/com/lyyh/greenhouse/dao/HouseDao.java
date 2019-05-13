package com.lyyh.greenhouse.dao;

import java.util.List;

import com.lyyh.greenhouse.pojo.House_GH;

public interface HouseDao {

	List<House_GH> findAllByZoneId(int zoneId);

	String getHouseName(Integer houseId, Integer zoneId);


}
