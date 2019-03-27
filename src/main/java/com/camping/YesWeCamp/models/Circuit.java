package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "circuit")
public class Circuit {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String type;
	/* liaison image */
	public Circuit() {
		super();
	}
	public Circuit(Long id, String description, String type) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	
	

}
