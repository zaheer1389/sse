package com.ssengineering.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SaleDetail")
public class SaleDetail implements Serializable{

	@Id
    @Column(name="ID")
    @GeneratedValue
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="SaleId", referencedColumnName="id")
	private Sale sale;
	
	@ManyToOne
	@JoinColumn(name="PartId", referencedColumnName="id")
	private Part part;
	
	@ManyToOne
	@JoinColumn(name="SubPartId", referencedColumnName="id")
	private SubPart subPart;
	
	@Column(name="AmountPerUnit")
	private Double amountPerUnit;
	
	@Column(name="TotalUnit")
	private int totalUnit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public SubPart getSubPart() {
		return subPart;
	}

	public void setSubPart(SubPart subPart) {
		this.subPart = subPart;
	}

	public Double getAmountPerUnit() {
		return amountPerUnit;
	}

	public void setAmountPerUnit(Double amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
	}

	public int getTotalUnit() {
		return totalUnit;
	}

	public void setTotalUnit(int totalUnit) {
		this.totalUnit = totalUnit;
	}
	
	public String toString(){
		return "PurchaseDetail{TotalUnit:"+totalUnit
				+"AmountPerUnit+ : "+amountPerUnit
				+"}";
	}
}
