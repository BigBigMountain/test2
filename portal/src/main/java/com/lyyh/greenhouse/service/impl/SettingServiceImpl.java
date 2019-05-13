package com.lyyh.greenhouse.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyyh.greenhouse.dao.SettingDao;
import com.lyyh.greenhouse.pojo.ClimaticDataType;
import com.lyyh.greenhouse.pojo.ClimaticSetting;
import com.lyyh.greenhouse.pojo.NodeSetting;
import com.lyyh.greenhouse.pojo.HouseSetting;
import com.lyyh.greenhouse.service.SettingService;

@Service
@Transactional
public class SettingServiceImpl implements SettingService {
	
	@Autowired
	private SettingDao settingDao;

	@Override
	public String saveOrUpdateHouseSetting(HouseSetting houseSetting) {
		String msg = null;
		if (houseSetting.getHs_ip() != null) {
			if (houseSetting.getHs_port() != 0) {
				if (StringUtils.isNotBlank(houseSetting.getHs_node())) {
					if (null == houseSetting.getHs_id()) {
						settingDao.insertHouseSetting(houseSetting);
					} else {
						settingDao.updateHouseSetting(houseSetting);
					}
				} else {
					msg = "节点不能为空";
				}
			} else {
				msg = "端口号不能为0";
			}
		} else {
			msg = "ip不正确";
		}
		return msg;
		
	}

	@Override
	public void setOffHouseSetting(int id) {
		settingDao.setOffhouseSetting(id);
	}

	@Override
	public ClimaticSetting queryClimaticSetting(String zoneName) {
		
		return settingDao.queryClimaticSetting(zoneName);
	}

	@Override
	public String saveOrUpdateClimaticSetting(ClimaticSetting climaticSetting) {
		String msg = null;
		if (climaticSetting.getCs_ip() != null) {
			if (climaticSetting.getCs_port() != 0) {
				if (climaticSetting.getNodes() == null || climaticSetting.getNodes().size() == 0) {
					msg = "节点不能为空";
				} else {
					if (null == climaticSetting.getCs_id() || climaticSetting.getCs_id()==0) {
						settingDao.insertClimaticSetting(climaticSetting);
						List<NodeSetting> nodes = climaticSetting.getNodes();
						for (NodeSetting node : nodes) {
							node.setCs_id(climaticSetting.getCs_id());
						}
						settingDao.insertNodeSettings(nodes);
					} else {
						settingDao.updateClimaticSetting(climaticSetting);
						for (NodeSetting node : climaticSetting.getNodes()) {
							if(node.getNs_id()==null ||node.getNs_id() == 0){
								node.setCs_id(climaticSetting.getCs_id());
								settingDao.insertNodeSetting(node);
							}else{
								settingDao.updateNodeSetting(node);
							}
						}
					}
					
				}
			} else {
				msg = "端口号不能为0";
			}
		} else {
			msg = "ip不正确";
		}
		
		
		return msg;
	}

	@Override
	public List<HouseSetting> queryAllHouseSettings(String zoneName) {
		List<HouseSetting> houseSettings = settingDao.queryAllHouseSettings(zoneName);
		return houseSettings;
	}

	@Override
	public List<ClimaticDataType> queryClimaticDataTypes(String zoneName) {
	
		List<ClimaticDataType> climaticDataTypes = settingDao.queryAllClimaticDataType();
		
		return climaticDataTypes;
	}

}
