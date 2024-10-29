package com.learn.corejava.ENM;

public enum DaysInWeek {
	SUNDAY("SUNDAY"), MONDAY("SUNDAY");

	private String str;

	DaysInWeek(String day) {
		this.str = day;
	}

	public String getStr() {
		return str;
	}

}
