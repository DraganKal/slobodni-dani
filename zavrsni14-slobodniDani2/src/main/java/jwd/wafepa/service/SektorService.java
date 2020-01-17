package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Sektor;

public interface SektorService {
	
	Sektor findOne(Long id);
	
	List<Sektor> findAll();
	
	Sektor save(Sektor sektor);
	
	List<Sektor> save(List<Sektor> sektori);
	
	Sektor delete(Long id);

}
