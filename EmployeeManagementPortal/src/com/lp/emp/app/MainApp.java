package com.lp.emp.app;

import com.lp.emp.entity.Employee;
import com.lp.emp.repo.EmployeeRepo;

public class MainApp {
	public static void main(String[] args) {
		EmployeeRepo repo = new EmployeeRepo();
		//Employee emp = new Employee("Shyam", "shyam@gmail.com", "2006-04-12", "male", "9695969896", "M.C.A");
		//repo.save(emp);
		repo.findAll().stream().forEach(System.out::print);
	}
}
