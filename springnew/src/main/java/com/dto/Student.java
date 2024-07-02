package com.dto;

import java.util.List;

public class Student {
	private int id;
    private String name;
    private String address;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public static List<Student_VO> getStudent(String id2, String name2) {
		// TODO Auto-generated method stub
		return null;
	}
}
