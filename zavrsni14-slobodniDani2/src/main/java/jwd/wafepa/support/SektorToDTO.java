package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Sektor;
import jwd.wafepa.web.dto.SektorDTO;

@Component
public class SektorToDTO implements Converter<Sektor, SektorDTO>{
	
	@Override
	public SektorDTO convert(Sektor sektor) {
		
		SektorDTO retValue = new SektorDTO();
		
		retValue.setBonusDana(sektor.getBonusDana());
		retValue.setId(sektor.getId());
		retValue.setNaziv(sektor.getNaziv());
		
		return retValue;
	}

	public List<SektorDTO> convert(List<Sektor> dtos){
		List<SektorDTO> ret = new ArrayList<>();
		
		for(Sektor it : dtos){
			ret.add(convert(it));
		}
		
		return ret;
	}

}
