// bean or model

package com.online.model;

public class Employee {
	
	private int eno;
	private String ename;
	
	public Employee() {
	}	
	public Employee(int eno, String ename) {
		this.eno = eno;
		this.ename = ename;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
}
