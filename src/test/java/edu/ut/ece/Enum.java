package edu.ut.ece;

public enum Enum {
	A, B, C;
	public String s;
	Enum() {}
	Enum(String s) {
		this.s = s;
	}
	
	public void setS(String s) {
		this.s = s;
	}
	
	private String getS() {
		return s;
	}
}
