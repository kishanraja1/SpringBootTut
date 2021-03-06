package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	//get /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//get /users/{id}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
	return service.findOne(id);
	}
	
	//post that takes details of user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id})")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
//		if(user==null)
//			throw new UserNotFoundException("id-" + id);
		
		return user;
		
		
	}
	
}
