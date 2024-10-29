package com.learn.corejava.DataProvider;

import java.time.LocalDate;

public record Employee(String name, String surNamem,Integer salary,String dept,LocalDate joiningDate,Integer age,String gender,String city) {

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surNamem=" + surNamem + ", salary=" + salary + ", dept=" + dept
				+ ", joiningDate=" + joiningDate + ", age=" + age + ", gender=" + gender + ", city=" + city + "]";
	}

	
};
/*
 * private String name; private int age; private long salary; private String
 * gender; private String deptName; private String city; private int
 * yearOfJoining;
 */