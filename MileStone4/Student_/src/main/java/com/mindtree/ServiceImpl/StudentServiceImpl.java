package com.mindtree.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Entity.Student;
import com.mindtree.Repository.StudentRepository;
import com.mindtree.Service.StudentService;
import com.mindtree.VO.College;
import com.mindtree.VO.ResponseTemplate;



@Component
public class StudentServiceImpl implements StudentService
{
	

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public Student add(Student stud) {
		// TODO Auto-generated method stub
		return studentRepository.save(stud);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student searchById(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}

	@Override
	public ResponseTemplate studentWithCollege(long studId) {
		// TODO Auto-generated method stub
	
		ResponseTemplate RT = new ResponseTemplate();
		Student stud= studentRepository.findById(studId);
		long colg_id = stud.getColg_id();
		College colg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+colg_id, College.class);
		RT.setCollege(colg);
		RT.setStudent(stud);
		return RT;
	}

	@Override
	public Student assignCollege(long studId, long colgId) {
		// TODO Auto-generated method stub
		
		Student stud = studentRepository.findById(colgId);
		College colg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+colgId, College.class);
		if(stud==null|| colg==null)
		{
			return null;
		}
		
		stud.setColg_id(colgId);
		studentRepository.save(stud);
		return stud;
	}

	@Override
	public List<Student> getByColgId(long colg_id) {
		// TODO Auto-generated method stub
		
		return studentRepository.getByColgId(colg_id);
	}

	@Override
	public List<Student> getStudentByCollegeWithDescAge(long colg_id) {
		// TODO Auto-generated method stub
		
		return studentRepository.getStudentByCollegeWithDescAge(colg_id);
	}

}
