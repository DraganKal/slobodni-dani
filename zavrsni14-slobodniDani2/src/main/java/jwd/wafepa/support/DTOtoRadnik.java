package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Radnik;
import jwd.wafepa.model.Sektor;
import jwd.wafepa.service.RadnikService;
import jwd.wafepa.service.SektorService;
import jwd.wafepa.web.dto.RadnikDTO;

@Component
public class DTOtoRadnik implements Converter<RadnikDTO, Radnik>{
	
	@Autowired
	private RadnikService radnikService;
	@Autowired
	private SektorService sektorService;
	
	@Override
	public Radnik convert(RadnikDTO dto) {
		
		Sektor sektor = sektorService.findOne(dto.getSektorId());
	
		if(sektor != null) {
			
			Radnik radnik = null;
			
			if(dto.getId() != null) {
				radnik = radnikService.findOne(dto.getId());
			}
			else {
				radnik = new Radnik();
			}
			
			radnik.setEmail(dto.getEmail());
			radnik.setGodineStaza(dto.getGodineStaza());
			radnik.setId(dto.getId());
			radnik.setIdBroj(dto.getIdBroj());
			radnik.setImeIPrezime(dto.getImeIPrezime());
			radnik.setSektor(sektor);
			radnik.setSlobodniDani(dto.getSlobodniDani());
			
			return radnik;
		}else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}
	}

	public List<Radnik> convert(List<RadnikDTO> dtos){
		List<Radnik> ret = new ArrayList<>();
		
		for(RadnikDTO it : dtos){
			ret.add(convert(it));
		}
		
		return ret;
	}

}
