package es.eoi.redsocial.service;

import java.util.List;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.repository.ReactionRepository;

public class ReactionServiceImpl implements ReactionService {

	ReactionRepository reactionRepository;
	
	@Override
	public void save(Reaction reaction) {
		reactionRepository.save(reaction);		
	}
	@Override
	public List<Reaction> findAll() {
		return reactionRepository.findAll();
	}

	@Override
	public Reaction findById(int id) {
		return reactionRepository.findById(id).get();
	}

	@Override
	public void remove(int id) {
		reactionRepository.deleteById(id);	
		
	}
}
