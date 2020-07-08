package com.ssafy.happyhouse.dto;

public class UpjongL {
	private String code;
	private String codeNm;
	public UpjongL() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(String codenm) {
		this.codeNm = codenm;
	}
	@Override
	public String toString() {
		return "UpjongL [code=" + code + ", codeNm=" + codeNm + "]";
	}
	
	
}
