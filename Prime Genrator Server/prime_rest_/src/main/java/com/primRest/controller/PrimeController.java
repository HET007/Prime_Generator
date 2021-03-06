package com.primRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.primRest.entities.PrimeSet;
import com.primRest.entities.primeData;
import com.primRest.service.PrimeService;

@RestController
public class PrimeController {
	// get the courses

	@Autowired
	private PrimeService pService;

	@CrossOrigin
	@PostMapping("prime")
	public PrimeSet getPrime(@RequestBody primeData pData) {
		return pService.addData(pData);
	}
}
