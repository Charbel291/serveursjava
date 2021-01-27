<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
<c:set var="pseudo" value="john" scope="page" />
<p><c:out value="${ variable }" default="Valeur par defaut"/></p>
<p><c:out value="${ pseudo }" default="Valeur par defaut"/></p>
<c:set var="pseudo" value="robert" scope="page" />
<p><c:out value="${ pseudo }" default="Valeur par defaut"/></p>
<ul>
	<c:forEach var="utlisateur" items="${ utilisateurs }">
		<li><c:out value="${ utilisateur.nom }" /> <c:out value="${ utilisateur.prenom }" /></li>
	</c:forEach>
</ul>
</body>
</html>