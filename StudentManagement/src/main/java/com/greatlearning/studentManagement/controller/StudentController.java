package com.greatlearning.studentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.studentManagement.model.Student;
import com.greatlearning.studentManagement.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//visits the Student-form
	@GetMapping("/add")
	public String add() {
		return "add-form";
	}
	
	//saves the data and redirect to students list
	@PostMapping("/save")
	public String save(@ModelAttribute("/save") Student theStudent) {
		
		//saves the new student
		studentService.save(theStudent);
		
		//redirect to /student/list
		return "redirect:/student/list";

	}
	
	//views all students
	@GetMapping("/list")
	public String allStudents(Model theModel) {
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("Students", theStudents);
		return "students-list";
	}
	

	//visits the update-form
	@GetMapping("/edit/{studentId}")
	public String edit(@PathVariable(value="studentId") int studentId, Model theModel) {
		
		//locates the student record to be updated
		Student theStudent = studentService.findById(studentId);
		theModel.addAttribute("Student", theStudent);
		
		//sends to update form
		return "update-form";
	}
	
	//updates the student data and redirects to students list
	@PostMapping("update/{studentId}")
	public String update(@ModelAttribute("update/{studentId}") Student theStudent) {
		
		//updates the student
		studentService.update(theStudent);
		
		return "redirect:/student/list";
	}
		
	//deletes student record after pop-up confirmation
	@GetMapping("/delete/{studentId}")
	public String delete(@PathVariable int studentId) {
		
		//deletes the student		
		studentService.delete(studentId);
		
		return "redirect:/student/list";
		
	}
	
}