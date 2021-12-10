package com.vcabading.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcabading.dojosandninjas.models.Ninja;
import com.vcabading.dojosandninjas.repositories.NinjaRepository;

/////////////////////////////////////////////////////
//	NINJA SERVICE
/////////////////////////////////////////////////////

@Service
public class NinjaService {

	//	//// FIELDS /////////////////////////////////

	@Autowired
	NinjaRepository ninjaRepo;

	//	//// CREATE /////////////////////////////////

	//	---- Create a NInja -------------------------
	public Ninja create(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}

	//	//// RETRIEVE ///////////////////////////////

	//	---- Retrieve All ---------------------------
	public List<Ninja> retrieveAll() {
		return this.ninjaRepo.findAll();
	}

	//	---- Retrieve NInja by ID --------------------
	public Ninja retrieveNinja(Long id) {
		Optional<Ninja> optNinja = this.ninjaRepo.findById(id);
		if (optNinja.isPresent()) {
			return optNinja.get();
		} else {
			return null;
		}
	}

	//	//// UPDATE /////////////////////////////////

	public Ninja update(Ninja ninja) {
		Optional<Ninja> optNinja = this.ninjaRepo.findById(ninja.getId());
		if (optNinja.isPresent()) {
			return this.ninjaRepo.save(ninja);
		} else {
			return null;
		}
	}

//	//// DELETE /////////////////////////////////

	public void delete(Long id) {
		this.ninjaRepo.deleteById(id);
	}
}