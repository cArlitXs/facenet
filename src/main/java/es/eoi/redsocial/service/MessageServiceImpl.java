package es.eoi.redsocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.repository.MessageRepository;

@Service
public class MessageServiceImpl implements  MessageService{
	
	@Autowired
	MessageRepository messageRepository;

	public void save(Message message) {
		messageRepository.save(message);
	}

	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	public Message findById(int id) {
		return messageRepository.findById(id).get();
	}

	public void remove(int id) {
		messageRepository.deleteById(id);		
	}

}
