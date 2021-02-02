<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription du medecin</title>
<link type="text/css" rel="stylesheet" href="/WEB-INF/form.css" />
    <style>
    
    body{
        background-color:rgb(221, 203, 441);
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
    
    <form method="post" action="compteMedecin">
        <fieldset>
            <legend>Creation d'un compte du medecin</legend>
            
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" value="<c:out value="${medecin.nom}" />" size="20" maxlength="20" />
            <span class="erreur">${form.erreurs['nom']}</span><br />
            
            <label for="prenom">Prenom:</label>
            <input type="text" id="prenom" name="prenom" value="<c:out value="${medecin.prenom}" />" size="20" maxlength="100" />
            <span class="erreur">${form.erreurs['prenom']}</span><br />
            
            <label for="numeroTel">Tel:</label>
            <input type="tel" id="numeroTel" name="numeroTel" value="<c:out value="${medecin.numeroTel}" />" size="20" maxlength="100" />
            <span class="erreur">${form.erreurs['numeroTel']}</span><br />
            
            
            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" value="<c:out value="${medecin.adresse}" />" size="20" maxlength="100" />
            <span class="erreur">${form.erreurs['adresse']}</span><br />
            
            <label for="email">email: <span class="requis">*</span></label>
            
            <input type="email" id="email" name="email" value="<c:out value="${medecin.email}"/>" size="20" maxlength="60" />
            <span class="erreur">${form.erreurs['email']}</span><br />
			
			
			<label for="motdepasse">Mot de passe<span class="requis">*</span></label>
            <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
            <span class="erreur">${form.erreurs['motdepasse']}</span><br />
            <label for="confirmation">Confirmation du mot de passe<span class="requis">*</span></label>
            <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
            <span class="erreur">${form.erreurs['confirmation']}</span><br />
            
            <p class="info">${ form.resultat }</p>
            <input type="submit" value="Creer compte" class="sansLabel" />
            <!--<p class="${empty form.erreurs ? 'succes' : 'erreur' }">${form.resultat}</p>-->
            <input type="reset" value = "Remettre a zero " /><br />
        </fieldset>
    </form>
</body>
</html>