<!DOCTYPE html>
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
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>

  </head>
  
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
					<% if (request.getAttribute("message")!=null) {
						out.print("<div id =\"message\">" + request.getAttribute("message") +". </div>");%>
						<br><form  method="get" action="<%=MappedJsp.HOME %>" >
						<button type="submit" class="btn btn-success">Home Page</button>
					</form>
					<%} else {%>
					<img src="img/Train.png" alt="!">
					<p>Voyager gratuitement, c'est possible ! </p>
					<p>Decouvre <b>Gratis trip! </b></p>
					<p>Le site qui te permet de financer tes voyages en train et voyager gratuitement ! <br> Bientot aussi sur le reseau TGV ! </p>
					<form  method="get" action="<%=MappedJsp.CREATE_TRANSPORT %>" >
					<button type="submit" class="btn btn-success">Envoyer un colis</button>
					</form><%} %>
				</div>
			</div>
	    </div>
	</div>
	
	

	
	<div id="footer">
					<p>
						Projet universitaire - UPMC Paris6
					</p>
	</div>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>