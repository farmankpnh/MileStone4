package com.mindtree.college;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;

@SpringBootTest
class CollegeApplicationTests {

	
	@Autowired
	CollegeRepository collegeRepository;
	@Test
	public void jTest() {
		
		College c = new College();
		
		c.setId(1);
		c.setName("Sarvodaya College");
		c.setTotalStudents(500);
		
		collegeRepository.save(c);
		assertNotNull(collegeRepository.findById(1).getId());
	}

}
