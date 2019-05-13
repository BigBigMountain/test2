package com.lyyh.fertilizer.pojo;

import java.io.Serializable;

public class ValveDataVo extends ValveData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private  FertilizerData fertilizerData;

	public FertilizerData getFertilizerData() {
		return fertilizerData;
	}

	public void setFertilizerData(FertilizerData fertilizerData) {
		this.fertilizerData = fertilizerData;
	}
	
	
}
