package me.sumitkawatra;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.sumitkawatra.model.Employee;
import me.sumitkawatra.service.EmployeeService;

public class AppMain {

	public static AbstractApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
	}

	public static void main(String[] args) {
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class, "employeeService");

		Employee employee = new Employee(1001, "Sumit Kawatra", "Java Technologies");
		Employee employee1 = new Employee(1002, "Puneet", "Microsoft Technologies");

		employeeService.save(employee);
		employeeService.save(employee1);

		for(Employee emp:employeeService.list()) {
			System.out.println(emp);
		}
		shutDown();
		System.out.println("Done!");
	}

	public static void shutDown() {
		applicationContext.registerShutdownHook();
	}

}
