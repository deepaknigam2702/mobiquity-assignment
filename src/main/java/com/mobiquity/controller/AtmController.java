package com.mobiquity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquity.model.Atm;
import com.mobiquity.service.IAtmServices;

@RestController
public class AtmController {

	@Autowired
	private IAtmServices atmServices;

	@GetMapping("/atms")
	public ResponseEntity<List<Atm>> findAtms() {
	    return new ResponseEntity<>(atmServices.findAll(), HttpStatus.OK);
	}

	@GetMapping("/atms/{city}")
	public ResponseEntity<List<Atm>> findAtmsByCity(@PathVariable(name = "city") String city) {
	    return new ResponseEntity<>(atmServices.findAtmsByCity(city), HttpStatus.OK);
	}
}