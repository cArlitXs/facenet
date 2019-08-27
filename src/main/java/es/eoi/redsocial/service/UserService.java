package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;

public interface UserService {

	public List<User> findAll();

	public User find(int id);

	public User fullUser(int id);

	public boolean save(User user);

	public boolean login(User user);

	List<Relationship> friendsRelationship(User user);
	
	public List<Relationship> pendingRelationship(User user);

	boolean invitefriend(User userOrigen, User userDestino);

	boolean relationship(Relationship relationship);

	boolean deleteRelationship(Relationship relationship);

}
