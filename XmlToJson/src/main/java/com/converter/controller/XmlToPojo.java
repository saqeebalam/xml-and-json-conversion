package com.converter.controller;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.converter.pojo.Employee;
import com.converter.pojo.Employees;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class XmlToPojo {
	
	public static void main(String[] args) throws JAXBException,JsonProcessingException{
		
		File file = new File("C:\\Users\\91985\\Desktop\\Web Page JAVA\\Employee.xml");
		JAXBContext jaxbcontext = JAXBContext.newInstance(Employees.class);
		Unmarshaller createUnmarshaller = jaxbcontext.createUnmarshaller();
		Employees employees = (Employees) createUnmarshaller.unmarshal(file);
		List<Employee> employeeList = employees.getEmployees();

		for (Employee employee : employeeList) {
		    System.out.println("Name:-"+employee.getName());
		    System.out.println("Employeer:-"+employee.getEmployeer());
		    System.out.println("Age:-"+employee.getAge());
		    System.out.println("===============================================");
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(employees);
		System.out.println("Xml to Json= "+writeValueAsString);
		
		//Json to  xml string
		Employees readValue = objectMapper.readValue(writeValueAsString, Employees.class);
		
		// create a JAXBContext instance
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		// create a Marshaller instance from the JAXBContext
		Marshaller marshaller = jaxbContext.createMarshaller();
		// set the marshaller to format the output nicely
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// create a StringWriter to hold the XML string
		StringWriter stringWriter = new StringWriter();
		// marshal the Java object to XML and write it to the StringWriter
		marshaller.marshal(readValue, stringWriter);
		// get the XML string from the StringWriter
		String xmlString = stringWriter.toString();
		System.out.println("Xml String"+xmlString);
		

	}

}
