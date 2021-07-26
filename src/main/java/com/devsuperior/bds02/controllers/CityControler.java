package com.devsuperior.bds02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityControler {
	
	@Autowired
	private CityService cityService;
	
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> findAll() {
		List<CityDTO> list = cityService.findAll();		
		return ResponseEntity.ok().body(list);
	}	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		cityService.delete(id);
		return ResponseEntity.noContent().build();		
	}
	
}
