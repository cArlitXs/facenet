package es.eoi.redsocial.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.MessageDto;
import es.eoi.redsocial.dto.MessageDtoAutoId;
import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.enums.StateRelationship;
import es.eoi.redsocial.service.MessageService;
import es.eoi.redsocial.service.ReactionService;
import es.eoi.redsocial.service.RelationshipService;
import es.eoi.redsocial.service.UserService;

@RestController
public class MessagesController {

	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	@Autowired
	ReactionService reactionService;
	@Autowired
	RelationshipService relationshipService;

	@GetMapping("/messages/{id}")
	public MessageDto getMessage(@PathVariable int id) {
		Message message = messageService.findById(id);
		MessageDto messageDto = new MessageDto();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		BeanUtils.copyProperties(message, messageDto);

		messageDto.setId(message.getId());
		messageDto.setContent(message.getContent());
		messageDto.setPublishdate(format.format(message.getPublishdate()));
		messageDto.setUser(message.getUser().getId());

		return messageDto;
	}

	@GetMapping("/messages/user/{id}")
	public List<MessageDto> getMessagesByUser(@PathVariable int id) {
		User user = userService.findById(id);
		List<Message> messageList = user.getMessage();

		List<MessageDto> messageListDto = new ArrayList<MessageDto>();

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		BeanUtils.copyProperties(messageList, messageListDto);

		for (Message m : messageList) {
			MessageDto messageDto = new MessageDto();
			messageDto.setId(m.getId());
			messageDto.setContent(m.getContent());
			messageDto.setPublishdate(format.format(m.getPublishdate()));
			messageDto.setUser(m.getUser().getId());
			messageListDto.add(messageDto);
		}

		return messageListDto;
	}

	@GetMapping("/messages/user/{id}/friendPost")
	public List<MessageDto> getMessagesByFriends(@PathVariable int id) {
		List<Relationship> relationshipList = relationshipService.findAll();
		List<MessageDto> resMessageList = new ArrayList<MessageDto>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		for (Relationship relationship : relationshipList) {
			User oUser = relationship.getOriginUser();
			if (oUser.getId() == id) {
				User dUser = relationship.getTargetUser();
				StateRelationship rel = relationship.getState();

				if (rel.equals(StateRelationship.FRIEND)) {
					List<Message> dMessage = messageService.findAll();
					for (Message message : dMessage) {
						if (message.getUser().equals(dUser)) {
							MessageDto resMessage = new MessageDto();
							resMessage.setId(message.getId());
							resMessage.setContent(message.getContent());
							resMessage.setPublishdate(format.format(message.getPublishdate()));
							resMessage.setUser(message.getUser().getId());
							resMessageList.add(resMessage);
						}
					}
				}
			}
		}

		return resMessageList;
	}

	@PostMapping("/messages")
	public void setMessage(@RequestBody MessageDtoAutoId messageDtoAutoId) {
		Message message = new Message();

		BeanUtils.copyProperties(messageDtoAutoId, message);
		message.setUser(userService.findById(messageDtoAutoId.getUser()));
		message.setContent(messageDtoAutoId.getContent());
		message.setPublishdate(new Date());

		messageService.save(message);
	}

//	@GetMapping("/messages/user/{id}/reactions")
//	public List<MessageDto> getReactions(@PathVariable int id) {
//		return null;
//	}

	@DeleteMapping("messages/{id}")
	public void deleteMessage(@PathVariable int id) {
		messageService.remove(id);
	}

//	@PostMapping("/messages/{id}/reactions")
//	public void setReactions() {
//	}
}
