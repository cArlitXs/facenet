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

import es.eoi.redsocial.dto.EventDto;
import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.enums.StateAssist;
import es.eoi.redsocial.service.EventService;
import es.eoi.redsocial.service.UserService;

@RestController
public class EventsController 
{
	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/events")
	public List<EventDto> findAll() throws ParseException 
	{
		List<EventDto> eventsDto = new ArrayList<EventDto>();
		EventDto eventDto = new EventDto();
		UserDto userDto = new UserDto();
		User user = new User();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd"); 
		for (Event event : eventService.findAll())
		{
			user = event.getUser();
			
			BeanUtils.copyProperties(user,userDto);
			
			BeanUtils.copyProperties(event,eventDto);
			eventDto.setUser(userDto);
			userDto.setBirtdate(format.format(user.getBirtdate()));
			userDto.setStardate(format.format(user.getStardate()));
			eventDto.setEventdate(format.format(event.getEventdate()));
			
			eventsDto.add(eventDto);
		}
		//BeanUtils.copyProperties(bancoDto, banco);
		return eventsDto;
	}
	
	@GetMapping("/events/{id}")
	public EventDto findEventbyId(@PathVariable int id) 
	{
		EventDto eventDto = new EventDto();
		Event event = eventService.findById(id);
		UserDto userDto = new UserDto();
		User user = new User();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd"); 

		user = event.getUser();
		
		BeanUtils.copyProperties(user,userDto);
		
		BeanUtils.copyProperties(event,eventDto);
		eventDto.setUser(userDto);
		userDto.setBirtdate(format.format(user.getBirtdate()));
		userDto.setStardate(format.format(user.getStardate()));
		eventDto.setEventdate(format.format(event.getEventdate()));
		
		return eventDto;
		
	}
	
	@PostMapping("/events")
	public void updateEvent(@RequestBody EventDto eventDto) throws ParseException {
		Event event = new Event();
		UserDto userDto = new UserDto();
		User user = new User();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd"); 
		
		userDto = eventDto.getUser();
		//user = userService.findById(userDto.getId());
		
		//cliente.setFecha_nac(format.parse(clienteDto.getFecha_nac()));
		//user.setBirtdate(format.parse(userDto.getBirtdate()));
		//user.setStardate(format.parse(userDto.getStardate()));
		BeanUtils.copyProperties(userDto,user);
		event.setUser(user);
		
		event.setEventdate(format.parse(eventDto.getEventdate()));
		BeanUtils.copyProperties(eventDto, event);
		eventService.save(event);
	}
	
	@PostMapping("/eventss/{id}")
	public void yesAssistance(@PathVariable int id,@RequestBody UserDto userDto)
	{
		Event event = eventService.findById(id);
		Assistance assistance = new Assistance();
		User user = new User();
		BeanUtils.copyProperties(userDto,user);
		
		assistance.setEventAssistance(event);
		assistance.setUserAssistance(user);
		assistance.setState(StateAssist.yesAssistance);
		
		List<Assistance> assistances = event.getRegistrations();
		assistances.add(assistance);
		event.setRegistrations(assistances);
		eventService.save(event);
		
		/*EventDto eventDto = new EventDto();
		Assistance assistance = new Assistance();
		AssistanceDto assistanceDto = new AssistanceDto();
		
		User user = new User();
		user = userService.findById(userDto.getId());
		
		BeanUtils.copyProperties(user,userDto);
		BeanUtils.copyProperties(event,eventDto);
		assistanceDto.setEventAssistance(eventDto);
		assistanceDto.setUserAssistance(userDto);
		assistanceDto.setState("yesAssistance");
		
		BeanUtils.copyProperties(assistanceDto,assistance);
		
		List<Assistance> assistances = new ArrayList<Assistance>();
		assistances.add(assistance);
		event.setRegistrations(assistances);
		
		eventService.save(event);*/
	}
}
