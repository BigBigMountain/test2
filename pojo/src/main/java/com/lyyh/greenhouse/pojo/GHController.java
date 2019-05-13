package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

public class GHController implements Serializable {

	private Integer controllerId;
	private Integer houseId;
	private String houseName;
	private String zoneName;
	private String controllerIp;
	private int controllerPort;
	
	
	
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public Integer getControllerId() {
		return controllerId;
	}
	public void setControllerId(Integer controllerId) {
		this.controllerId = controllerId;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getControllerIp() {
		return controllerIp;
	}
	public void setControllerIp(String controllerIp) {
		this.controllerIp = controllerIp;
	}
	public int getControllerPort() {
		return controllerPort;
	}
	public void setControllerPort(int controllerPort) {
		this.controllerPort = controllerPort;
	}
	@Override
	public String toString() {
		return "GHController [controllerId=" + controllerId + ", houseId=" + houseId + ", houseName=" + houseName
				+ ", zoneName=" + zoneName + ", controllerIp=" + controllerIp + ", controllerPort=" + controllerPort
				+ "]";
	}
	
	
	
}
