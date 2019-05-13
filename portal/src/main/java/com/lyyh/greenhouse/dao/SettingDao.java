package com.lyyh.greenhouse.dao;

import java.util.List;

import com.lyyh.greenhouse.pojo.ClimaticDataType;
import com.lyyh.greenhouse.pojo.ClimaticSetting;
import com.lyyh.greenhouse.pojo.NodeSetting;
import com.lyyh.greenhouse.pojo.HouseSetting;

public interface SettingDao {


	
	//获取所有温室设置列表
	List<HouseSetting> queryAllHouseSettings(String zoneName);
	
	//获取所有有效温室设置列表
	List<HouseSetting> queryAllActivatedHouseSettings(String zoneName);

	//插入温室设置
	void insertHouseSetting(HouseSetting houseSetting);

	//更新温室设置
	void updateHouseSetting(HouseSetting houseSetting);

	//温室设置失效
	void setOffhouseSetting(int hs_id);

	//获取气象设置
	ClimaticSetting queryClimaticSetting(String zoneName);

	//获取所有气象数据种类
	List<ClimaticDataType> queryAllClimaticDataType();

	//插入气象设置
	void insertClimaticSetting(ClimaticSetting climaticSetting);

	//批量插入节点
	void insertNodeSettings(List<NodeSetting> nodeSettings);
	
	//插入一个节点
	void insertNodeSetting(NodeSetting nodeSetting);
	
	
	//更新气象设置
	void updateClimaticSetting(ClimaticSetting climaticSetting);
	
	//批量更新节点设置
	void updateNodeSettings(List<NodeSetting> nodeSettings);
	
	//更新一个节点设置
	void updateNodeSetting(NodeSetting nodeSetting);
}
