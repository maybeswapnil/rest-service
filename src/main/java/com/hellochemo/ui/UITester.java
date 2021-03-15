package com.hellochemo.ui;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hellochemo.business.bean.EmployeeBean;
import com.hellochemo.service.EmployeeService;

@SuppressWarnings("resource")
public class UITester {

	public static void main(String[] args) {
		
		EmployeeService employeeService=null;
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/lkm/resources/cst-main-config.xml");
			employeeService = (EmployeeService) applicationContext.getBean("employeeServiceImpl");
			
			// 1 Add Employee
			addEmployee(employeeService);
			
			// 2 Get Employee Employee
			//getEmployeeDetails(employeeService);
			
			
			//3 Update Employee
			//updateEmployeeDetails(employeeService);
			
			//4 Delete Employee
			//deleteEmployee(employeeService);
		
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void addEmployee(EmployeeService serviceImpl) {

		EmployeeBean bean = new EmployeeBean();
		bean.setInsertTime(new Date());
		bean.setName("New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(10.0);
		try {

			int id = serviceImpl.addEmployee(bean);
			System.out.println("Employee Registered Successfully: " + id);
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void getEmployeeDetails(EmployeeService serviceImpl) {

		try {

			EmployeeBean employeeBean = serviceImpl.getEmployeeDetails(1003);

			if (employeeBean == null) 
			{
				System.out.println("Invalid Employee Id");
			} 
			else 
			{
				System.out.println("Employee Details");
				System.out.println("================");
				System.out.println("Name: " + employeeBean.getName());
				System.out.println("Salary: " + employeeBean.getSalary());
				System.out.println("Role: " + employeeBean.getRole());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public static void updateEmployeeDetails(EmployeeService serviceImpl) {

		try {
			

			EmployeeBean foundEmployeeBean = serviceImpl.getEmployeeDetails(1003);

			if (foundEmployeeBean == null) 
			{
				System.out.println("Invalid Employee Id");
			} 
			else 
			{
				foundEmployeeBean.setSalary(1235.4);
				EmployeeBean updatedBean=serviceImpl.updateEmployeeDetails(foundEmployeeBean);
				System.out.println("Updated Employee Details");
				System.out.println("========================");
				System.out.println("Name: " + updatedBean.getName());
				System.out.println("Salary: " + updatedBean.getSalary());
				System.out.println("Role: " + updatedBean.getRole());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	
	public static void deleteEmployee(EmployeeService employeeService) {

		try {

			EmployeeBean employeeBean = employeeService.deleteEmployeeDetails(1003);

			if (employeeBean == null) 
			{
				System.out.println("Invalid Employee Id");
			} 
			else 
			{	
				System.out.println("Employee Deleted successfully with employeeId: "+employeeBean.getId());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}