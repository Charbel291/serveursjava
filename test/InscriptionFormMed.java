package fr.doctolib.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.doctolib.beans.Medecin;


public class InscriptionFormMed {
	
	 private static final String CHAMP_EMAIL = "email";
	 private static final String CHAMP_PASS = "motdepasse";
	 private static final String CHAMP_CONF = "confirmation";
	 private static final String CHAMP_PRENOM = "prenom";
	 private static final String CHAMP_NOM = "nom";
	 private static final String CHAMP_TEL = "numerotelephone";
	 private static final String CHAMP_ADRESSE = "adresse";
	
	 
	 private String resultat;
	
	 private Map<String,String> erreurs = new HashMap<String,String>();

	   public String getResultat(){
	       return resultat;
	   }

	   public Map<String,String> getErreurs(){
	       return erreurs;
	   }
	    
	    public Medecin inscrireMedecin(HttpServletRequest request){

	        String email = getValeurChamp(request, CHAMP_EMAIL);
	        String motDePasse = getValeurChamp(request,CHAMP_PASS);
	        String confirmation = getValeurChamp(request, CHAMP_CONF);
	        String nom = getValeurChamp(request, CHAMP_NOM);
	        String prenom = getValeurChamp(request, CHAMP_PRENOM);
	        String numeroTel = getValeurChamp(request, CHAMP_TEL);
	        String adresse = getValeurChamp(request, CHAMP_ADRESSE);
	      
	        
	        Medecin medecin = new Medecin();
	        
	      
	        
	        try {
	        	validationPrenom(prenom);
	        }catch(Exception e) {
	        	setErreur(CHAMP_PRENOM,e.getMessage());
	        }
	        
	        medecin.setPrenom(prenom);
	        try {
	        	validationNumeroTelphone(numeroTel);
	        }catch(Exception e) {
	        	setErreur(CHAMP_TEL,e.getMessage());
	        }
	        
	        medecin.setNumeroTel(numeroTel);
	        
	        try {
	        	validationAdresse(adresse);
	        }catch(Exception e) {
	        	setErreur(CHAMP_ADRESSE, e.getMessage());
	        }
	        
	        medecin.setAdresse(adresse);

	        try{
	            validationEmail(email);
	        }catch (Exception e){
	            setErreur(CHAMP_EMAIL, e.getMessage());
	        }
	        medecin.setEmail(email);

	        try{
	            validationMotsDePasse(motDePasse,confirmation);
	        }catch(Exception e){
	            setErreur(CHAMP_PASS, e.getMessage());
	            setErreur(CHAMP_CONF, null);
	        }
	        medecin.setMotDePasse(motDePasse);

	        try{
	            validationNom(nom);

	        }catch(Exception e){
	            setErreur(CHAMP_NOM,e.getMessage());
	        }
	        medecin.setNom(nom);

	        if(erreurs.isEmpty()){
	            resultat = "Succes de l'inscription.";
	        }else{
	            resultat = "Echec de l'inscription.";
	        }

	        return medecin;
	    }

	  

		private void validationAdresse(String adresse) throws Exception{
			// TODO Auto-generated method stub
	    	if(adresse != null && adresse.length() < 9){
	            throw new Exception("L'adresse doit contenir au moins 9 caracteres !");
	        }
			
		}

		private void validationNumeroTelphone(String numeroTel) throws Exception {
			// TODO Auto-generated method stub
			if(numeroTel != null){
	            if(!numeroTel.matches("^\\d+$")){
	                throw new Exception("Le numero de telephone doit uniquement contenir des chiffres!");
	            }else if(numeroTel.length() <10){
	                throw new Exception ("Le numero de telephone doit contenir au moins 10 chiffres.");
	            }else{
	                throw new Exception ("Numero de telephone valide !!");
	            }
	            
	        }
		}

		private void validationPrenom(String prenom) throws Exception {
			// TODO Auto-generated method stub
			if(prenom != null && prenom.length() <= 1){
	            throw new Exception("Le prenom du patient doit contenir au moins 2 caractères !");
	        }
		}

		private void validationEmail(String email) throws Exception{
	        if(email != null){
	            if(!email.matches(
	                "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )){
	                    throw new Exception ("Votre adresse mail est invalide !");
	                }else{
	                    throw new Exception ("Mail est valide !");
	                }
	                
	        }
	    }

	    public void validationMotsDePasse(String motDePasse, String confirmation) throws Exception{
	        if(motDePasse != null && confirmation != null){
	            if(!motDePasse.equals(confirmation)){
	                throw new Exception("Les mots de passe entres sont differents, merci de resaisir.");
	            }else if(motDePasse.length() < 3){
	                throw new Exception("Votre mot de passe doit contenir au moins 3 caracteres.");
	            }

	        }else {
	            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
	        }
	    }

	    private void validationNom(String nom) throws Exception{
	        if(nom != null && nom.length() <= 1){
	            throw new Exception("Le nom du patient doit contenir au moins 2 caracteres !");
	        }
	    }

	    private void setErreur(String champ, String message){
	        erreurs.put(champ,message);
	    }

	    
	        //Methode utilitaire qui retourne null si un champ est vide, et son contenu sinon.

	    private static String getValeurChamp(HttpServletRequest request, String nomChamp){
	        String valeur = request.getParameter(nomChamp);
	        if(valeur == null || valeur.trim().length() == 0){
	            return null;
	        }else{
	            return valeur;
	        }
	    }

}
