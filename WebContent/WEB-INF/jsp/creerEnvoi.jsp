<!DOCTYPE html>

<%@page import="fr.upmc.mappings.MappedNames"%>
<%@page import="fr.upmc.bean.TrasporteurBean"%>
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
    <link rel="stylesheet" href="css/styles.css">
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/typeahead.min.js"></script>


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
             <%HttpSession s = request.getSession(true);
            
            TrasporteurBean bean = (TrasporteurBean) s.getAttribute("user");
			try{
					String li =  bean.getPrenom() +" "+bean.getNom(); 
		            %>
		            <li><a href="<%=MappedJsp.LISTE_VOYAGES%>">Voyages</a></li>
		            <li><a href="<%=MappedJsp.LISTE_TRANSPORTS%>">Transports</a></li>
		            <li><a href="<%=MappedJsp.ACCOUNT%>"><%=li%></a></li>
		            <li><a href="<%=MappedJsp.LOGOUT%>">Logout</a></li>
           <%} catch (Exception e){
        	 %> 
	        	    <li><a href="<%=MappedJsp.CREATE_ACCOUNT%>">Create count</a></li>
	        	    <li><a href="<%=MappedJsp.LOGIN%>">Login</a></li>
          <% } %>
           
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
						  <label for="" class="col-sm-2 control-label">Gare D�part</label>
     				 <div class="col-sm-10">
						    <input type="text" class="typeahead" id="depart" name="<%=MappedNames.GARE_DEPART%>" class="form-control" id="<%=MappedNames.GARE_DEPART%>">
						  </div></div>
						  <div class="form-group">
						  <label for="" class="col-sm-2 control-label">Gare Arriv�e</label>
     				 <div class="col-sm-10">
						    <input type="text" class="typeahead" id="arrivee"  name="<%=MappedNames.GARE_ARRIVEE%>" class="form-control" id="<%=MappedNames.GARE_ARRIVEE%>">
						  </div>
						  </div>
						  <div class="form-group">
						  	<label for="" class="col-sm-2 control-label">Votre E-mail</label>
     						<div class="col-sm-10">
						    <input type="text" name="<%=MappedNames.MAIL_ENVOYEUR%>" class="form-control" id="<%=MappedNames.MAIL_ENVOYEUR%>">
						  	</div>
						  </div>
						  <div class="form-group">
						  <label for="" class="col-sm-2 control-label">E-mail receveur</label>
     				 		<div class="col-sm-10">
						    <input type="text" name="<%=MappedNames.MAIL_RECEVEUR%>" class="form-control" id="<%=MappedNames.MAIL_RECEVEUR%>">
						  	</div>
						  </div>
						  

						  <div class="form-group">
  							<label for="" class="col-sm-2 control-label">Description colis</label>
     						<div class="col-sm-10">
						    <textarea class="form-control" rows="5" id="comment" name="<%=MappedNames.DESCRIPTION_COLIS%>"></textarea>
						    </div>
						  </div>
						  <br>
						   <div class="form-group">
						  	<label for="" class="col-sm-2 control-label">Dimention colis</label>
     						<div class="col-sm-10">
							  <div class="btn-group" id="buttons_dimention">
							  	  <button type="button" class="btn btn-default">Tr�s Petit</button>
								  <button type="button" class="btn btn-default">Petit</button>
								  <button type="button" class="btn btn-default">Moyen</button>
								  <button type="button" class="btn btn-default">Gros</button>
								  <button type="button" class="btn btn-default">Tr�s gros</button>
							 </div>
							 </div>
							</div>
							
													  
						    <br><br>
						  <button type="submit" class="btn btn-success">Cr�er</button><br>
					</form>
				</div>
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
    <script src="js/bootstrap.min.js"></script>
     <script type="text/javascript">
    $(function(){
      $('#depart').typeahead({
        name: 'gares',
        prefetch: 'data/gares.json',
        limit: 10
      });

    });
  </script>
   <script type="text/javascript">
    $(function(){
      $('#arrivee').typeahead({
        name: 'gares',
        prefetch: 'data/gares.json',
        limit: 10
      });

    });
  </script>
  </body>
</html>