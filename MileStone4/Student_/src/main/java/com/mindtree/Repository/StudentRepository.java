package com.mindtree.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{


	Student findById(long id);
	
	@Query(value="Select* from student WHERE colg_id=:colg_id ORDER BY name ASC", nativeQuery = true)
	 List<Student> getByColgId(@Param ("colg_id") long colg_id);
	
	@Query (value="Select* from student WHERE colg_id=:colg_id ORDER BY age DESC", nativeQuery = true) List<Student> getStudentByCollegeWithDescAge(@Param("colg_id") long colg_id);
	
}
