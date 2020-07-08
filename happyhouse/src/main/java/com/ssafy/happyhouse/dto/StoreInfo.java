package com.ssafy.happyhouse.dto;

public class StoreInfo {
	private int no;
	private String shopName;
	private String localName;
	private String upjongLCode;
	private String upjongMCode;
	private String upjongSCode;
	private String upjongS;
	private String code4;
	private String codeName4;
	private String dongCode;
	private String jibunAddress;
	private String address;
	private int oldPostCode;
	private int postCode;
	private String lng;
	private String lat;
	
	private String codeNm;
	private int pageStart;
	private int pageEnd;
	
	public StoreInfo() {
		super();
	}
	
	public StoreInfo(int no, String shopName, String localName, String upjongLCode, String upjongMCode,
			String upjongSCode, String upjongS, String code4, String codeName4, String dongCode, String jibunAddress,
			String address, int oldPostCode, int postCode, String lng, String lat, String codeNm, int pageStart,
			int pageEnd) {
		super();
		this.no = no;
		this.shopName = shopName;
		this.localName = localName;
		this.upjongLCode = upjongLCode;
		this.upjongMCode = upjongMCode;
		this.upjongSCode = upjongSCode;
		this.upjongS = upjongS;
		this.code4 = code4;
		this.codeName4 = codeName4;
		this.dongCode = dongCode;
		this.jibunAddress = jibunAddress;
		this.address = address;
		this.oldPostCode = oldPostCode;
		this.postCode = postCode;
		this.lng = lng;
		this.lat = lat;
		this.codeNm = codeNm;
		this.pageStart = pageStart;
		this.pageEnd = pageEnd;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getUpjongLCode() {
		return upjongLCode;
	}
	public void setUpjongLCode(String upjongLCode) {
		this.upjongLCode = upjongLCode;
	}
	public String getUpjongMCode() {
		return upjongMCode;
	}
	public void setUpjongMCode(String upjongMCode) {
		this.upjongMCode = upjongMCode;
	}
	public String getUpjongSCode() {
		return upjongSCode;
	}
	public void setUpjongSCode(String upjongSCode) {
		this.upjongSCode = upjongSCode;
	}
	public String getUpjongS() {
		return upjongS;
	}
	public void setUpjongS(String upjongS) {
		this.upjongS = upjongS;
	}
	public String getCode4() {
		return code4;
	}
	public void setCode4(String code4) {
		this.code4 = code4;
	}
	public String getCodeName4() {
		return codeName4;
	}
	public void setCodeName4(String codeName4) {
		this.codeName4 = codeName4;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getJibunAddress() {
		return jibunAddress;
	}
	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOldPostCode() {
		return oldPostCode;
	}
	public void setOldPostCode(int oldPostCode) {
		this.oldPostCode = oldPostCode;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	@Override
	public String toString() {
		return "StoreInfo [no=" + no + ", shopName=" + shopName + ", localName=" + localName + ", upjongLCode="
				+ upjongLCode + ", upjongMCode=" + upjongMCode + ", upjongSCode=" + upjongSCode + ", upjongS=" + upjongS
				+ ", code4=" + code4 + ", codeName4=" + codeName4 + ", dongCode=" + dongCode + ", jibunAddress="
				+ jibunAddress + ", address=" + address + ", oldPostCode=" + oldPostCode + ", postCode=" + postCode
				+ ", lng=" + lng + ", lat=" + lat + ", codeNm=" + codeNm + ", pageStart=" + pageStart + ", pageEnd="
				+ pageEnd + "]";
	}
	


	
	
}
