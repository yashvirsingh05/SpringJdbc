package com.springcore.jdbc.annotation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class App {
	public static void main(String[] args) {
		
		
		System.out.println("yash"); 
		
	//ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/jdbc/student.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(javaConfig.class);
	StudentDao template=	context.getBean("studentDao",StudentDao.class);
	
	//using jdbc template
//	JdbcTemplate temp=context.getBean("jdbcTemplate",JdbcTemplate.class);
//	String query="insert into student(id,name,city) value(?,?,?)";
//	int result=temp.update(query,18,"thakur","Aligarh");
//	System.out.println("sdhha" +result);
	//using interface
//insert
	//  Student st=new Student();
//  st.setId(8);
//  st.setCity("thakur");
//  st.setName("delhi");
//  int result=template.insert(st);
//	System.out.println("sdhha" +result);
//
//	update
//	Student s=new Student();
//	s.setId(1);
//	s.setName("yash");
//	s.setCity("noida:");
//	int r=template.change(s);
//	System.out.print("dsjcn");
	
	//delete
	int r=template.delete(12);
	System.out.println(r);
	
	//Row mapper single data
//	Student s=template.getStudent(18);
//	System.out.println(s);
		
	//multiple data
List<Student> s1=template.getAllStudents();
for(Student s2:s1) {
	
	System.out.println(s2);
}
	
	
	}
}
