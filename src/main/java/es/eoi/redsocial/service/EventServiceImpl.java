package es.eoi.redsocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService 
{
	@Autowired
	EventRepository eventRepository;
	
	public void save(Event event)
	{
		eventRepository.save(event);	
	}

	public List<Event> findAll()
	{
		return eventRepository.findAll();
	}

	public Event findById(int id)
	{
		return eventRepository.findById(id).get();
	}

	public void remove(int id)
	{
		eventRepository.deleteById(id);
	}

}
