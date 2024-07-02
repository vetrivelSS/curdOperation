package com.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.dto.ServiceResponseDto;
import com.dto.Student_VO;
import com.service.Student_Service;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(path = "/Student", produces = { MediaType.APPLICATION_JSON_VALUE })
public class Student_Controller {

	@Autowired
	private Student_Service dom_serv;
	
	@GetMapping("/getStudent")
	public ResponseEntity<List<Student_VO>> getStudent(@RequestParam(value = "id") String s_id) {
		List<Student_VO> response = new ArrayList<Student_VO>();
		
		response = dom_serv.getStudent(s_id);
		return new ResponseEntity<List<Student_VO>>(response, HttpStatus.OK);

	}
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<ServiceResponseDto> addStudent(@RequestBody  Student_VO studentdto) {
		ResponseEntity<ServiceResponseDto> servResponse = null;
		ServiceResponseDto response = null;
		try {
			response = new ServiceResponseDto("0000", Arrays.asList(dom_serv.addStudent(studentdto)));
			servResponse = new ResponseEntity<ServiceResponseDto>(response, HttpStatus.OK);

		} catch (RuntimeException e) {

			response = new ServiceResponseDto("1111", Arrays.asList(e.getMessage()));
			servResponse = new ResponseEntity<ServiceResponseDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return servResponse;

	}
	@PutMapping("/updateStudent")
	public ResponseEntity<ServiceResponseDto> updateStudent(@RequestBody  Student_VO studentdto) {
		ResponseEntity<ServiceResponseDto> servResponse = null;
		ServiceResponseDto response = null;
		try {

			response = new ServiceResponseDto("0000", Arrays.asList(dom_serv.updateStudent(studentdto)));
			servResponse = new ResponseEntity<ServiceResponseDto>(response, HttpStatus.OK);

		} catch (RuntimeException e) {

			response = new ServiceResponseDto("1111", Arrays.asList(e.getMessage()));
			servResponse = new ResponseEntity<ServiceResponseDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return servResponse;

	}
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<ServiceResponseDto> deleteStudent(@RequestParam(value = "id") String s_id) {
		ResponseEntity<ServiceResponseDto> servResponse = null;
		ServiceResponseDto response = null;
		try {

			response = new ServiceResponseDto("0000", Arrays.asList(dom_serv.deleteStudent(s_id)));
			servResponse = new ResponseEntity<ServiceResponseDto>(response, HttpStatus.OK);

		} catch (RuntimeException e) {
			response = new ServiceResponseDto("1111", Arrays.asList(e.getMessage()));
			servResponse = new ResponseEntity<ServiceResponseDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return servResponse;
	}


}
	

