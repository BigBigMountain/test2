package com.lyyh.greenhouse.util;

public class KLModbusData {
	private int i;//指针
	private String type;//数据类型代码
	private double value;//数据值
	
	public static KLModbusData parseData(int i,byte[] result){
		KLModbusData klmd = new KLModbusData();
		double divisor=1;//除数
		boolean sign = false;//有无符号,false 无符号, true 有符号
		boolean valueType = false;//false  数值, true 开关量
		boolean longdata = false;//false  双字节, true  四字节
		boolean high = false;//高地位  false 低2字节 ,true  高2字节
		
		//获取数据类型代码
		String hexString = Integer.toHexString(result[i]&255);
		char[] hexchar = hexString.toCharArray();
		char type[] = new char[]{'0','0'};
		System.arraycopy(hexchar, 0, type, 2-hexchar.length, hexchar.length);
		klmd.setType(new String(type));
		
		//获取数据解析的定义
		int def = result[i+1]&255;
		if(def>=128){
			sign = true;
			def -=128;
		}
		if(def>=64){
			valueType = true;
			def -=64;
		}
		if(def>=32){
			longdata=true;
			def-=32;
		}
		if(def>=16){
			high = true;
			def-=16;
		}
		if(def<=7 ){
			divisor = Math.pow(10, def);
		}
		
		if(valueType){//开关量
			if(result[i+3]==0){
				klmd.setValue(0);
			}else{
				klmd.setValue(1);
			}
		}else{//述职量
			if(longdata){//四字节
				if(sign){//有符号
					klmd.setValue(((result[i+2]<<24)+((result[i+3]&255)<<16)+((result[i+6]&255)<<8)+(result[i+7]&255))/divisor);
				}else{//无符号
					klmd.setValue((((result[i+2]&255)<<24)+((result[i+3]&255)<<16)+((result[i+6]&255)<<8)+(result[i+7]&255))/divisor);
				}
				klmd.setI(i+8);
				return klmd;
			}else{//双字节
				if(sign){//有符号
						klmd.setValue( ((result[i+2]<<8)+(result[i+3]&255))/divisor );
					
				}else{//无符号
					klmd.setValue((((result[i+2]&255)<<8)+(result[i+3]&255))/divisor);
				}
			}
			
		}
		klmd.setI(i+4);
		return klmd;
	}
	
	
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
