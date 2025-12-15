package com.pagination.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagination.Entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	UserEntity findByName(String name);
	UserEntity findByEmail(String email);
	UserEntity findByNameAndEmail (String name, String email);
	List<UserEntity> findByNameOrEmail(String name, String email);
	
}
