package fr.doctolib.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.doctolib.beans.Patient;

public final class ConnexionForm {

    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";

    private String resultat;
    private Map<String,String>erreurs = new HashMap<String,String>();

    public String getResultat(){
        return resultat;
    }

    public Map<String,String>getErreurs(){
        return erreurs;
    }

    public Patient connecterPatient(HttpServletRequest request){
        // Récuperation des champs du formulaire
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);

        Patient patient = new Patient();

        // Validation du champ email
        try{
            validationEmail(email);
        }catch(Exception e){
            setErreur(CHAMP_EMAIL, e.getMessage());
        }

        patient.setEmail(email);

        //Validation du champ mot de passe.
        try{
        	validationMotsDePasse(motDePasse);
        }catch(Exception e){
            setErreur(CHAMP_PASS, e.getMessage());
        }

        patient.setMotDePasse(motDePasse);

        // Initialisation du résultat global de la validation

        if(erreurs.isEmpty()){
            resultat = "Succes de la connexion.";
        }else{
            resultat = "Echec de la connexion.";
           
        }
        return patient;
    } 

        //Valide l'adresse email saisie

        private void validationEmail(String email) throws Exception{
            if ( email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    //Valide le mot de passe saisi
    private void validationMotsDePasse(String motDePasse)throws Exception{
        if(motDePasse != null){
            if(motDePasse.length() < 3){
                throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
            }
        }else{
            throw new Exception ("Merci de saisir votre mot de passe.");
        }
    }

    private void setErreur(String champ, String message){
        erreurs.put(champ,message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp){
        String valeur = request.getParameter(nomChamp);
        if(valeur == null || valeur.trim().length() == 0){
            return null;
        }else{
            return valeur;
        }
    }

}
