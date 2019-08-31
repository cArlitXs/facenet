package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Event;

public interface EventService
{

	public void save(Event event);

	public List<Event> findAll();

	public Event findById(int id);

	public void remove(int id);
}
