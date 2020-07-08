package com.ssafy.happyhouse.dto;

public class DongCode {
	private String code;
	private String sido;
	private String sigungu;
	private String dong;
	private String dongri;
	public DongCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getDongri() {
		return dongri;
	}
	public void setDongri(String dongri) {
		this.dongri = dongri;
	}
	@Override
	public String toString() {
		return "DongCode [code=" + code + ", sido=" + sido + ", sigungu=" + sigungu + ", dong=" + dong + ", dongri="
				+ dongri + "]";
	}
		
}
