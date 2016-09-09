package com.ssengineering.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="SubPart")
public class SubPart implements Serializable{
	
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Long id;
	
	@ManyToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="PartId", referencedColumnName="id")
	private Part part;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return "{'id':"+id
				+ ",'part':"+part.getName()
				+",'name':"+name
				+",'description':"+description
				+"}";
	}

}
