package com.mannu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mannu.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	Student findByName(String name);
	Student findByAddress(String address);
	Student findByNameAndAddress(String name,String address);
	List<Student> findByNameOrAddress(String name,String address);

}
