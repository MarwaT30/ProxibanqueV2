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
    <link href="virement.css" rel="stylesheet">
    <link href="style-auto.css" rel="stylesheet">

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
      </div><!-- Bootstrap core JavaScript
    ================================================== --><!-- Placed at the end of the document so the pages load faster --><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
      <ul style="" class="dropdown-menu" role="menu" aria-labelledby="userid"></ul>
      <ul style="" class="dropdown-menu" role="menu" aria-labelledby="userid"></ul>
      <li role="presentation" class="dropdown-header">
          <ul class="nav nav-pills text-left">
              <li class="dropdown">
                  <a class="dropdown-toggle btn-lg navbar-link" data-toggle="dropdown" href="#">Choix du client débiteur <span class="caret"></span></a>
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
                  </ul>
              </li>
          </ul>
      </li>
      <li role="presentation" class="dropdown-header">
          <ul class="nav nav-pills">
              <li class="dropdown">
                  <a class="dropdown-toggle btn-lg navbar-link" data-toggle="dropdown" href="#">Choix du compte débiteur <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li><a href="#">Compte Courant</a></li>
                      <li><a href="#">Compte Epargne</a></li>
                      
                  </ul>
              </li>
          </ul>
      </li>
      <li role="presentation" class="dropdown-header">
          <ul class="nav nav-pills">
              <li class="dropdown">
                  <a class="dropdown-toggle btn-lg navbar-link" data-toggle="dropdown" href="#">Choix du client créditeur <span class="caret"></span></a>
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
                  </ul>
              </li>
          </ul>
      </li>
      <li role="presentation" class="dropdown-header">
          <ul class="nav nav-pills">
              <li class="dropdown">
                  <a class="dropdown-toggle btn-lg navbar-right navbar-link" data-toggle="dropdown" href="#">Choix du compte créditeur <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li><a href="#">Compte Client</a></li>
                      <li><a href="#">Compte Epargne</a></li>
                      
                  </ul>
              </li>
          </ul>
      </li>
      
      <form role="form">
          <div class="input-group">          
              <label for="exampleInputEmail1">Solde du compte débiteur</label>
              <input class="form-control" readonly id="exampleInputEmail1" type="texte">              
          </div>
          <div class="input-group">
              <label for="exampleInputPassword1">Somme à transférer</label>
              <input class="form-control" id="exampleInputPassword1" type="texte">
          </div>
         
         
          <button type="submit" class="btn btn-default">Valider</button>
      </form>
</body>
</html>