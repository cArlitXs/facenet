package es.eoi.redsocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.repository.RelationshipRepository;

@Service
public class RelationshipServiceImpl implements RelationshipService{

	@Autowired
	RelationshipRepository relationshipRepository;

	@Override
	public void save(Relationship relationship) {
		relationshipRepository.save(relationship);
		
	}

	@Override
	public List<Relationship> findAll() {
		
		return relationshipRepository.findAll();
		
	}

	@Override
	public Relationship findById(int id) {
		return relationshipRepository.findById(id).get();
	}

	@Override
	public void remove(int id) {
		relationshipRepository.deleteById(id);		
	}
	
}
	
	
