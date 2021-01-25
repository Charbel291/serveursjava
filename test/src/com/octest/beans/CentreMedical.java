package com.octest.beans;

import java.util.ArrayList;

public class CentreMedical {
	private String nom;
	private ArrayList<Medecin> liste_medecins;
	
	public CentreMedical(String nom, ArrayList<Medecin> liste_medecins) {
		this.nom=nom;
		this.liste_medecins=new ArrayList<Medecin>();
	}
	
	public void ajouterMedecin(Medecin medecin) {
		liste_medecins.add(medecin);
	}
	
	public void retirerMedecin(Medecin medecin) {
		liste_medecins.remove(medecin);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Medecin> getListe_medecins() {
		return liste_medecins;
	}
	
	public void setListe_medecins(ArrayList<Medecin> liste_medecins) {
		this.liste_medecins = liste_medecins;
	}
	
}
