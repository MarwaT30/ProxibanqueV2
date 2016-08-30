<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.trio.proxibanquev2.domaine.Conseiller"%>
<%@ page import="com.trio.proxibanquev2.domaine.Client"%>
<%@ page import="com.trio.proxibanquev2.presentation.Utilejsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page client</title>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="editor" content="brix.io">
            
        <title>My page</title>
                    
        <!-- Bootstrap -->
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
        
                        
        <!-- User -->
        <link href="assets/css/style.css" rel="stylesheet">
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <!--[endif]---->
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
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
      </div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>

<%
		Conseiller user = (Conseiller) session.getAttribute("User");
int numeroclient= (int) session.getAttribute("numClientObserve"); 
	%>

<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>id</th>
                  <th>Nom</th>
                  <th>Prénom</th>
                  <th>Adresse</th>
                  <th>Téléphone</th>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>
              
              <%=Utilejsp.ligneClient(user.getListClient().get(numeroclient)) %>
              
              </tbody>
              </table>
            </div>
    	<div class="container-fluid">
        </div>
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
                  <td><%=Utilejsp.numeroCompteCourantClient(user.getListClient().get(numeroclient)) %></td>
                  <td><%=Utilejsp.numeroCompteEpargneClient(user.getListClient().get(numeroclient)) %></td>
                 
              </tr>
              <tr>
                  <td>Date d'ouverture</td>
                  <td><%=Utilejsp.dateOuvCourantClient(user.getListClient().get(numeroclient)) %></td>
                  <td><%=Utilejsp.dateOuvEpargneClient(user.getListClient().get(numeroclient)) %></td>
                 
              </tr>
              <tr>
                  <td>Solde</td>
                  <td><%=Utilejsp.soldeCourantClient(user.getListClient().get(numeroclient)) %></td>
                  <td><%=Utilejsp.soldeEpargneClient(user.getListClient().get(numeroclient)) %></td>
                  
              </tr>
          </tbody></table>
          <center>
        <form class="form-signin" role="form" action="editerclient.jsp" method="post">
              
        <button class="btn btn-lg btn-primary" type="submit">Editer le client</button>        
        
      </form>
      </center>
      <br>
      <br>
      <center>
        <form class="form-signin" role="form" action="virement.jsp" method="post">                  
        
        <button href="virement.jsp"class="btn btn-lg btn-primary" type="submit">Virement</button>
      </form>
      </center>
</body>
</html>