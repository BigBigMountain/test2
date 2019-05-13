package com.lyyh.greenhouse.service;

import java.util.List;

import com.lyyh.greenhouse.pojo.HouseSetting;

public interface CollectionDataService {

//	//采集
//	public String collectData(List<HouseSetting> houseSettings);
	//停止采集
	public void stopCollect();
	//启动采集
	public void startCollect(String zoneName);
}
