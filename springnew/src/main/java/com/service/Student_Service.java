package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Student_VO;


@Service
public interface Student_Service {
	//get student
	public List<Student_VO> getStudent(String s_id);
	
	
	//add Student
	public String addStudent(Student_VO studentdto) ;
	//update Student
	public String updateStudent(Student_VO studentdto);


	public String deleteStudent(String s_id);
	

}
