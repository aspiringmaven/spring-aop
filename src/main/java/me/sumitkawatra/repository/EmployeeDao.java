package me.sumitkawatra.repository;

import java.util.List;

import me.sumitkawatra.model.Employee;

public interface EmployeeDao {

	void save(Employee employee);

	Employee get(int employeeId);

	List<Employee> list();

	void delete(int employeeId);

	void update(Employee employee);

}