package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.Student_DAO;

import com.dto.Student_VO;
import com.service.Student_Service;

@Component
public class StudentImpl implements Student_Service{
	@Autowired
	private Student_DAO student_dao;


	@Override
	public List<Student_VO> getStudent(String s_id) {
		
		return student_dao.getStudent(s_id);
	}
	
	public String addStudent(Student_VO studentdto) {
		
		return student_dao.addStudent(studentdto);
	}
	public String updateStudent(Student_VO studentdto) {
		return student_dao.updateStudent(studentdto);
	}
	// Delete student
		public String deleteStudent(String s_id) {
			return student_dao.deleteStudent(s_id);
		}

	

	

}
