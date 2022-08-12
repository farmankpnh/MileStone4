package com.mindtree.college.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;
import com.mindtree.college.service.CollegeService;
import com.mindtree.college.vo.RequestTemplate;
import com.mindtree.college.vo.Student;


@Component
public class CollegeServiceImpl implements CollegeService 
{

	
	@Autowired
	CollegeRepository collegeRepository;
	@Autowired
	RestTemplate restTemplate;
	@Override
	public College add(College colg) {
		// TODO Auto-generated method stub
		return collegeRepository.save(colg);
	}
	@Override
	public List<College> list() {
		// TODO Auto-generated method stub
		return collegeRepository.findAll();
	}
	@Override
	public College update(long id, String name) {
		// TODO Auto-generated method stub
		College colg= collegeRepository.findById(id);
		colg.setName(name);
		return collegeRepository.save(colg);
	}
	@Override
	public College searchById(long id) {
		if(collegeRepository.findById(id)==null)
		{
			return null;
		}
		return collegeRepository.findById(id);
	}
	@Override
	public List<RequestTemplate> listWithStud() {
		List<RequestTemplate> fullList= new ArrayList<RequestTemplate>();
		List<College> allcolg= this.list();
		Iterator<College> ir = allcolg.iterator();
		while(ir.hasNext())
		{
			College colg= ir.next();
			ResponseEntity<Student[]> response= restTemplate.getForEntity("http://STUDENT-SERVICE/student-with-ascname//"+colg.getId(), Student[].class);;
			Student[] students = response.getBody();
			List<Student> stud = Arrays.asList(students);
			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(colg);
			RTm.setStudentList(stud);
			fullList.add(RTm);
			
		}
		return fullList;
		
	}
	
	@Override
	public RequestTemplate specificCollegeStudent(long colg_id) {
		// TODO Auto-generated method stub
		College college =this.searchById(colg_id);
		
		ResponseEntity<Student[]> response = restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-desc-age/"+college.getId(),Student[].class);
		
		Student[] student = response.getBody();
		List<Student> students = Arrays.asList(student);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);
		return null;
	}
	
	


}
