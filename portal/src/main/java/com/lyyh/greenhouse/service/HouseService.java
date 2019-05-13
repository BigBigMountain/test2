package com.lyyh.greenhouse.service;

import java.util.List;

import com.lyyh.greenhouse.pojo.House_GH;

public interface HouseService {


	List<House_GH> findAllByZoneId(Integer zoneId);

	String getHouseName(Integer houseId, Integer zoneId);


}
