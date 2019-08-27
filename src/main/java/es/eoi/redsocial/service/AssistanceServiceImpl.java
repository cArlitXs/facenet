package es.eoi.redsocial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.repository.AssistanceRepository;

@Service
public class AssistanceServiceImpl implements AssistanceService {

	@Autowired
	AssistanceRepository assistanceRepository;
	
	@Override
	public void save(Assistance assistance) {
		assistanceRepository.save(assistance);
	}

	@Override
	public List<Assistance> findAll() {
		return assistanceRepository.findAll();
	}

	@Override
	public Assistance findById(int id) {
		return assistanceRepository.findById(id).get();
	}

	@Override
	public void remove(int id) {
		assistanceRepository.deleteById(id);
		
	}
	

	
}
