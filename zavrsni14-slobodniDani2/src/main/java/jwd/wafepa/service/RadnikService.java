package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.wafepa.model.Godisnji;
import jwd.wafepa.model.Radnik;

public interface RadnikService {

	Radnik findOne(Long id);
	
	Page<Radnik> findAll( int pageNum);
	
	Radnik save(Radnik radnik);
	Radnik put(Radnik radnik);
	
	List<Radnik> save(List<Radnik> radnici);
	
	Radnik delete(Long id);
	
	Page<Radnik> search(
			@Param("idBroj") String idBroj, 
			@Param("imeIPrezime") String imeIPrezime, 
			@Param("sektorId") Long sektorId, 
			 int pageNum);
	
	Godisnji godisnji(Long id, Godisnji godisnji);
}
