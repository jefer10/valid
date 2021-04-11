package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.UserRepository;
import com.example.demo.persistence.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> all() {
		return userRepository.all();
	}
	
	public Optional<User> user(int id) {
		return userRepository.user(id);
	}

	public User save(User user) {
		user.setProcess(false);
		return userRepository.save(user);
	}
	
	public Boolean update(User user) {
		try {
			userRepository.update(user);
			return true; 
		}catch (Error e) {
			return false;// TODO: handle exception
		}
	}
	
	public void delete(int id) {
		userRepository.delete(id);
	}
	
	
}
