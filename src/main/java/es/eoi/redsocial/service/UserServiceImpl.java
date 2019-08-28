package es.eoi.redsocial.service;

import java.util.List;

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
	public User findById(int id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public void save(User user) {
		this.userRepository.save(user);
	}

	@Override
	public List<User> showbyUsernamePass(String username, String pass) {
		
		return this.userRepository.findUserByUsernameAndPass(username, pass);
	}
	
	
//	@Autowired
//	RelationshipRepository relationshipRepository;
//
//	@Override
//	public List<User> findAll() {
//		return this.userRepository.findAll();
//	}
//
//	@Override
//	public User find(int id) {
//		return this.userRepository.findById(id).get();
//	}
//
//	@Override
//	public User fullUser(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean save(User user) {
//		try {
//			this.userRepository.save(user);
//			return true;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	@Override
//	public boolean login(User user) {
//		User userDB = this.userRepository.findById(user.getId()).get();
//
//		if (userDB != null)
//			return true;
//		else
//			return false;
//	}
//
//	@Override
//	public List<Relationship> friendsRelationship(User user) {
//		List<Relationship> relationshipList = new ArrayList<Relationship>();
//		
//		List<Relationship> relationshipOrigin = user.getOriginsUsers();
//		
//		for (Relationship r : relationshipOrigin) {
//			if(r.getState().equals(StateRelationship.FRIEND)) {
//				relationshipList.add(r);
//			}
//		}
//		
//		return relationshipList;
//	}
//
//	@Override
//	public List<Relationship> pendingRelationship(User user) {
//		List<Relationship> relationshipList = new ArrayList<Relationship>();
//		
//		List<Relationship> relationshipOrigin = user.getOriginsUsers();
//		
//		for (Relationship r : relationshipOrigin) {
//			if(r.getState().equals(StateRelationship.PENDING)) {
//				relationshipList.add(r);
//			}
//		}
//		
//		return relationshipList;
//	}
//
//	@Override
//	public boolean invitefriend(User originUser, User targetUser) {
//		try {
//			Relationship relationship = new Relationship(originUser, targetUser, StateRelationship.PENDING);
//
//			relationshipRepository.save(relationship);
//
//			return true;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	@Override
//	public boolean relationship(Relationship relationship) {
//		try {
//			relationship.setState(StateRelationship.FRIEND);
//
//			relationshipRepository.save(relationship);
//
//			return true;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	@Override
//	public boolean deleteRelationship(Relationship relationship) {
//		try {
//			relationshipRepository.delete(relationship);
//
//			return true;
//		} catch (Exception e) {
//			throw e;
//		}
//	}

}
