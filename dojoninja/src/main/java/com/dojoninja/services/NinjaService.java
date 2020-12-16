package com.dojoninja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojoninja.models.Ninja;
import com.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	//Dependency Injection
	private NinjaRepository ninjaRepo;
	
	//constructor
	public NinjaService(NinjaRepository repo) {
		this.ninjaRepo = repo;
	}
	
	//CRUD Methods
	//Get All ninjas
	public List<Ninja> getAllNinjas(){
		return this.ninjaRepo.findAll();
	}
	
	//Get one ninja
	public Ninja getSingleNinja(Long id) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	//Create a ninja
	public Ninja createNinja(Ninja newNinja) {
		return this.ninjaRepo.save(newNinja);
	}

	
	//Delete a ninja
	public void deleteNinja(Long id) {
		this.ninjaRepo.deleteById(id);
	}
}
