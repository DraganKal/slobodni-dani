package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Godisnji;
import jwd.wafepa.model.Radnik;
import jwd.wafepa.repository.GodisnjiRepository;
import jwd.wafepa.repository.RadnikRepository;
import jwd.wafepa.service.RadnikService;

@Service
public class JpaRadnikService implements RadnikService{
	
	@Autowired
	private RadnikRepository radnikRepository;
	@Autowired
	private GodisnjiRepository godisnjiRepository;

	@Override
	public Radnik findOne(Long id) {
		// TODO Auto-generated method stub
		return radnikRepository.findOne(id);
	}

	@Override
	public Page<Radnik> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return radnikRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Radnik save(Radnik radnik) {
		if(radnik.getSlobodniDani() == 0) {
		radnik.setSlobodniDani(20 + radnik.getGodineStaza()/5 + radnik.getSektor().getBonusDana());
		}
		return radnikRepository.save(radnik);
	}

	@Override
	public List<Radnik> save(List<Radnik> radnici) {
		// TODO Auto-generated method stub
		return radnikRepository.save(radnici);
	}

	@Override
	public Radnik delete(Long id) {
		Radnik radnik = radnikRepository.findOne(id);
		if(radnik == null){
			throw new IllegalArgumentException("Pokusavate da obrisete"
					+ "nepostojeceg radnika");
		}
		radnikRepository.delete(radnik);
		return radnik;
	}

	@Override
	public Page<Radnik> search(String idBroj, String imeIPrezime, Long sektorId, int pageNum) {
		if(idBroj != null) {
			idBroj = '%' + idBroj + '%';
		}
		if(imeIPrezime != null) {
			imeIPrezime = '%' + imeIPrezime + '%';
		}
		return radnikRepository.search(idBroj, imeIPrezime, sektorId, new PageRequest(pageNum, 5));
	}

	@Override
	public Godisnji godisnji(Long id, Godisnji godisnji) {
		Radnik radnik = findOne(id);
		if(radnik == null){
			throw new IllegalArgumentException("Pokusavate da obrisete"
					+ "nepostojeceg radnika");
		}else if(radnik.getSlobodniDani() < godisnji.getRadnihDana()) {
			throw new IllegalArgumentException("Nema dovoljno "
					+ "slobodnih dana");
		}
		
		radnik.setSlobodniDani(radnik.getSlobodniDani() - godisnji.getRadnihDana());
		godisnji.setRadnik(radnik);
		godisnjiRepository.save(godisnji);
		radnikRepository.save(radnik);
		
		
		
		return godisnji;
	}

	@Override
	public Radnik put(Radnik radnik) {
		// TODO Auto-generated method stub
		return radnikRepository.save(radnik);
	}
	

}
