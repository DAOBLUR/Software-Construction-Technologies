package pe.edu.ulasalle.utcs.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.ulasalle.Models.*;
import pe.edu.ulasalle.RequestModels.*;

@Path("ExampleService")
@Stateless
@LocalBean
public class ExampleService {
	
    public ExampleService() 
    {
    }
    
    @GET
    @Path("GetAllCoursesByAreaDuration")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Course> GetAllCoursesByAreaDuration(Course course) 
    {
    	List<Course> courseList = new ArrayList<Course>();
  	  	for (Course c : Course.CourseDataBase.values()) 
  	  	{
  	  		if (c.getDuration() == course.getDuration() && c.getArea().equals(course.getArea())) 
  	  		{
  	  			courseList.add(c);
  	  		}
  	  	}
  	  	return courseList;
    }
    
    @POST
    @Path("CreateCourse")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course CreateCourse(Course course) 
    {
    	if (Course.CourseSet.add(course.getName())) {
    		
    		var newCourse = new Course(course.getName(), course.getArea(), course.getDuration());
    		Course.CourseDataBase.put(newCourse.getGUID(), newCourse);
    		return newCourse;
        } 
    	else {
    		return new Course();
        }
    }
    
    @POST
    @Path("SignUp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student SignUp(Student student) 
    {
    	if(student.getDni() < 10000000 || student.getDni() > 99999999) return null;
    	if(student.getPassword() == null || student.getPassword() == "") return null;
    	for(Student s : Student.StudentDataBase.values())
    	{
    		if(s.getDni() == student.getDni()) return null;
    	}

		var newStudent = new Student(student.getDni(), student.getPassword());
		Student.StudentDataBase.put(student.getDni(), student);
		return newStudent;
    }
    
    @GET
    @Path("GetAllMyCourses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> GetAllMyCourses(Student student) 
    {	
    	if(student.getDni() < 10000000 || student.getDni() > 99999999) return null;
    	if(student.getPassword() == null || student.getPassword() == "") return null;
    	
    	for(Student s : Student.StudentDataBase.values())
    	{
    		if(s.getDni() == student.getDni()) {
    			if(s.getPassword().equals(student.getPassword())) {
    				List<Course> myCourseList = new ArrayList<Course>();
    				
    				for (String guidCourse : s.getCourses()) 
    		  	  	{
    					myCourseList.add(Course.CourseDataBase.get(guidCourse));
    		  	  	}
        			return myCourseList;
        		}
    			return null;
    		}
    	}
    		
    	return null;
    }

    @Path("Enroll")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course Enroll(EnrollmentRequest enrollmentRequest) 
    {
    	System.out.println(enrollmentRequest.getDni());
    	if(enrollmentRequest.getDni() < 10000000 || enrollmentRequest.getDni() > 99999999) return null;
    	if(enrollmentRequest.getPassword() == null || enrollmentRequest.getPassword() == "") return null;
    	
    	for(Student s : Student.StudentDataBase.values())
    	{
    		if(s.getDni() == enrollmentRequest.getDni()) {
    			if(s.getPassword().equals(enrollmentRequest.getPassword())) {
    				var course = Course.CourseDataBase.get(enrollmentRequest.getGuid());
    				s.getCourses().add(enrollmentRequest.getGuid());
    		    	return course;
        		}
    			return null;
    		}
    	}
    		
    	return null;
    }
}