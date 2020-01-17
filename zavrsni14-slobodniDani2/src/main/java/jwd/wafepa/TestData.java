package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Radnik;
import jwd.wafepa.model.Sektor;
import jwd.wafepa.service.RadnikService;
import jwd.wafepa.service.SektorService;


@Component
public class TestData {
	
	@Autowired
	private SektorService sektorService;
	@Autowired
	private RadnikService radnikService;


	
	@PostConstruct
	public void init() {
	
		Sektor s1 = new Sektor("Sektor1", 10);
		sektorService.save(s1);
		Sektor s2 = new Sektor("Sektor2", 5);
		sektorService.save(s2);
		
		Radnik r1 = new Radnik();
		r1.setEmail("email1@email.com");
		r1.setGodineStaza(5);
		r1.setIdBroj("neki id broj1");
		r1.setImeIPrezime("Ime1 prezime1");
		r1.setSektor(s1);
		radnikService.save(r1);
		sektorService.save(s1);
		
		Radnik r2 = new Radnik();
		r2.setEmail("email2@email.com");
		r2.setGodineStaza(14);
		r2.setIdBroj("neki id broj2");
		r2.setImeIPrezime("Ime2 prezime2");
		r2.setSektor(s1);
		radnikService.save(r2);
		sektorService.save(s1);
		
		
		
		
		
		
		
	}

}
