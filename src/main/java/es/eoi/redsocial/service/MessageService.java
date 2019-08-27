package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Message;


public interface MessageService {

	
	public void save(Message message);

	
	public List<Message> findAll();

	
	public Message findById(int id);

	
	public void remove(int id);
	
}
