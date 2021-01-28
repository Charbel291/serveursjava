package fr.doctolib.beans;

public class Medecin implements Cloneable{
	
	private String nom;
	private String id;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Medecin cloneMoi() {
		try {
			return (Medecin)super.clone();
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	public String toString() {
		return "Medecin [id=" +id+ ", nom=" +nom +"]";
	}

}
