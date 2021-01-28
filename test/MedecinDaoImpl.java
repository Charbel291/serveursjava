package fr.doctolib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doctolib.beans.Medecin;


public class MedecinDaoImpl implements MedecinDAO{
	
	private DaoFactory daoFactory;

	MedecinDaoImpl(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

	@Override
	public void ajouter(Medecin medecin) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom,prenom) VALUES(?,?);");
            preparedStatement.setString(1, medecin.getId());
            preparedStatement.setString(2, medecin.getNom());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Medecin> lister() {
		// TODO Auto-generated method stub
		  List<Medecin> medecins = new ArrayList<Medecin>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try{
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT id, nom FROM medecins;");

	            while(resultat.next()){
	                String nom = resultat.getString("id");
	                String prenom = resultat.getString("nom");

	                Medecin medecin = new Medecin();
	                medecin.setId(nom);
	                medecin.setNom(prenom);

	                medecins.add(medecin);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
			return medecins;
	}

}
