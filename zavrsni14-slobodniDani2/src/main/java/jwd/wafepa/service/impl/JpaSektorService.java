package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Sektor;
import jwd.wafepa.repository.SektorRepository;
import jwd.wafepa.service.SektorService;

@Service
public class JpaSektorService implements SektorService{
	
	@Autowired
	private SektorRepository sektorRepository;

	@Override
	public Sektor findOne(Long id) {
		// TODO Auto-generated method stub
		return sektorRepository.findOne(id);
	}

	@Override
	public List<Sektor> findAll() {
		// TODO Auto-generated method stub
		return sektorRepository.findAll();
	}

	@Override
	public Sektor save(Sektor sektor) {
		// TODO Auto-generated method stub
		return sektorRepository.save(sektor);
	}

	@Override
	public List<Sektor> save(List<Sektor> sektori) {
		// TODO Auto-generated method stub
		return sektorRepository.save(sektori);
	}

	@Override
	public Sektor delete(Long id) {
		Sektor sektor = sektorRepository.findOne(id);
		if(sektor == null){
			throw new IllegalArgumentException("Pokusavate da obrisete"
					+ "nepostojeci sektor");
		}
		sektorRepository.delete(sektor);
		return sektor;
	}

}
