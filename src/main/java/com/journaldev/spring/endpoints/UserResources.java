package com.journaldev.spring.endpoints;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.journaldev.spring.bean.User;
import com.journaldev.spring.daoservice.UserDaoService;
import com.journaldev.spring.exception.UserNotFoundException;

@RestController
public class UserResources {
	
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/internationalization")
	public String welComeMessage(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null , locale);
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		//return service.finaOne(id);
		User user = service.finaOne(id);
		if(user == null)
			throw new UserNotFoundException(id+" not found.");
		
		//"all-users, SERVER_PATH+"/users/
		/*Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = 
		linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		return resource;*/
		return user;
	}
	
	private ControllerLinkBuilder linkTo(List<User> retrieveAllUsers) {
		// TODO Auto-generated method stub
		return null;
	}

	private UserResources methodOn(Class<? extends UserResources> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		//return service.finaOne(id);
		User user = service.deleteById(id);
		if(user == null)
			throw new UserNotFoundException(id+" not found.");
		return user;
	}
	
	/*@PostMapping("/users")
	public User saveUsers(@RequestBody User user){
	return service.save(user);
	}*/
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveNewUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
		
	}
	
	
}
