package com.dojoninja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojoninja.models.Dojo;
import com.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
	//Dependency Injection
	private DojoRepository dojoRepo;
	
	//constructor
	public DojoService(DojoRepository repo) {
		this.dojoRepo = repo;
	}
	
	//CRUD Methods
	//Get All dojos
	public List<Dojo> getAllDojos(){
		return this.dojoRepo.findAll();
	}
	
	//Get one dojo
	public Dojo getSingleDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}

	//Create a dojo
	public Dojo createDojo(Dojo newDojo) {

		return this.dojoRepo.save(newDojo);
	}
	
	//Delete a dojo
	public void deleteDojo(Long id) {
		this.dojoRepo.deleteById(id);
	}
	


}
