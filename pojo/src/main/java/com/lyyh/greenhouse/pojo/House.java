package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

public class House implements Serializable {

	
	private Integer houseId;
	//温室编号
	private Integer houseNumber;
	//温室名称
	private String houseName;
	//区域id
	private Integer zoneId;
	//区域名称
	private Integer zoneName;
	
	
	
	public Integer getZoneName() {
		return zoneName;
	}
	public void setZoneName(Integer zoneName) {
		this.zoneName = zoneName;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public Integer getZoneId() {
		return zoneId;
	}
	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}
	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", houseNumber=" + houseNumber + ", houseName=" + houseName + ", zoneId="
				+ zoneId + "]";
	}
	
	
	
	
	
	
	
	
}
