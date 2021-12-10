package com.vcabading.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//////////////////////////////////////////////////////////////
//	NINJA CLASS
//////////////////////////////////////////////////////////////

@Entity
@Table(name="ninjas")
public class Ninja {

	//	//// FIELDS //////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=1, max=255, message="First Name must be at least one character in length")
	private String firstName;
	
	@NotNull
	@Size(min=1, max=255, message="Last Name must be at least one character in length")
	private String lastName;
	
	@Column(updatable=false)		// this will not allow createdAt to be updated after creation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate()	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//	//// CONSTRUCTORS ////////////////////////////////////

	public Ninja() {
	}


	//	//// GETTERS AND SETTERS /////////////////////////////
	
}