package fr.doctolib.dao;

import java.util.List;

import fr.doctolib.beans.Medecin;


	public interface MedecinDAO {
	    void ajouter(Medecin medecin);
	    List<Medecin>lister();

	}


