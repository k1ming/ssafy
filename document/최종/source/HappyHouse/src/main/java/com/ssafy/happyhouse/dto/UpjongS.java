package com.ssafy.happyhouse.dto;

public class UpjongS extends UpjongM{
	private String upjongMCode;

	public UpjongS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUpjongMCode() {
		return upjongMCode;
	}

	public void setUpjongMCode(String upjongMCode) {
		this.upjongMCode = upjongMCode;
	}

	@Override
	public String toString() {
		return "UpjongS [UpjongLCode= " + getUpjongLCode() + ", upjongMCode= " + upjongMCode +  ", UpjongSCode="
				+ getCode() + ", SCodenm=" + getCodeNm() + "]";
	}
	
	
}
