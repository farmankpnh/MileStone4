package com.mindtree.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Entity.Student;
import com.mindtree.Service.StudentService;
import com.mindtree.VO.ResponseTemplate;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping
	public Student add(@RequestBody Student stud)
	{
		return studentService.add(stud);
	}
	
	@GetMapping
	public List<Student> listStud()
	{
		return studentService.list();
	}
	
	@GetMapping("/{studId}")
	public ResponseTemplate studentWithCollege(@PathVariable long studId)
	{
		return studentService.studentWithCollege(studId);
	}
	
	@PutMapping("/{studId}/{colgId}")
	public String updateCollege( @PathVariable long studId, @PathVariable long colgId)
	{
		Student stud = studentService.assignCollege(studId, colgId);
		if(stud!=null)
		{
			return stud.toString();
		}
		return "sorry college or student not found";
	}

	@GetMapping("/student-with-ascname/{colg_id}")
	public List<Student> getByCollegeId(@PathVariable long colg_id)
	{
		return studentService.getByColgId(colg_id);
	}
	
	@GetMapping("/student-with-desc-age/{colg_id}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable long colg_id)
	{
		return studentService.getStudentByCollegeWithDescAge(colg_id);
		
	
	}
}
