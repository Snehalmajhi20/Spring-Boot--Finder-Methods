package com.mannu;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mannu.entity.Student;
import com.mannu.repository.StudentRepo;

@SpringBootApplication
public class Springboot18RestApiApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Springboot18RestApiApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		Student findByName = repo.findByName("Priya Sahoo");
		System.out.println(findByName);
		
		Student findByAddress = repo.findByAddress("Delhi");
		System.out.println(findByAddress);
		
		Student findByNameAndAddress = repo.findByNameAndAddress("Ravi Mishra", "Bengaluru");
		System.out.println(findByNameAndAddress);
		
		List<Student> findByNameOrAddress = repo.findByNameOrAddress("Amit Nayak", "Odisha");
		findByNameOrAddress.forEach(e->System.out.println(e));
		
		//pageble creation and sort
		Sort sort= Sort.by("address").ascending();
		Pageable pageable = PageRequest.of(0, 9,sort);
		Page<Student> page = repo.findAll(pageable);
		page.get().forEach(e->System.out.println(e));
		System.out.println("Size: "+page.getSize());
		System.out.println("Elements: "+page.getTotalElements());
		System.out.println("Pages: "+page.getTotalPages());
	}

}
