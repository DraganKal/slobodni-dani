package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Godisnji;
import jwd.wafepa.model.Radnik;
import jwd.wafepa.service.RadnikService;
import jwd.wafepa.support.DTOtoRadnik;
import jwd.wafepa.support.GodisnjiToDTO;
import jwd.wafepa.support.RadnikToDTO;
import jwd.wafepa.web.dto.GodisnjiDTO;
import jwd.wafepa.web.dto.RadnikDTO;

@RestController
@RequestMapping(value="/api/radnici")
public class ApiRadnikController {

	@Autowired
	private RadnikService radnikService;
	@Autowired
	private RadnikToDTO toDto;
	@Autowired 
	private DTOtoRadnik toRadnik;
	@Autowired
	private GodisnjiToDTO godToDTO;
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<RadnikDTO>> getRadnici(
			@RequestParam(required=false) String idBroj,
			@RequestParam(required=false) String imeIPrezime,
			@RequestParam(required=false) Long sektorId,
			@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		Page<Radnik> radniciPage = null;
		if(idBroj != null || imeIPrezime != null || sektorId != null) {
			radniciPage = radnikService.search(idBroj, imeIPrezime, sektorId, pageNum);
		}
		else {
			radniciPage = radnikService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(radniciPage.getTotalPages()) );
		
		return new ResponseEntity<>(
				toDto.convert(radniciPage.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<RadnikDTO> getRadnik(@PathVariable Long id){
		Radnik radnik = radnikService.findOne(id);
		if(radnik==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(radnik),
				HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes="application/json")
	public ResponseEntity<RadnikDTO> add(
		@Validated @RequestBody RadnikDTO newRadnikDTO){
	
	Radnik saved = radnikService.save(
			toRadnik.convert(newRadnikDTO));
	
	return new ResponseEntity<>(
			toDto.convert(saved), 
			HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<RadnikDTO> edit(
			@Validated @RequestBody RadnikDTO radnikDTO,
			@PathVariable Long id){
		
		if(!id.equals(radnikDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Radnik persisted = radnikService.put(
				toRadnik.convert(radnikDTO));
		
		return new ResponseEntity<>(
				toDto.convert(persisted),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<RadnikDTO> delete(@PathVariable Long id){
		Radnik deleted = radnikService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(deleted),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/godisnji/{id}",method=RequestMethod.POST,
			consumes="application/json")
	public ResponseEntity<GodisnjiDTO> godisnji(@PathVariable Long id,
				 @RequestBody Godisnji god){
	
	Godisnji godisnji = radnikService.godisnji(id, god);
	
	return new ResponseEntity<>(
			godToDTO.convert(godisnji), 
			HttpStatus.CREATED);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
