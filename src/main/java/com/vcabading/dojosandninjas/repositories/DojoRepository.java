package com.vcabading.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcabading.dojosandninjas.models.Dojo;

////////////////////////////////////////////////////////////////
//	DOJO REPOSITORY
////////////////////////////////////////////////////////////////

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

	//	---- Retrieves all books -------------------------------
	List<Dojo> findAll();
}