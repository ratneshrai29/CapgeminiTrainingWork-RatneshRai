package com.gal.cabservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.cabservice.entity.Cab;
import com.gal.cabservice.service.CabServiceImplementation;

@RestController
@RequestMapping("/cabservice")
public class CabController {
	CabServiceImplementation csi ;
	
	public CabController(CabServiceImplementation csi) {
		this.csi = csi;
	}
	@PostMapping
	public void addCab(@RequestBody Cab c) {
		csi.addCab(c);
	}
	@GetMapping
	public List<Cab> getAllCabs(){
		return csi.getAllCabs();
	}
	@GetMapping("/{id}")
	public Optional<Cab> getCabById1(@PathVariable Long id) {
		return csi.getById(id);
	}
	
	
//	@GetMapping
//	public Optional<Cab> getCabById2(@RequestBody Long id){
//		return csi.getById(id);
//	}
//	
}
