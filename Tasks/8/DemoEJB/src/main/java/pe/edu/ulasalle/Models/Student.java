package pe.edu.ulasalle.Models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
	public static Map<Integer, Student> StudentDataBase = new HashMap<Integer, Student>();
	
	public Student() 
	{
	}
	
	public Student(int dni, String password) 
	{
		this.dni = dni;
		this.password = password;
	}
	
	int dni = 0;
	String password = "";
	Set<String> courses = new HashSet<String>();
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getCourses() {
		return courses;
	}
	public void setCourses(Set<String> courses) {
		this.courses = courses;
	}
}