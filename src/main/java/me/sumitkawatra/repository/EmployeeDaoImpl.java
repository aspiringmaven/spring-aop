package me.sumitkawatra.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import me.sumitkawatra.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static Map<Integer, Employee> repository = new ConcurrentHashMap<Integer, Employee>();

	/* (non-Javadoc)
	 * @see me.sumitkawatra.repository.EmployeeDao2#save(me.sumitkawatra.model.Employee)
	 */
	public void save(Employee employee) {
		repository.put(employee.getId(), employee);
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.repository.EmployeeDao2#get(int)
	 */
	public Employee get(int employeeId) {
		return repository.get(employeeId);
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.repository.EmployeeDao2#list()
	 */
	public List<Employee> list() {
		return new ArrayList<Employee>(repository.values());
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.repository.EmployeeDao2#delete(int)
	 */
	public void delete(int employeeId) {
		repository.remove(employeeId);
	}

	/* (non-Javadoc)
	 * @see me.sumitkawatra.repository.EmployeeDao2#update(me.sumitkawatra.model.Employee)
	 */
	public void update(Employee employee) {
		if (null != repository.get(employee.getId())) {
			repository.remove(employee.getId());
			repository.put(employee.getId(), employee);
		} else {
			throw new RuntimeException("Employee does not exist");
		}
	}
}
