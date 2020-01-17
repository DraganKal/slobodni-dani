package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Godisnji;
import jwd.wafepa.web.dto.GodisnjiDTO;

@Component
public class GodisnjiToDTO implements Converter<Godisnji, GodisnjiDTO>{
	
	@Override
	public GodisnjiDTO convert(Godisnji godisnji) {
		GodisnjiDTO retValue = new GodisnjiDTO();
		retValue.setDatumKraja(godisnji.getDatumKraja());
		retValue.setDatumPocetka(godisnji.getDatumPocetka());
		retValue.setId(godisnji.getId());
		retValue.setRadnihDana(godisnji.getRadnihDana());
		retValue.setRadnikId(godisnji.getRadnik().getId());
		retValue.setRadnikNaziv(godisnji.getRadnik().getImeIPrezime());
		
		
		return retValue;
	}

	public List<GodisnjiDTO> convert(List<Godisnji> dtos){
		List<GodisnjiDTO> ret = new ArrayList<>();
		
		for(Godisnji it : dtos){
			ret.add(convert(it));
		}
		
		return ret;
	}

}
