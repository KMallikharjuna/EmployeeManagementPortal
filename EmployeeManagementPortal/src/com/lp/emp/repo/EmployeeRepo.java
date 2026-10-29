package com.lp.emp.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lp.emp.config.DBConnection;
import com.lp.emp.entity.Employee;

public class EmployeeRepo {
	public static Connection con = DBConnection.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	
	public Employee getEmployee() {
		Employee emp = new Employee();
		try {
			emp.setDob(rs.getString("dob"));
			emp.setEmail(rs.getString("email"));
			emp.setEname(rs.getString("ename"));
			emp.setGender(rs.getString("gender"));
			emp.setId(rs.getInt("id"));
			emp.setPhone(rs.getString("phone"));
			emp.setQualification(rs.getString("qualification"));
			emp.setStatus(rs.getBoolean("status"));
			return emp;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Employee> findAll(){
		List<Employee> employees = new ArrayList<Employee>();
		try {
			query = "select * from employee";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {	
				Employee emp = getEmployee();
				employees.add(emp);
			}
			return employees;
		} catch (SQLException e) {
			System.out.println("Unable to get employees.");
			return null;
		}
	}
	
	public void save(Employee emp) {
		query = "insert into employee(ename,email,phone,gender,dob,qualification) values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPhone());
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getDob());
			ps.setString(6, emp.getQualification());
			ps.execute();
			System.out.println("Employee inserted successfully.");
		} catch (SQLException e) {
			System.out.println("Unable to insert the employee");
		}
	}
}
