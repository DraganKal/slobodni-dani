package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Radnik;
import jwd.wafepa.web.dto.RadnikDTO;

@Component
public class RadnikToDTO implements Converter<Radnik, RadnikDTO>{
	
	@Override
	public RadnikDTO convert(Radnik radnik) {
		
		RadnikDTO retValue = new RadnikDTO();
		
		retValue.setEmail(radnik.getEmail());
		retValue.setGodineStaza(radnik.getGodineStaza());
		retValue.setId(radnik.getId());
		retValue.setIdBroj(radnik.getIdBroj());
		retValue.setImeIPrezime(radnik.getImeIPrezime());
		retValue.setSektorId(radnik.getSektor().getId());
		retValue.setSektorNaziv(radnik.getSektor().getNaziv());
		retValue.setSlobodniDani(radnik.getSlobodniDani());
		
		return retValue;
	}

	public List<RadnikDTO> convert(List<Radnik> list){
		List<RadnikDTO> ret = new ArrayList<>();
		
		for(Radnik it : list){
			ret.add(convert(it));
		}
		
		return ret;
	}

}
