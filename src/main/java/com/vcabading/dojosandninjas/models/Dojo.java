package com.vcabading.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//////////////////////////////////////////////////////////////
//	DOJO CLASS
//////////////////////////////////////////////////////////////

@Entity
@Table(name="dojos")
public class Dojo {

	//	//// FIELDS //////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=1, max=255, message="Name must be at least one character in length")
	private String name;
	
	@Column(updatable=false)		// this will not allow createdAt to be updated after creation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjasList;
	
	@PrePersist
	protected void onCreate()	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//	//// CONSTRUCTORS ////////////////////////////////////

	public Dojo() {
	}


	//	//// GETTERS AND SETTERS /////////////////////////////
	
}