package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

public class House_GH implements Serializable {

	//主键id
	private Integer houseId;
	//温室编号
	private String zoneCode;
	//温室所属区域
	private String houseName;
	
	
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	@Override
	public String toString() {
		return "House_GH [houseId=" + houseId + ", zoneCode=" + zoneCode + ", houseName=" + houseName + "]";
	}
	
	
	
	
	
}
