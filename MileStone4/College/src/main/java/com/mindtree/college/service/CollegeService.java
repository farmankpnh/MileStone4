package com.mindtree.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.college.entity.College;
import com.mindtree.college.vo.RequestTemplate;

@Service
public interface CollegeService {
	
	College add(College colg);
	List<College> list();
	College update(long id, String name);
	College searchById(long id);
	List<RequestTemplate> listWithStud();
	RequestTemplate specificCollegeStudent(long colg_id);

}
