package com.vcabading.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcabading.dojosandninjas.models.Ninja;

////////////////////////////////////////////////////////////////
//	NINJA REPOSITORY
////////////////////////////////////////////////////////////////

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	//	---- Retrieves all books -------------------------------
	List<Ninja> findAll();
}