package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// this tells Spring MVC that this will handle REST HTTP requests
@RestController
public class HelloWorldController {

		
	//Send a get request
	//to uri "hello"
	//using method helloWorld, which returns a string
	//both of below do the same thing. getmapping is just an annotation that we can use
//	@RequestMapping(method=RequestMethod.GET, path="/hello")
	@GetMapping(path="/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping(path="/helloBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean ("Hello World");
	}
	
	@GetMapping(path="/helloBean/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean (String.format("Hello World, %s", name));
	}
	
	
}
