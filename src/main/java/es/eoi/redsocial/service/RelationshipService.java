package es.eoi.redsocial.service;

import java.util.List;
import es.eoi.redsocial.entity.Relationship;

public interface RelationshipService {

	public void save(Relationship relationship);

	public List<Relationship> findAll();

	public Relationship findById(int id);

	public void remove(int id);
}
