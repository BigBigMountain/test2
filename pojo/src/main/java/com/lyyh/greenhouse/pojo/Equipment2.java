package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

public class Equipment2 implements Serializable {

	// 主键id
	private Integer equipmentId;
	// 设备编号
	private String equipmentCode;
	// 设备名称
	private String equipmentName;
	// 设备状态 0:关闭 1:开/展开 2:合拢 4:停止
	private Integer equipmentState;
	// 温室id
	private Integer houseId;
	
	private Integer zoneId;
	
	
	
	
	public Integer getZoneId() {
		return zoneId;
	}
	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentCode() {
		return equipmentCode;
	}
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public Integer getEquipmentState() {
		return equipmentState;
	}
	public void setEquipmentState(Integer equipmentState) {
		this.equipmentState = equipmentState;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	@Override
	public String toString() {
		return "Equipment2 [equipmentId=" + equipmentId + ", equipmentCode=" + equipmentCode + ", equipmentName="
				+ equipmentName + ", equipmentState=" + equipmentState + ", houseId=" + houseId + "]";
	}
	
	
}
