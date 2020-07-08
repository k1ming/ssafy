package com.ssafy.happyhouse.dto;

public class UpjongM extends UpjongL {
	private String upjongLCode;

	public UpjongM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUpjongLCode() {
		return upjongLCode;
	}

	public void setUpjongLCode(String upjongLCode) {
		this.upjongLCode = upjongLCode;
	}

	@Override
	public String toString() {
		return "UpjongM [UpjongLCode=" + upjongLCode + ", UpjongMCode=" + getCode() + ", MCodeName=" + getCodeNm()
				+ "]";
	}

	
}
