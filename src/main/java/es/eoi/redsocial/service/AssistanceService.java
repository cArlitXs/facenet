package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Assistance;

public interface AssistanceService {
	
	public void save(Assistance assistance);

	public List<Assistance> findAll();

	public Assistance findById(int id);

	public void remove(int id);
}
