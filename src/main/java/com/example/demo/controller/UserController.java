package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/all")
	public ResponseEntity<List<User>> all(){
		return new ResponseEntity<>(userService.all(),HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<User> User(@PathVariable("id") int id){
		return userService.user(id).map(user-> new ResponseEntity<>(user,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user){
		return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id")int id){
		if(userService.update(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id")int id) {
		try {
			userService.delete(id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}catch (Error e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);// TODO: handle exception
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity update1(@RequestBody User user){
		return new ResponseEntity<>(userService.update1(user),HttpStatus.CREATED);	
	}

}
