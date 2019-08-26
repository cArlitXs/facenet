package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User find(int id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public User fullUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(User user) {
		try {
			this.userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean login(User user) {
		User userDB = this.userRepository.findById(user.getId()).get();
		
		if (userDB != null)
			return true;
		else
			return false;
	}

	@Override
	public List<User> friendsRelationship() {
		List<User> userList = null;
		
		for (User user : this.userRepository.findAll()) {
			if(user)
		}
		
		return null;
	}

	@Override
	public List<User> pendingRelationship() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean invitefriend(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean relationship() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRelationship(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
