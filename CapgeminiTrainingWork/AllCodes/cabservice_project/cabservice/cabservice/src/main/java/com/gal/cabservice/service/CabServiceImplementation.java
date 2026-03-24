package com.gal.cabservice.service;

import java.util.*;

import org.springframework.stereotype.Component;
import com.gal.cabservice.entity.Cab;
import com.gal.cabservice.repo.CabRepo;

@Component
public class CabServiceImplementation {
	CabRepo cbr ;

	public CabServiceImplementation(CabRepo cbr) {
		this.cbr = cbr;
	}
	
	public void addCab(Cab c) {
		cbr.save(c);
	}
	public void deleteCab(Long id) {
		cbr.deleteById(id);
	}
	public List<Cab> getAllCabs()
	{
		return cbr.findAll();
		
	}
	public Optional<Cab> getById(Long id) {
		return cbr.findById(id);
	}

}
