<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.trio.proxibanquev2.domaine.Conseiller"%>
<%@ page import="com.trio.proxibanquev2.domaine.Client"%>
<%@ page import="com.trio.proxibanquev2.presentation.Utilejsp"%>
<%@ page import="com.trio.proxibanquev2.domaine.Adresse"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer un client</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="editerclient.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <!--[endif]---->
    <script type="text/javascript">
	function afficherPersonne(data) {
DWRUtil.setValue("nom",user.getListClient.getnom());
DWRUtil.setValue("prenom",user.getListClient.getprenom());
DWRUtil.setValue("mail",user.getListClient.getmail());
	}
</script>
</head>
<body>

	<%
		Conseiller user = (Conseiller) session.getAttribute("User");
	int numeroclient= (int) session.getAttribute("numClientObserve"); 
	%>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="creerclient.jsp">Créer un client</a></li>                      
                      <li><a href="menu.jsp">Menu principal</a></li>                      
                     
				</ul>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<ul style="" class="dropdown-menu" role="menu" aria-labelledby="userid"></ul>
	<ul style="" class="dropdown-menu" role="menu" aria-labelledby="userid"></ul>
	
	


	<center>
		<form role="form" Action="EditionClient" method="post">
			<div class="input-group">
				<label for="nom">Nom</label> <input value=<%=user.getListClient().get(numeroclient).getNom()%>
					class="form-control" name=nom 
					placeholder="Nom" type="texte">
					
			</div>
			<div class="input-group">
				<label for="prenom">Prénom</label> <input value=<%=user.getListClient().get(numeroclient).getPrenom()%>
					class="form-control" name=prenom id="prenom"
					placeholder="Prénom" type="texte">
			</div>
			<div class="input-group">
				<label for="mail">Email</label> <input value=<%=user.getListClient().get(numeroclient).getMail()%>
					class="form-control" name=mail id="mail"
					placeholder="Email" type="texte">
			</div>
			<div class="input-group">
				<label for="numRue">numero de rue</label> <input value=<%=user.getListClient().get(numeroclient).getAdresse().getNumRue()%>
					class="form-control" name=numRue id="numRue"
					placeholder="Adresse" type="texte">
			</div>
			<div class="input-group">
				<label for="typeDeRue">type de rue</label> <input value=<%=user.getListClient().get(numeroclient).getAdresse().getTypeDeRue()%>
					class="form-control" name=typeDeRue id="typeDeRue"
					placeholder="Adresse" type="texte">
			</div>
			<div class="input-group">
				<label for="nomDeRue">nom de rue</label> <input value=<%=user.getListClient().get(numeroclient).getAdresse().getNomDeRue()%>
					class="form-control" name=nomDeRue id="nomDeRue"
					placeholder="Adresse" type="texte">
			</div>
			<div class="input-group">
				<label for="codePostal">code postal</label> <input value=<%=user.getListClient().get(numeroclient).getAdresse().getCodePostal()%>
					class="form-control" name=codePostal id="codePostal"
					placeholder="Adresse" type="text">
			</div>
			<div class="input-group">
				<label for="ville">ville</label> <input value=<%=user.getListClient().get(numeroclient).getAdresse().getVille()%>
					class="form-control" name=ville id="ville"
					placeholder="Adresse" type="texte">
			</div>

			<button type="submit" class="btn btn-default">Modifier</button>
		</form>
	</center>

</body>
</html>