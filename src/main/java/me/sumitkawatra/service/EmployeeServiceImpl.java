package me.sumitkawatra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.sumitkawatra.model.Employee;
import me.sumitkawatra.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.service.EmployeeService#save(me.sumitkawatra.model.Employee)
	 */
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.service.EmployeeService#get(int)
	 */
	public Employee get(int employeeId) {
		return employeeDao.get(employeeId);
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.service.EmployeeService#list()
	 */
	public List<Employee> list() {
		return employeeDao.list();
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.service.EmployeeService#delete(int)
	 */
	public void delete(int employeeId) {
		employeeDao.delete(employeeId);
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.service.EmployeeService#update(me.sumitkawatra.model.Employee)
	 */
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

}
