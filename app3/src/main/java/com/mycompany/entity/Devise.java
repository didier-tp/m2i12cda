package com.mycompany.entity;

public class Devise {
	private String code; //EUR ou USD ou JPY ou GBP
	private String nom; //euro ou dollar ou yen ou livre
	private Double dChange; //nb ... pour 1 dollar
		
	public Devise() {
		super();
	}

	public Devise(String code, String nom, Double dChange) {
		super();
		this.code = code;
		this.nom = nom;
		this.dChange = dChange;
	}
	
	@Override
	public String toString() {
		return "Devise [code=" + code + ", nom=" + nom + ", dChange=" + dChange + "]";
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getdChange() {
		return dChange;
	}
	public void setdChange(Double dChange) {
		this.dChange = dChange;
	}
	
	
}
