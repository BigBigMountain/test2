package com.lyyh.greenhouse.pojo;

import java.io.Serializable;

public class NodeSetting implements Serializable {
	private Integer ns_id;
	private Integer node;
	private String channel1;
	private String channel2;
	private String channel3;
	private String channel4;
	private Integer cs_id;

	public Integer getNs_id() {
		return ns_id;
	}

	public void setNs_id(Integer ns_id) {
		this.ns_id = ns_id;
	}

	public Integer getNode() {
		return node;
	}

	public void setNode(Integer node) {
		this.node = node;
	}

	public String getChannel1() {
		return channel1;
	}

	public void setChannel1(String channel1) {
		this.channel1 = channel1;
	}

	public String getChannel2() {
		return channel2;
	}

	public void setChannel2(String channel2) {
		this.channel2 = channel2;
	}

	public String getChannel3() {
		return channel3;
	}

	public void setChannel3(String channel3) {
		this.channel3 = channel3;
	}

	public String getChannel4() {
		return channel4;
	}

	public void setChannel4(String channel4) {
		this.channel4 = channel4;
	}

	public Integer getCs_id() {
		return cs_id;
	}

	public void setCs_id(Integer cs_id) {
		this.cs_id = cs_id;
	}

}
