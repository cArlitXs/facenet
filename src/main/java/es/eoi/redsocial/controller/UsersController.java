package es.eoi.redsocial.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.dto.UserFullDto;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.EventService;
import es.eoi.redsocial.service.UserService;

@RestController
public class UsersController {

	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/users")
	public List<UserDto> findAll() throws ParseException 
	{
		List<UserDto> usersDto = new ArrayList<UserDto>();
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		for(User user : userService.findAll()) {
			UserDto userDto = new UserDto();

			BeanUtils.copyProperties(user,userDto);
			userDto.setBirtdate(format.format(user.getBirtdate()));
			userDto.setStardate(format.format(user.getStardate()));
			usersDto.add(userDto);
			
		}
		return usersDto;
		
	}
	
	@GetMapping("/users/{id}")
	public UserDto findUsersbyId(@PathVariable int id) 
	{
		UserDto userDto = new UserDto();
		User user = userService.findById(id);
		
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd"); 
		BeanUtils.copyProperties(user,userDto);
		
		userDto.setBirtdate(format.format(user.getBirtdate()));
		userDto.setStardate(format.format(user.getStardate()));
		
		return userDto;
		
	}
	
	@GetMapping("/users/fullUser/{id}")//Se produce un bucle infinito y no lo puede parsear a JSON
	public UserFullDto findFullUser(@PathVariable int id) 
	{
		UserFullDto userFullDto = new UserFullDto();
		User user = userService.findById(id);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd"); 
		BeanUtils.copyProperties(user,userFullDto);
		userFullDto.setBirtdate(format.format(user.getBirtdate()));
		userFullDto.setStardate(format.format(user.getStardate()));
		
		return userFullDto;
		
	}
	
	@PostMapping("/users")
	public void newUser(@RequestBody UserDto userDto) throws ParseException {
		
		User user = new User();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd"); 
		
		user.setBirtdate(format.parse(userDto.getBirtdate()));
		user.setStardate(format.parse(userDto.getStardate()));
		BeanUtils.copyProperties(userDto,user);
		
		userService.save(user);
	}
	
	@PostMapping("/users/login")
	public void login(@RequestBody String username, String pass) throws ParseException {
		
		userService.showbyUsernamePass(username, pass);
		
	}
	
}