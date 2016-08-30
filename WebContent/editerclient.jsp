<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
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
					<li><a href="editerclient.jsp">Editer un client</a></li>
					<li><a href="consultercompte.jsp">Consulter les comptes
							d'un client</a></li>
					<li><a href="virement.jsp">Effectuer un virement</a></li>
					<li><a href="connexion.jsp">Déconnexion</a></li>
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
	<li role="presentation" class="dropdown-header">
		<ul class="nav nav-pills">
			<li class="dropdown"><a
				class="dropdown-toggle btn-lg navbar-brand" data-toggle="dropdown"
				href="#">Choix du client <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">Client 1</a></li>
					<li><a href="#">Client 2</a></li>
					<li><a href="#">Client 3</a></li>
					<li><a href="#">Client 4</a></li>
					<li><a href="#">Client 5</a></li>
					<li><a href="#">Client 6</a></li>
					<li><a href="#">Client 7</a></li>
					<li><a href="#">Client 8</a></li>
					<li><a href="#">Client 9</a></li>
					<li><a href="#">Client 10</a></li>
				</ul></li>
		</ul>
	</li>
	<center>
		<form role="form" Action="EditionClient" method="post">
			<div class="input-group">
				<label for="exampleInputEmail1">Nom</label> <input
					class="form-control" name=nom id="exampleInputEmail1"
					placeholder="Nom" type="texte">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">Prénom</label> <input
					class="form-control" name=prenom id="exampleInputPassword1"
					placeholder="Prénom" type="texte">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">Email</label> <input
					class="form-control" name=mail id="exampleInputPassword1"
					placeholder="Email" type="texte">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">numero de rue</label> <input
					class="form-control" name=numRue id="exampleInputPassword1"
					placeholder="Adresse" type="texte">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">type de rue</label> <input
					class="form-control" name=typeDeRue id="exampleInputPassword1"
					placeholder="Adresse" type="texte">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">nom de rue</label> <input
					class="form-control" name=nomDeRue id="exampleInputPassword1"
					placeholder="Adresse" type="texte">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">code postal</label> <input
					class="form-control" name=codePostal id="exampleInputPassword1"
					placeholder="Adresse" type="text">
			</div>
			<div class="input-group">
				<label for="exampleInputPassword1">ville</label> <input
					class="form-control" name=ville id="exampleInputPassword1"
					placeholder="Adresse" type="texte">
			</div>

			<button type="submit" class="btn btn-default">Modifier</button>
		</form>
	</center>
</body>
</html>