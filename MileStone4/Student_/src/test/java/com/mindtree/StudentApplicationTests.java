package com.mindtree;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.Entity.Student;
import com.mindtree.Repository.StudentRepository;




@SpringBootTest
class StudentApplicationTests {

StudentRepository studentRepository;	
	@Test
	public void jUnitTest()
	{
        Student st = new  Student();
        
        st.setId(1);
        st.setName("Farman");
        st.setGender("Male");
        st.setAge(24);
        st.setStream("Science");
        st.setColg_id(1);
        
        studentRepository.save(st);
        
        assertNotNull(studentRepository.findById(2).getId());
        st.setColg_id(1);
        
	}

}
