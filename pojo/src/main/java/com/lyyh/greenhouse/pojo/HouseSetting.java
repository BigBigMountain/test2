package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class HouseSetting implements Serializable {
	public static String regexIp ="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
								+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
								+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
								+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";  
	
	private Integer hs_id;
	private Integer h_id;
	private String zoneName;
	private String houseName;
	private int hs_state;
	private String hs_ip;
	private int hs_port;
	private String hs_node;
	
	
	public static String verifyIp(String strIp){
		String result = "";
		if (strIp != null) {
			String[] split = strIp.split("\\.");
			if (split.length != 4) {
				return null;
			}
			for (int i = 0; i < 4; i++) {
				String trim = StringUtils.trim(split[i]);
				if (trim == null || trim == "") {
					return null;
				}
				if (i == 3) {
					result += trim;
				} else {
					result = result + trim + ".";
				}
			}
			return result;
		}
		return null;
	}
	
	
	
	public Integer getH_id() {
		return h_id;
	}
	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	
	
	public Integer getHs_id() {
		return hs_id;
	}



	public void setHs_id(Integer hs_id) {
		this.hs_id = hs_id;
	}



	public int getHs_state() {
		return hs_state;
	}



	public void setHs_state(int hs_state) {
		this.hs_state = hs_state;
	}



	public String getHs_ip() {
		return hs_ip;
	}



	public void setHs_ip(String hs_ip) {
		String verifyIp = verifyIp(hs_ip);
		if(verifyIp != null){

			if (verifyIp.matches(regexIp)) {
				this.hs_ip = verifyIp;
			} 
			else {
				this.hs_ip = null;
			}
		}else{
			this.hs_ip = null;
		}
	}



	public int getHs_port() {
		return hs_port;
	}



	public void setHs_port(int hs_port) {
		if(hs_port==0){
			this.hs_port = 502;
		}else{
			
			this.hs_port = hs_port;
		}
	}



	public String getHs_node() {
		return hs_node;
	}



	public void setHs_node(String hs_node) {
		if(StringUtils.isNotBlank(hs_node)){
			this.hs_node = hs_node;
		}else{
			this.hs_node=null;
		}
	}



	
	
	
	
	
	

}
