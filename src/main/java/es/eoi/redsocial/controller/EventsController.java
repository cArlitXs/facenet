package es.eoi.redsocial.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.EventDto;
import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.EventService;

@RestController
public class EventsController 
{
	@Autowired
	EventService eventService;
	
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
			
			eventsDto.add(eventDto);
		}
		//BeanUtils.copyProperties(bancoDto, banco);
		return eventsDto;
	}
}
