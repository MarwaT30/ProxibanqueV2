<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.trio.proxibanquev2.domaine.Conseiller"%>
<%@ page import="com.trio.proxibanquev2.domaine.Client"%>
<%@ page import="com.trio.proxibanquev2.presentation.Utilejsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulter les comptes</title>
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
    <link href="consultercompte.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <!--[endif]---->
</head>
<body>
<%
		Conseiller user = (Conseiller) session.getAttribute("User");
	%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container-fluid">
              <div class="navbar-header"><button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button></div>
              <div class="navbar-collapse collapse">
                  <ul class="nav navbar-nav navbar-right">
                  	  <li><a href="creerclient.jsp">Créer un client</a></li>                      
                      <li><a href="menu.jsp">Menu principal</a></li>                      
                      
                  </ul>
              </div>
          </div>
      </div><!-- Bootstrap core JavaScript
    ================================================== --><!-- Placed at the end of the document so the pages load faster --><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
      <ul style="" class="dropdown-menu" role="menu" aria-labelledby="userid"></ul>
      <ul style="" class="dropdown-menu" role="menu" aria-labelledby="userid"></ul>
      <li role="presentation" class="dropdown-header">
          <ul class="nav nav-pills">
              <li class="dropdown">
                  <a class="dropdown-toggle btn-lg navbar-brand" data-toggle="dropdown" href="#">Choix du client <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <%=Utilejsp.listeDeroulanteClientUser(user.getListClient())%>
				</ul></li>
                  </ul>
              </li>
          </ul>
      </li>
      
      <table class="table table-bordered">
          <thead>
              <tr>
                  <th></th>
                  <th>Compte Courant</th>
                  <th>Compte Epargne</th>
                  </tr>
          </thead>
          <tbody>
              <tr>
                  <td>n° du compte</td>
                  <td>Mark</td>
                  <td>Otto</td>
                 
              </tr>
              <tr>
                  <td>Date d'ouverture</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                 
              </tr>
              <tr>
                  <td>Solde</td>
                  <td>Larry</td>
                  <td>the Bird</td>
                  
              </tr>
          </tbody></table>
</body>
</html>