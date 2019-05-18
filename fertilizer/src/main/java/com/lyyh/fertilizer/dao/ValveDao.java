package com.lyyh.fertilizer.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyyh.fertilizer.pojo.ValveData;
import com.lyyh.fertilizer.pojo.ValveDataVo;

public interface ValveDao {

	public void insertValveData(ValveData data);
	
	public void insertValveDataList(List<ValveData> dataList);
	
	public List<ValveData> queryByFertilizerId(int fertilizerId);
	
	public List<ValveData> queryByPeriod(@Param("fertilizerId") int fertilizerId,@Param("start") Date start,@Param("end") Date end);
	
	public List<ValveDataVo> queryVoByPeriod (@Param("fertilizerId") int fertilizerId,@Param("start") Date start,@Param("end") Date end);
	
	public List<ValveDataVo> queryVoByVo (@Param("fertilizerId") int fertilizerId,@Param("number") int number, @Param("start") Date start,@Param("end") Date end);
	
	
}
