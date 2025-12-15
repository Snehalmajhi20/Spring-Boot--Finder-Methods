package com.pagination;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.pagination.Entity.UserEntity;
import com.pagination.Repository.UserRepo;

@SpringBootApplication
public class SpringbootPaginationPrac01Application {

	public static void main(String[] args) {
		ApplicationContext Context = SpringApplication.run(SpringbootPaginationPrac01Application.class, args);
		UserRepo repo = Context.getBean(UserRepo.class);
		
		UserEntity obj = repo.findByName("Snehal");
		System.out.println(obj);		
		UserEntity obj1 = repo.findByEmail("snehalmajhi@gmail.com");
		System.out.println(obj1);
		
		UserEntity obj2 = repo.findByNameAndEmail("Snehal", "snehalmajhi@gmail.com");
		System.out.println(obj2);
		
		List<UserEntity> obj3 = repo.findByNameOrEmail("Snehal", "snehalmajhi@gmail.com");
		System.out.println(obj3);
//		obj3.forEach(e -> System.out.println(e));
		
	}

}
