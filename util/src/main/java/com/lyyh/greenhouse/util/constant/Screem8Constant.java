package com.lyyh.greenhouse.util.constant;

import java.util.HashMap;
import java.util.Map;

import com.lyyh.greenhouse.pojo.Screem8;

import gnu.io.SerialPort;

public class Screem8Constant {

	//<zoneName,setting>
	private static Map<String,Screem8> screem8Map = new HashMap<>();
	
	//<zoneName,currentPort>
	private static Map<String,SerialPort> currentPortMap = new HashMap<>();

	public static Screem8 getSetting(String zoneName) {
		
//		return screem8Map.get(zoneName) == null ? new Screem8() : screem8Map.get(zoneName);
		return screem8Map.get(zoneName);
	}

	public static void setSetting(String zoneName,Screem8 setting) {
		screem8Map.put(zoneName, setting);
	}

	public static SerialPort getCurrentPort(String zoneName) {
		return currentPortMap.get(zoneName);
	}

	public static void setCurrentPort(String zoneName,SerialPort currentPort) {
		currentPortMap.put(zoneName, currentPort);
	}
	
	
}
