package me.sumitkawatra.service;

import java.util.List;

import me.sumitkawatra.model.Employee;

public interface EmployeeService {

	void save(Employee employee);

	Employee get(int employeeId);

	List<Employee> list();

	void delete(int employeeId);

	void update(Employee employee);

}