<!DOCTYPE html>
<%@page import="fr.upmc.mappings.MappedNames"%>
<%@page import="fr.upmc.mappings.MappedJsp"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="UPMC Project - SNCF">
    <meta name="author" content="UPMC">
    <link rel="icon" href="../../favicon.ico">

    <title>Projet UPMC - Transilien SNCF 2014/2015</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>

  </head>

  <body>
  
  	<body>

   
    <div class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp"> Gratis trip ! </a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=MappedJsp.HOME%>">Help</a></li>
            <li><a href="<%=MappedJsp.HOME%>">Contact</a></li>
            <li><a href="<%=MappedJsp.CREATE_ACCOUNT%>">Create count</a></li>
            <li><a href="<%=MappedJsp.LOGIN%>">Login</a></li>
          </ul>
        </div>
      </div>
    </div>

	
	<div id="ww">
	    <div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered" id="change_content">
					<% if (request.getAttribute("error")!=null) out.print("<div id =\"error\">" + request.getAttribute("error") +"</div>"); %>
					
					
						<form role="form" method="post" class="form-horizontal" >
						  <div class="form-group">
						  	<label for="" class="col-sm-2 control-label">Nom</label>
     						<div class="col-sm-10">
						    <input type="text" name="<%=MappedNames.NOM%>" class="form-control" id="<%=MappedNames.NOM%>" placeholder="Nom">
						  	</div>
						  </div>
						  <div class="form-group">
						  <label for="" class="col-sm-2 control-label">Prenom</label>
     				 		<div class="col-sm-10">
						    <input type="text" name="<%=MappedNames.PRENOM%>" class="form-control" id="<%=MappedNames.PRENOM%>" placeholder="Prenom">
						  	</div>
						  </div>
						  <div class="form-group">
						  <label for="" class="col-sm-2 control-label">E-mail</label>
     				 <div class="col-sm-10">
						    <input type="text" name="<%=MappedNames.MAIL%>" class="form-control" id="<%=MappedNames.MAIL%>" placeholder="E-mail">
						  </div></div>
						  <div class="form-group">
						  <label for="" class="col-sm-2 control-label">Password</label>
     				 <div class="col-sm-10">
						    <input type="password" name="<%=MappedNames.PASSWORD%>" class="form-control" id="<%=MappedNames.PASSWORD%>" placeholder="Enter password">
						  </div>
						  </div>
						    <br>
						  <button type="submit" class="btn btn-success">CREER</button><br><br>
					</form>
					
					
			</div>
	    </div>
	</div>
	
	

	
	<div id="footer">
		<div class="container">
			<div class="row">
					<p>
						Projet universitaire - UPMC Paris6
					</p>
			</div>
		
		</div>
	</div>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
