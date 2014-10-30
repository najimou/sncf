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
    <link href="http://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/master/build/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link href="http://eonasdan.github.io/bootstrap-datetimepicker/scripts/ru.js" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-2.1.1.js"></script>

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
		            <li><a href="<%=MappedJsp.RENSEIGNER_VOYAGE%>">Renseigner voyage</a></li>
		            <li><a href="<%=MappedJsp.LISTE_TRANSPORTS%>">Liste transports</a></li>
		            <li><a href="<%=MappedJsp.ACCOUNT%>"><%=li%></a></li>
		            <li><a href="<%=MappedJsp.LOGIN%>">Logout</a></li>
           <%} catch (Exception e){
        	 %>  
	        	    <li><a href="<%=MappedJsp.LOGIN%>">Login</a></li>
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
					
					
					
						<form role="form" method="post">
						  <div class="form-group">
						  <div class="container">
                    <div class="row">
						  <div class='col-sm-6'>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker1'>
                                    <input type='text' class="form-control" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker1').datetimepicker();
                            });
                        </script>
                        </div></div>
						  
						  <div class='input-group date' id='datetimepicker1'>
			                    <input type='text' class="form-control" name="<%=MappedNames.DATE%>"  />
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
			                    </span>
			               </div>
						  </div>
						  <div class="form-group">
						    <input type="text" name="<%=MappedNames.GARE_DEPART%>" class="form-control" id="<%=MappedNames.GARE_DEPART%>" placeholder="Depart" >
						  </div>
						  <div class="form-group">
						    <input type="text" name="<%=MappedNames.HEURE_DEPART%>" class="form-control" id="<%=MappedNames.HEURE_DEPART%>" placeholder="Heure depart" >
						  </div>
						  <div class="form-group">
						    <input type="text" name="<%=MappedNames.GARE_ARRIVEE%>" class="form-control" id="<%=MappedNames.GARE_ARRIVEE%>" placeholder="Arrivee">
						  </div>
						   <div class="form-group">
						    <input type="text" name="<%=MappedNames.HEURE_ARRIVEE%>" class="form-control" id="<%=MappedNames.HEURE_ARRIVEE%>" placeholder="Heure arrivee">
						  </div>
						    <br>
						    <input type="hidden" name="<%=MappedNames.NB_TRAIN%>" value="123">
						  <button type="submit" class="btn btn-success">Ajouter a mes voyages</button><br>
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
        
  </body>
</html>
