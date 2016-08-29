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
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="creerclient.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <!--[endif]---->
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container-fluid">
              <div class="navbar-header"><button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button></div>
              <div class="navbar-collapse collapse">
                  <ul class="nav navbar-nav navbar-right">
                     <li><a href="creerclient.jsp">Créer un client</a></li>
                     <li><a href="editerclient.jsp">Editer un client</a></li>
                     <li><a href="consultercompte.jsp">Consulter les comptes d'un client</a></li>
                     <li><a href="virement.jsp">Effectuer un virement</a></li>
                     <li><a href="connexion.jsp">Déconnexion</a></li>
                  </ul>
              </div>
          </div>
      </div>
<center>
 <form role="form">
          <div class="input-group">
              <label for="exampleInputEmail1">Nom</label>
              <input class="form-control" id="exampleInputEmail1" placeholder="Nom" type="texte">
          </div>
          <div class="input-group">
              <label for="exampleInputPassword1">Prénom</label>
              <input class="form-control" id="exampleInputPassword1" placeholder="Prénom" type="texte">
          </div>
          <div class="input-group">
              <label for="exampleInputPassword1">Email</label>
              <input class="form-control" id="exampleInputPassword1" placeholder="Email" type="texte">
          </div>
          <div class="input-group">
              <label for="exampleInputPassword1">Adresse</label>
              <input class="form-control" id="exampleInputPassword1" placeholder="Adresse" type="adresse">
          </div>
         
          <button type="submit" class="btn btn-default">Créer</button>
      </form>
      </center>
</body>
</html>