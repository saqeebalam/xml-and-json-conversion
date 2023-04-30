package com.converter.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private String Employeer;
	private String Age;
	private String Name;
	
	@XmlElement(name = "Employeer")
	public String getEmployeer() {
		return Employeer;
	}
	public void setEmployeer(String employeer) {
		Employeer = employeer;
	}
	@XmlElement(name = "Age")
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	@XmlElement(name = "Name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Employee [Employeer=" + Employeer + ", Age=" + Age + ", Name=" + Name + ", getEmployeer()="
				+ getEmployeer() + ", getAge()=" + getAge() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
