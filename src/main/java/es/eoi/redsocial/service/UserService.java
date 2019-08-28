package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findById(int id);

	public void save(User user);
	
	public List<User> showbyUsernamePass(String username, String pass);
}
