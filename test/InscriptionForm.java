package fr.doctolib.forms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.doctolib.beans.Patient;

public final class InscriptionForm {  //Traitement des données envoyées par le patient

    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_PRENOM = "prenom";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_TEL = "numerotelephone";
    private static final String CHAMP_ADRESSE = "adresse";
    private static final String CHAMP_AGE = "age";
   private String resultat;
   private Map<String,String> erreurs = new HashMap<String,String>();

   public String getResultat(){
       return resultat;
   }

   public Map<String,String> getErreurs(){
       return erreurs;
   }
    
    public Patient inscrirePatient(HttpServletRequest request){

        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request,CHAMP_PASS);
        String confirmation = getValeurChamp(request, CHAMP_CONF);
        String nom = getValeurChamp(request, CHAMP_NOM);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String numeroTel = getValeurChamp(request, CHAMP_TEL);
        String adresse = getValeurChamp(request, CHAMP_ADRESSE);
        String age = getValeurChamp(request,CHAMP_AGE);
        
        Patient patient = new Patient();
        
        try {
        	validationPrenom(prenom);
        }catch(Exception e) {
        	setErreur(CHAMP_PRENOM,e.getMessage());
        }
        
        try {
        	validationNumeroTelphone(numeroTel);
        }catch(Exception e) {
        	setErreur(CHAMP_TEL,e.getMessage());
        }
        
        try {
        	validationAdresse(adresse);
        }catch(Exception e) {
        	setErreur(CHAMP_ADRESSE, e.getMessage());
        }

        try{
            validationEmail(email);
        }catch (Exception e){
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        patient.setEmail(email);

        try{
            validationMotsDePasse(motDePasse,confirmation);
        }catch(Exception e){
            setErreur(CHAMP_PASS, e.getMessage());
            setErreur(CHAMP_CONF, null);
        }
        patient.setMotDePasse(motDePasse);

        try{
            validationNom(nom);

        }catch(Exception e){
            setErreur(CHAMP_NOM,e.getMessage());
        }
        patient.setNom(nom);

        if(erreurs.isEmpty()){
            resultat = "Succès de l'inscription.";
        }else{
            resultat = "Echec de l'inscription.";
        }

        return patient;
    }

    private void validationAdresse(String adresse) throws Exception{
		// TODO Auto-generated method stub
    	if(adresse != null && adresse.length() < 9){
            throw new Exception("L'adresse doit contenir au moins 9 caract�res !");
        }
		
	}

	private void validationNumeroTelphone(String numeroTel) throws Exception {
		// TODO Auto-generated method stub
		if(numeroTel != null && numeroTel.length() < 10){
            throw new Exception("Le num�ro de t�l�phone doit contenir au moins 10 caract�res !");
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
                throw new Exception("Les mots de passe entrés sont différents, merci de resaisir.");
            }else if(motDePasse.length() < 3){
                throw new Exception("Votre mot de passe doit contenir au moins 3 caractères.");
            }

        }else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    private void validationNom(String nom) throws Exception{
        if(nom != null && nom.length() <= 1){
            throw new Exception("Le nom du patient doit contenir au moins 2 caractères !");
        }
    }

    private void setErreur(String champ, String message){
        erreurs.put(champ,message);
    }

    
        //Méthode utilitaire qui retourne null si un champ est vide, et son contenu sinon.

    private static String getValeurChamp(HttpServletRequest request, String nomChamp){
        String valeur = request.getParameter(nomChamp);
        if(valeur == null || valeur.trim().length() == 0){
            return null;
        }else{
            return valeur.trim();
        }
    }
    
}
