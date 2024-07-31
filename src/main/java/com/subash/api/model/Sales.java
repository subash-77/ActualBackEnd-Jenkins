package com.subash.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saleId;
	@Column(name = "saleDate")
	private String saleDate;
	@Column(name = "quantitySold")
	private int quantitySold;

	@OneToMany(targetEntity = Jewellery.class, cascade = CascadeType.ALL)
	@JoinColumn()
	private List<Jewellery> jewellery = new ArrayList<>();

	public Sales() {
		super();
	}

	public Sales(int saleId, String saleDate, int quantitySold, List<Jewellery> jewellery) {
		super();
		this.saleId = saleId;
		this.saleDate = saleDate;
		this.quantitySold = quantitySold;
		this.jewellery = jewellery;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public List<Jewellery> getJewellery() {
		return jewellery;
	}

	public void setJewellery(List<Jewellery> jewellery) {
		this.jewellery = jewellery;
	}

	@Override
	public String toString() {
		return "Sales [saleId=" + saleId + ", saleDate=" + saleDate + ", quantitySold=" + quantitySold + ", jewellery="
				+ jewellery + "]";
	}

}
