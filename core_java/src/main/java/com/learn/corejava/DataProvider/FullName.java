package com.learn.corejava.DataProvider;

public record FullName(String name, String surName) {
	public String toStringOne() {
		return this.name + " , " + this.surName;
	}
};