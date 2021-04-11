package com.example.demo.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.crud.UserCrudRepository;
import com.example.demo.persistence.entity.User;

@Repository
public class UserRepository {
	
	@Autowired
	private UserCrudRepository userCrudRepository;
	
	public List<User> all(){
		return (List<User>) userCrudRepository.findAll();
	}
	
	public Optional<User> user(int id){
		return userCrudRepository.findById(id);
	}
	
	public List<User> users(List<Integer>ids){
		return userCrudRepository.findAllById(ids);
	}
	
	public User save(User user) {
		return userCrudRepository.save(user);
	}
	
	public User update(User user) {
		return userCrudRepository.save(user);
	}

	public void delete(int id) {
		userCrudRepository.deleteById(id);
	}
	
}
