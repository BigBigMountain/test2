package com.lyyh.greenhouse.service;

import java.util.List;

import com.lyyh.greenhouse.pojo.HouseData;
import com.lyyh.greenhouse.pojo.HouseData_highcharts;
import com.lyyh.greenhouse.pojo.vo.HouseDataVo;

public interface HouseDataService {
	/*
	 * 获取最新温室信息
	 */
	HouseData getNewest(HouseDataVo houseDataVo);

	/*
	 * 获取温度1,2列表
	 */
	List<Object[]> getTemperature1List(HouseDataVo houseDataVo);

	List<Object[]> getTemperature2List(HouseDataVo houseDataVo);

	/*
	 * 获取湿度1,2列表
	 */
	List<Object[]> getHumidity1List(HouseDataVo houseDataVo);

	List<Object[]> getHumidity2List(HouseDataVo houseDataVo);

	/*
	 * 光照列表
	 */
	List<Object[]> getLightingList(HouseDataVo houseDataVo);

	/*
	 * CO2列表
	 */
	List<Object[]> getCO2List(HouseDataVo houseDataVo);

	/*
	 * 土壤温度
	 */
	List<Object[]> getSoilTemperatureList(HouseDataVo houseDataVo);

	/*
	 * 土壤湿度
	 */
	List<Object[]> getSoilHumidityList(HouseDataVo houseDataVo);

	/*
	 * 温度,湿度,光照,co2
	 */
	HouseData_highcharts getIndexList(HouseDataVo houseDataVo);

	List<HouseData> downloadData(HouseDataVo houseDataVo);



}
