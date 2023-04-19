package com.api_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.api_rest.model.User;
import com.api_rest.service.UserServices;

@Controller
@RequestMapping("/E3W2U2/users")
public class UserController {
	
	@Autowired UserServices userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.findAllUser(), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> postNewUser(@RequestBody User user) {
		return new ResponseEntity<String>(userService.persistUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putUser(@RequestBody User user) {
		return new ResponseEntity<String>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestBody User user) {
		return new ResponseEntity<String>(userService.removeUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
		return new ResponseEntity<String>(userService.removeUser(id), HttpStatus.OK);
	}
	
}
