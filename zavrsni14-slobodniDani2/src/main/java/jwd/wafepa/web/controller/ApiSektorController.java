package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Sektor;
import jwd.wafepa.service.SektorService;
import jwd.wafepa.support.SektorToDTO;
import jwd.wafepa.web.dto.SektorDTO;


@RestController
@RequestMapping(value="/api/sektori")
public class ApiSektorController {
	
	@Autowired
	private SektorService sektorService;
	@Autowired
	private SektorToDTO toDto;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<SektorDTO>> getSektori(){
		
		List<Sektor> sektori = sektorService.findAll();
		
		return new ResponseEntity<>(
				toDto.convert(sektori), 
				HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
