package com.greatlearning.studentManagement.services;

import java.util.List;

import com.greatlearning.studentManagement.model.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int studentId);

	public void delete(int studentId);

	public void save(Student theStudent);

	public void update(Student thestudent);

}
