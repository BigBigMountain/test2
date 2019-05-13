package com.lyyh.greenhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyyh.greenhouse.dao.HouseDao;
import com.lyyh.greenhouse.pojo.HouseData;
import com.lyyh.greenhouse.pojo.House_GH;
import com.lyyh.greenhouse.pojo.vo.HouseDataVo;
import com.lyyh.greenhouse.service.HouseService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;
	

	@Override
	public List<House_GH> findAllByZoneId(Integer zoneId) {
		List<House_GH> houses = houseDao.findAllByZoneId(zoneId);
		return houses;
	}


	@Override
	public String getHouseName(Integer houseId, Integer zoneId) {
		return houseDao.getHouseName(houseId,zoneId);
	}


}
