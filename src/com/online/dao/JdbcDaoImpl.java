package com.online.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.online.model.Employee;

public class JdbcDaoImpl {
	
	Employee employee = null;
	private DataSource dataSource = null;
	private JdbcTemplate jTemplate = null;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jTemplate = new JdbcTemplate(dataSource);
	}
	
	/*public String getName(int eno){			// datasource + jdbc
		String name=null;
		try{
			Connection con = dataSource.getConnection();
			
			String query = "select ename from employee where eno=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, eno);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				name = rs.getString(1);
			
			con.close();
			
		}catch(Exception e){e.printStackTrace();}

		return name;
	}*/
	
	public String getEmployeeName(int eno){		// jdbcTemplate
		String query = "select ename from employee where eno=?";
		String name = jTemplate.queryForObject(query, new Object[]{eno}, String.class);

		return name;
	}
	
	/* public int getEmployeeCount(){
		String query = "select count(*) from employee";
		int count = jTemplate.queryForInt(query);
		
		return count;
	}
	
	public List<Employee> getAllEmployees(){
		String query = "select * from employee";		
		return jTemplate.query(query, new EmployeeMapper());
	}
	
	private static final class EmployeeMapper implements RowMapper<Employee>{
		@Override
		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEno(resultSet.getInt("eno"));
			employee.setEname(resultSet.getString("ename"));
			return employee; 
		}
	}
	*/
}


