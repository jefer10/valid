package com.example.demo.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.User;

public interface UserCrudRepository extends JpaRepository<User, Integer> {
	

}
