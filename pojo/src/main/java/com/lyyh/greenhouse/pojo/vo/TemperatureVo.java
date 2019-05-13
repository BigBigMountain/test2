package com.lyyh.greenhouse.pojo.vo;

import java.util.Date;

public class TemperatureVo {

	private float temperature;
	
	private Date timeSpan;
	
	public Date getTimeSpan() {
		return timeSpan;
	}
	public void setTimeSpan(Date timeSpan) {
		this.timeSpan = timeSpan;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
}
