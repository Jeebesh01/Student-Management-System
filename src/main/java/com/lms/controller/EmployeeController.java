package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.dto.EmployeeDto;
import com.lms.entity.Employee;
import com.lms.service.EmployeeService;
import com.lms.util.EmailService;

@Controller//this makes the methods that are written within as handler methods
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	//Handler methods
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/view")
	public String viewCreateRegistrationPage() {
		return "create_employee";
	}
	
	@RequestMapping("/addStudent")
	public String addEmployee(
			EmployeeDto dto,
			ModelMap model) {//modelattribute sends the data to the employee and is not mandatory to be written
		Employee e = new Employee();
		e.setEmailId(dto.getEmailId());
		e.setName(dto.getName());
		e.setMobile(dto.getMobile());
		employeeService.addEmployee(e);
		emailService.sendEmail(dto.getEmailId(), "welcome", "hi welcome to....");
		model.addAttribute("msg", "Record is saved");
		return "create_employee";
	}
	
	@RequestMapping("/getAllStd")
	public String getAllEmp(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list_employees";
	}
	
	@RequestMapping("/deleteReg")
	public String deleteEmployee(@RequestParam long id,Model model) {
		employeeService.deleteEmployee(id);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list_employees";
	}
	
	@RequestMapping("/updateReg")
	public String updateEmployee(@RequestParam long id,Model model) {
		Employee employee =employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@RequestMapping("/updateStudent")
	public String updateRegistration(EmployeeDto dto,Model model) {
		employeeService.updateEmployee(dto);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list_employees";
	}
}
