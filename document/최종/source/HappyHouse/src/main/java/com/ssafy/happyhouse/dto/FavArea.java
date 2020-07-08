package com.ssafy.happyhouse.dto;

public class FavArea {
	private int memno;
	private String dongcode;
	
	private int oldmemno;
	private String olddongcode;
	
	public FavArea() {
		super();
		// TODO Auto-generated constructor stub
		memno = -1;
	}
	
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	@Override
	public String toString() {
		return "FavArea [memno=" + memno + ", dongcode=" + dongcode + "]";
	}

	public int getOldmemno() {
		return oldmemno;
	}
	public void setOldmemno(int oldmemno) {
		this.oldmemno = oldmemno;
	}
	public String getOlddongcode() {
		return olddongcode;
	}
	public void setOlddongcode(String olddongcode) {
		this.olddongcode = olddongcode;
	}
}
