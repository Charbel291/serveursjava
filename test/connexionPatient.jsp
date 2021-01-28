<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion du patient</title>
  <style>
    
    body{
        background-color:rgb(241, 233, 241);
    }

    body, p, legend, label, input {
    	font: normal 8pt verdana, helvetica, sans-serif;
	}


	fieldset{
    	padding: 10px;
    	border: 1px #0568CD solid;
	}

	form label {
    	float: left;
    	width: 200px;
    	margin: 3px 0px 0px 0px;
    }
    
    legend{
        font-weight: bold;
        color: #0568CD;
    }

    form input{
        margin: 3px 3px 0px 0px;
        border: 1px rgb(83, 25, 25) solid;
    }

    form input.sansLabel{
        margin-left: 200px; 
    }

    form .requis{
        color: #c00;
    }
    </style>
</head>
<body>
    <form method="post" action="connexionPatient">
        <fieldset>
            <legend>Connexion</legend>
            <p>Connectez-vous via ce formulaire.</p>
            <label for="nom">Adresse email<span class="requis">*</span></label>
            <input type="email" id="email" name="email" value="<c:out value="${patient.email}"/>" size="20" maxlength="60" />
            <span class="="erreur">${form.erreurs['email']}</span>
            <br />
            <label for="motdepasse">Mot de passe<span class="requis">*</span></label>
            <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
            <span class="erreur">${form.erreurs['motdepasse']}</span>
            <br/>

            <input type="submit" value="Connexion" class="sansLabel" /><br/>
            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
        </fieldset>
    </form>
</body>
</html>