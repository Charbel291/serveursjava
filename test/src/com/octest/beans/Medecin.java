package com.octest.beans;

public class Medecin {
	private String id;
	private String nom;
	private String prenom;
	private String specialite;
	private CentreMedical centre_medical;
	
	public Medecin(String nom, String prenom, String specialite) {
		this.nom=nom;
		this.prenom=prenom;
		this.specialite=specialite;
		this.id=nom.substring(0,2)+prenom.substring(0,2)+specialite.substring(0,2);
	}
	
	public String getSpecialite() {
		return specialite;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public CentreMedical getCentre_medical() {
		return centre_medical;
	}
	public void setCentre_medical(CentreMedical centre_medical) {
		this.centre_medical = centre_medical;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Medecin) {
			Medecin medecin = (Medecin) obj;
			String id = medecin.getId();
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
		return "Dr "+prenom+" "+nom+" ,"+specialite;
	}
	
}
