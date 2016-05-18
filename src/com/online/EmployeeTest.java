package com.online;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.online.dao.JdbcDaoImpl;

import com.online.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		/*JdbcDaoImpl jdao = new JdbcDaoImpl();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		/*String name = jdao.getName(101);
		System.out.println("Name = "+name);*/
		
		String name = jdao.getEmployeeName(101);
		System.out.println("Name = "+name);
		
		/*int count = jdao.getEmployeeCount();
		System.out.println("No. of Employees = "+count);
		
		List<Employee> employees = jdao.getAllEmployees();
		for(Employee employee:employees){
			System.out.println(employee.getEno()+"\t"+employee.getEname());
		}
			
		*/
	
	}

}
