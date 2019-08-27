package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;

public interface ReactionService {

	public void save(Reaction reaction);

	public List<Reaction> findAll();

	public Reaction findById(int id);

	public void remove(int id);
}
