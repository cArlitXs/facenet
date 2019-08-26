package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.User;

public interface UserService {

	public List<User> findAll();

	public User find(int id);

	public User fullUser(int id);

	public boolean save(User user);

	public boolean login(User user);
	
	public List<User> friendsRelationship();
	
	public List<User> pendingRelationship();
	
	public boolean invitefriend(int id);
	
	public boolean relationship();
	
	public boolean deleteRelationship(int id);

}
