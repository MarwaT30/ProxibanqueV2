<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.trio.proxibanquev2.domaine.Conseiller"%>
<%@ page import="com.trio.proxibanquev2.domaine.Client"%>
<%@ page import="com.trio.proxibanquev2.presentation.Utilejsp"%>
<%@ page import="com.trio.proxibanquev2.domaine.CompteBancaire"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virement</title>
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
<%
		Conseiller user = (Conseiller) session.getAttribute("User");
int numeroclient= (int) session.getAttribute("numClientObserve");
ArrayList<CompteBancaire> listecomptebanque= (ArrayList<CompteBancaire>) session.getAttribute("listeCompteBanque");
	%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
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
        <br>
        <br>        
        <br>
        <br>
        <br>
        
        
        <br>
        <br>
       
       
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                       
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>n°compte</th>
                        <th>Date d'ouverture</th>
                        <th>Solde</th>
                        <th>Type de compte</th>
                    </tr>
                </thead>
                <tbody>
				
					<%=Utilejsp.tableauCompteClientDebiteur(user.getListClient().get(numeroclient)) %>
					
				</tbody>
                </table>
        </div>
        <br>
        <br>
            <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                       
                        <th>Ligne</th>
                        <th>id client</th>
                        <th>n°compte</th>
                        <th>Date d'ouverture</th>
                        <th>Solde</th>
                        <th>type de compte</th>
                    </tr>
                </thead>
                <tbody>
				
					<%=Utilejsp.tableauCompteBanque(listecomptebanque) %>
					
				</tbody>
                </table>
                </table>
        </div>
        <br>
        <br>
        <center>
		 <form class="form-signin" role="form" action="ChoixClient" method="get">
		 <input type="radio" name="compte" id="courant" value="courant"> courant<br>
  		 <input type="radio" name="compte" id="epargne" value="epargne" checked="checked"> epargne<br>
        <h4>Solde à transférer:</h4>        
        <input class="input-control" name="montant" placeholder="solde à transférer" required="" autofocus="" type="login">
        <h4>Choisir le n° de ligne du client</h4>
        <input class="input-control" name="lignecompte" placeholder="n° de ligne du client" required="" autofocus="" type="login"><br>
        <br>
             
        
        <button class="btn btn-lg btn-primary" type="submit">Transférer</button>
      </form>
      </center>
       
</body>
</html>