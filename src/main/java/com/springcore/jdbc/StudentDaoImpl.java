package com.springcore.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		String query="insert into student(id,name,city) value(?,?,?)";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity() );
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public int change(Student student) {
		//updating data
		String query="update student set name=?,city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public int delete(int studentId) {
		
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,studentId);
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
//select single student data
		String query="Select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		//selecting multiple student /all student
		String query="Select * from student";
		List<Student> s=this.jdbcTemplate.query(query,new RowMapperImpl());
		return s;
	}
	
	//public T queryforObject(String sql,RowMapper<T> row mapper, object args)
	//public List<T> query(String sql,RowMapper<T> rowmapper)
	
	
	

}
