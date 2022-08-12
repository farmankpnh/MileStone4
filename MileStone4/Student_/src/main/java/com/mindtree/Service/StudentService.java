package com.mindtree.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Entity.Student;
import com.mindtree.VO.ResponseTemplate;



@Service
public interface StudentService {

	
	Student add(Student stud);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate studentWithCollege(long studId);
	Student assignCollege(long studId, long colgId);
	List<Student> getByColgId(long colg_id);
	List<Student> getStudentByCollegeWithDescAge(long colg_id);
}
