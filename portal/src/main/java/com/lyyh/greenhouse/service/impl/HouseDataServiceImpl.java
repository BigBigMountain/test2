package com.lyyh.greenhouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyyh.greenhouse.dao.HouseDataDao;
import com.lyyh.greenhouse.pojo.HouseData;
import com.lyyh.greenhouse.pojo.HouseData_highcharts;
import com.lyyh.greenhouse.pojo.vo.CO2Vo;
import com.lyyh.greenhouse.pojo.vo.HouseDataVo;
import com.lyyh.greenhouse.pojo.vo.HumidityVo;
import com.lyyh.greenhouse.pojo.vo.LightingVo;
import com.lyyh.greenhouse.pojo.vo.SoilHumidityVo;
import com.lyyh.greenhouse.pojo.vo.SoilTemperatureVo;
import com.lyyh.greenhouse.pojo.vo.TemperatureVo;
import com.lyyh.greenhouse.service.HouseDataService;
@Service
@Transactional
public class HouseDataServiceImpl implements HouseDataService {

	@Autowired
	private HouseDataDao houseDataDao;
	@Override
	public HouseData getNewest(HouseDataVo houseDataVo) {
		
		return houseDataDao.getNewest(houseDataVo);
	}

	@Override
	public List<Object[]> getTemperature1List(HouseDataVo houseDataVo) {
		List<TemperatureVo> temperatureVos = houseDataDao.getTemperature1List(houseDataVo);
		List<Object[]> temperatures = new ArrayList<Object[]>();
		for (TemperatureVo temperatureVo : temperatureVos) {
			temperatures.add(new Object[]{temperatureVo.getTimeSpan(),temperatureVo.getTemperature()});
		}
		return temperatures;
	}

	@Override
	public List<Object[]> getTemperature2List(HouseDataVo houseDataVo) {
		List<TemperatureVo> temperatureVos = houseDataDao.getTemperature2List(houseDataVo);
		List<Object[]> temperatures = new ArrayList<Object[]>();
		for (TemperatureVo temperatureVo : temperatureVos) {
			temperatures.add(new Object[]{temperatureVo.getTimeSpan(),temperatureVo.getTemperature()});
		}
		return temperatures;
	}

	@Override
	public List<Object[]> getHumidity1List(HouseDataVo houseDataVo) {
		List<HumidityVo> humidityVos = houseDataDao.getHumidity1List(houseDataVo);
		List<Object[]> humiditys = new ArrayList<Object[]>();
		for (HumidityVo humidityVo : humidityVos) {
			humiditys.add(new Object[]{humidityVo.getTimeSpan(),humidityVo.getHumidity()});
		}
		return humiditys;
	}

	@Override
	public List<Object[]> getHumidity2List(HouseDataVo houseDataVo) {
		List<HumidityVo> humidityVos = houseDataDao.getHumidity2List(houseDataVo);
		List<Object[]> humiditys = new ArrayList<Object[]>();
		for (HumidityVo humidityVo : humidityVos) {
			humiditys.add(new Object[]{humidityVo.getTimeSpan(),humidityVo.getHumidity()});
		}
		return humiditys;
	}

	@Override
	public List<Object[]> getLightingList(HouseDataVo houseDataVo) {
		List<LightingVo> lightingVos = houseDataDao.getLightingList(houseDataVo);
		List<Object[]> lightings = new ArrayList<Object[]>();
		for (LightingVo lightingVo : lightingVos) {
			lightings.add(new Object[]{lightingVo.getTimeSpan(),lightingVo.getLighting()});
		}
		return lightings;
	}

	@Override
	public List<Object[]> getCO2List(HouseDataVo houseDataVo) {
		List<CO2Vo> co2Vos = houseDataDao.getCO2List(houseDataVo);
		List<Object[]> co2s = new ArrayList<Object[]>();
		for (CO2Vo co2Vo : co2Vos) {
			co2s.add(new Object[]{co2Vo.getTimeSpan(),co2Vo.getCo2()});
		}
		return co2s;
	}

	@Override
	public List<Object[]> getSoilTemperatureList(HouseDataVo houseDataVo) {
		List<SoilTemperatureVo> soilTemperatureVos = houseDataDao.getSoilTemperatureList(houseDataVo);
		List<Object[]> soilTemperatures = new ArrayList<Object[]>();
		for (SoilTemperatureVo soilTemperatureVo : soilTemperatureVos) {
			soilTemperatures.add(new Object[]{soilTemperatureVo.getTimeSpan(),soilTemperatureVo.getSoilTemperature()});
		}
		return soilTemperatures;
	}

	@Override
	public List<Object[]> getSoilHumidityList(HouseDataVo houseDataVo) {
		List<SoilHumidityVo> SoilHumidityVos = houseDataDao.getSoilHumidityList(houseDataVo);
		List<Object[]> soilHumiditys = new ArrayList<Object[]>();
		for (SoilHumidityVo soilHumidityVo : SoilHumidityVos) {
			soilHumiditys.add(new Object[]{soilHumidityVo.getTimeSpan(),soilHumidityVo.getSoilHumidity()});
		}
		return soilHumiditys;
	}

	@Override
	public HouseData_highcharts getIndexList(HouseDataVo houseDataVo) {
		List<HouseData> houseDataList = houseDataDao.getHouseDataList(houseDataVo);
		HouseData_highcharts houseData_highcharts = new HouseData_highcharts();
		if(null != houseDataList){
			for (HouseData houseData : houseDataList) {
				houseData_highcharts.getTemperatures().add(houseData.getTemperature());
//				houseData_highcharts.getTemperatures2().add(houseData.getTemperature2());
				houseData_highcharts.getHumiditys().add(houseData.getHumidity());
//				houseData_highcharts.getHumiditys2().add(houseData.getHumidity2());
				houseData_highcharts.getLightings().add(houseData.getLighting());
				houseData_highcharts.getCo2s().add(houseData.getCo2());
//				houseData_highcharts.getSoilTemperatures().add(houseData.getSoilTemperature());
//				houseData_highcharts.getSoilHumiditys().add(houseData.getSoilHumidity());
				houseData_highcharts.getTimeSpan().add(houseData.getTimeSpan());
			}
		}
		return houseData_highcharts;
	}

	@Override
	public List<HouseData> downloadData(HouseDataVo houseDataVo) {
		List<HouseData> houseDataList = houseDataDao.getHouseDataList(houseDataVo);
		return houseDataList;
	}

}
