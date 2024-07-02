package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbconfig.ConnectionManager;

//import com.dto.Student_VO;
//import com.dto.Domestic_VO;
import com.dto.Student_VO;

@Repository
public class Student_DAO {
	//private String s_id;
	//get student
	List<String> id = new ArrayList<>();
	public List<Student_VO> getStudent(String s_id){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String storeProc = "";
		List<Student_VO> al = null;
		al = new ArrayList<Student_VO>();
		try {
			if (connection == null) {
				connection = ConnectionManager.getConnection();
			}
			storeProc = "{call get_student(?)}";
			ps = connection.prepareStatement(storeProc);
			ps.setString(1, s_id);
			rs = ps.executeQuery();
			System.out.println(storeProc);
			while (rs.next()) {
				Student_VO dto = new Student_VO();

				dto.setS_id(rs.getString(1));
				dto.setS_name(rs.getString(2));
				dto.setS_add(rs.getString(3));
				id.add(rs.getString(1));
				al.add(dto);
			}
			System.out.println(id);
			}
			catch (Exception e) {
				System.out.println("Error in  getStudent : " + e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						;
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (Exception e) {
						;
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (Exception e) {

					}
				}
			}
			return al;
		}
	public String addStudent(Student_VO studentdto) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null, status = null;

		try {
			if (connection == null) {
				connection = ConnectionManager.getConnection();
			}
			sql = "{call insert_student(?,?,?)}";
			ps = connection.prepareStatement(sql);

			ps.setString(1, studentdto.getS_id());
			ps.setString(2, studentdto.getS_name());
			ps.setString(3, studentdto.getS_add());

			System.out.println(ps.toString());

			rs = ps.executeQuery();

			ps.clearParameters();

			while (rs.next()) {
				status = rs.getString(1);
			}

		} catch (Exception e) {

			System.out.println("addStudent" + e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					;
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					;
				}
				ps = null;
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					;
				}
				connection = null;
			}
		}
		return status;

	}
	//updateStudent
	public String updateStudent(Student_VO studentdto) {
//		
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String storeProc = null, status = null;
	try {
		if (connection == null) {
			connection = ConnectionManager.getConnection();
		}
		storeProc = "{call update_student(?,?)}";
		ps = connection.prepareStatement(storeProc);
		
		
		ps.setString(1, studentdto.getS_id());
		ps.setString(2, studentdto.getS_add());
		
		rs = ps.executeQuery();

		ps.clearParameters();

		while (rs.next()) {
			status = rs.getString(1);
		}

	} catch (Exception e) {

		System.out.println("updateInvoice" + e.getMessage());
		throw new RuntimeException(e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				;
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				;
			}
			ps = null;
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				;
			}
			connection = null;
		}
	}
	return status;

}
	public String deleteStudent(String s_id) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String storeProc = null, status = null;

		try {
			if (connection == null) {
				connection = ConnectionManager.getConnection();
			}
			storeProc = "{call delect_student(?)}";
			ps = connection.prepareStatement(storeProc);
			ps.setString(1, s_id);
			System.out.println(ps.toString());

			rs = ps.executeQuery();

			ps.clearParameters();
			 if (rs.next()) {
	                status = rs.getString(1);
	            } else {
	                status = "FAILURE";
	            }

		} catch (Exception e) {

			System.out.println("delectStudent" + e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					;
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					;
				}
				ps = null;
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					;
				}
				connection = null;
			}
		}
		return status;

	}
	
	
	
	}
	
	
	
	

		
	


