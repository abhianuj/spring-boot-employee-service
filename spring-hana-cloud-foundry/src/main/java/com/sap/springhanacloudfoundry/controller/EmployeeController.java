package com.sap.springhanacloudfoundry.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.springhanacloudfoundry.models.Employee;
import com.sap.springhanacloudfoundry.services.EmployeeService;

@RestController
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String welcome() {
		String tabSpace = "&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;";
		return "Welcome to Employee Management Spring Boot Services. Use below API's to manage the data: <br><br><br>" +
				tabSpace + "1. /employee/count - To get total number of Employees.<br><br>"+
				tabSpace + "2. /employee/all - To get data of all Employees.<br><br>"+
				tabSpace + "3. /employee/add - To add an Employees.<br><br>"+
				tabSpace + "4. /employee/id/{id} - To get data of an Employee by id.<br><br>"+
				tabSpace + "5. /employee/delete/{id} - To delete data of an Employee by id.<br><br>";
	}

	@RequestMapping("/employee/count")
	public long count() {
		log.info("Search total number of employees");
		return employeeService.getCount();
	}

	@RequestMapping("/employee/all")
	public List<Employee> getAllEmployees(){
		log.info("Searching all employees");
		return employeeService.findAllEmployee();
	}

	@PostMapping(value="/employee/add")
	public boolean addEmployee(@RequestBody Employee employee) {
		log.info("Creation/Updating Employee - "+employee.toString());
		return employeeService.insertEmployee(employee);
	}

	@RequestMapping("/employee/id/{id}" )
	public Employee findById(@PathVariable long id) {
		log.info("Searching employee with ID - "+ id);
		return employeeService.findEmployeeById(id);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/employee/delete/{id}")
	public boolean deleteEmployee(@PathVariable long id) {
		log.info("Deleting employee with ID - "+ id);
		return employeeService.deleteEmployee(id);
	}
}