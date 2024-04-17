package pe.edu.ulasalle.Models;

import java.util.UUID;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Course {
	public static Map<String, Course> CourseDataBase = new HashMap<String, Course>();
	public static Set<String> CourseSet = new HashSet<String>();
	
	public Course()
	{
	}
	
	public Course(String name, String area, int duration)
	{
		this.guid = UUID.randomUUID().toString();
		
		this.name = name;
		this.duration = duration;
		this.area = area;
		
		this.credits = new Random().nextInt(5 - 1) + 1;
	}
	
	String guid;
	String name;
	String area;
	int duration;
	int credits;
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public String getGUID()
	{
		return guid;
	}
	
	public void setGUID(String guid)
	{	
		this.guid = guid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
}