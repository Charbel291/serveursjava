package com.octest.beans;

import java.time.LocalDate;

public class Patient {
	private String id;
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private Gender sexe;
	private LocalDate date_naissance;

	public Patient(String nom, String prenom,int age,Gender sexe) {
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.sexe=sexe;
		this.id=nom.substring(0,2)+prenom.substring(0,2)+age;
	}
	
	public enum Gender { M, F }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getSexe() {
		return sexe;
	}

	public void setSexe(Gender sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Patient) {
			Patient patient = (Patient) obj;
			String id = patient.getId();
			if(this.id.equals(id)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "id = "+id+" "+prenom+" "+nom+", "+age;
	}
	
}
