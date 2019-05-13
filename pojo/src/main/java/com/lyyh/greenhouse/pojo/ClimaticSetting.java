package com.lyyh.greenhouse.pojo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ClimaticSetting implements Serializable {
	
	public static String regexIp ="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
			+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
			+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
			+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";  
	
	private Integer cs_id;
	private Integer z_id;
	private String zoneName;
	private String cs_ip;
	private Integer cs_port;
	List<NodeSetting> nodes;
	
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

	public Integer getCs_id() {
		return cs_id;
	}

	public void setCs_id(Integer cs_id) {
		this.cs_id = cs_id;
	}

	public Integer getZ_id() {
		return z_id;
	}

	public void setZ_id(Integer z_id) {
		this.z_id = z_id;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getCs_ip() {
		return cs_ip;
	}

	public void setCs_ip(String cs_ip) {

		String verifyIp = verifyIp(cs_ip);
		if(verifyIp != null){

			if (verifyIp.matches(regexIp)) {
				this.cs_ip = verifyIp;
			} 
			else {
				this.cs_ip = null;
			}
		}else{
			this.cs_ip = null;
		}
	}

	public Integer getCs_port() {
		return cs_port;
	}

	public void setCs_port(Integer cs_port) {
		if(cs_port == null || cs_port==0){
			this.cs_port = 502;
		}else{
			this.cs_port = cs_port;
		}
	}

	
	
	
	
	public List<NodeSetting> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeSetting> nodes) {
		this.nodes = nodes;
	}







}
