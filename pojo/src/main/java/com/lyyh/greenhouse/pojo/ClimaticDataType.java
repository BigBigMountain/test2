package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

public class ClimaticDataType implements Serializable {
	private int tId;
	private String tName;
	private String tPropertyName;
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettPropertyName() {
		return tPropertyName;
	}
	public void settPropertyName(String tPropertyName) {
		this.tPropertyName = tPropertyName;
	}
	
	


}
