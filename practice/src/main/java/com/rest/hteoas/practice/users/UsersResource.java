package com.rest.hteoas.practice.users;

import java.util.Arrays;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.hteoas.practice.model.Users;

@RestController
@RequestMapping("/rest/users")
public class UsersResource{

	@RequestMapping(value= "/all",method =RequestMethod.GET)	
			
	public java.util.List<Users> getAll()
	{
		
		Users user1= new Users("Anindya",15000);
		
		Users user2= new Users("Sayali",15000);
		
		return Arrays.asList(user1,user2);
	}
		

	@RequestMapping(value= "/hateoasAll", method =RequestMethod.GET,  produces =  MediaTypes.HAL_JSON_VALUE)
	public java.util.List<Users> getHateoasAll()
	{
	
		Users user1= new Users("Anindya",15000);
		Link link1 = ControllerLinkBuilder.linkTo(UsersResource.class)
				.slash(user1.getUserName()).withSelfRel();
		
		user1.add(link1);
		
		Users user2= new Users("Sayali",15000);
		
		

		Link link2 = ControllerLinkBuilder.linkTo(UsersResource.class)
					.slash(user2.getUserName()).withSelfRel();
		user2.add(link2);
		return Arrays.asList(user1,user2);
	}
	
	@RequestMapping(value="/Anindya", method= RequestMethod.GET)
	public String obj1()
	{
		return "This is Anindya";
	}
	
	@RequestMapping(value="/Sayali", method= RequestMethod.GET)
	public String obj2()
	{
		return "This is Sayali";
	}
}
