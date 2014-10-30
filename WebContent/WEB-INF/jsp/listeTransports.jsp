<!DOCTYPE html>
<%@page import="fr.upmc.bean.TransportBean"%>
<%@page import="fr.upmc.bean.VoyageBean"%>
<%@page import="java.util.ArrayList"%>
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
					 
					 
					 <p> Offres de transport</p>
					 <div class="table-responsive"> 
				        <table class="table table-bordered">
				            <thead>
				                <tr>
				                    <th>Train</th>
				                    <th>Description</th>
				                    <th>Dimension</th>
				                    <th>Gain</th>
				                </tr>
				            </thead> 
				            <tbody>
				            
				            <% ArrayList<TransportBean> v = (ArrayList<TransportBean>) request.getAttribute("transport"); 
				            for (TransportBean vb : v){
				            %>
				            
				                <tr>
				                 	<td><%=vb.getVoyage().getDepart()%>-<%=vb.getVoyage().getArrivee() %> [<%=vb.getVoyage().getDate()%>]</td>
				                    <td><%=vb.getColisDescription()%></td>
				                    <td><%=vb.getColisDimension()%></td>
				                    <td><%=vb.getCout() %></td>
				                </tr>
				            <% } %>   
				            </tbody>
				        </table>
				</div>
				
				
								<p> Transports à faire</p>
					 <div class="table-responsive"> 
				        <table class="table table-bordered">
				            <thead>
				                <tr>
				                    <th>Train</th>
				                    <th>Description</th>
				                    <th>Dimension</th>
				                    <th>Gain</th>
				                    <th>Note</th>
				                </tr>
				            </thead> 
				            <tbody>
				            
				            <% ArrayList<TransportBean> v2 = (ArrayList<TransportBean>) request.getAttribute("transport"); 
				            for (TransportBean vb : v2){
				            %>
				            
				                <tr>
				                 	<td><%=vb.getVoyage().getDepart()%>-<%=vb.getVoyage().getArrivee() %> [<%=vb.getVoyage().getDate()%>]</td>
				                    <td><%=vb.getColisDescription()%></td>
				                    <td><%=vb.getColisDimension()%></td>
				                    <td><%=vb.getCout() %></td>
				                    <td> :)</td>
				                </tr>
				            <% } %>   
				            </tbody>
				        </table>
				</div>
				
				<p> Transports effectué</p>
					 <div class="table-responsive"> 
				        <table class="table table-bordered">
				            <thead>
				                <tr>
				                    <th>Train</th>
				                    <th>Description</th>
				                    <th>Dimension</th>
				                    <th>Gain</th>
				                    <th>Note</th>
				                </tr>
				            </thead> 
				            <tbody>
				            
				            <% ArrayList<TransportBean> v3 = (ArrayList<TransportBean>) request.getAttribute("transport"); 
				            for (TransportBean vb : v3){
				            %>
				            
				                <tr>
				                 	<td><%=vb.getVoyage().getDepart()%>-<%=vb.getVoyage().getArrivee() %> [<%=vb.getVoyage().getDate()%>]</td>
				                    <td><%=vb.getColisDescription()%></td>
				                    <td><%=vb.getColisDimension()%></td>
				                    <td><%=vb.getCout() %></td>
				                    <td> :)</td>
				                </tr>
				            <% } %>   
				            </tbody>
				        </table>
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
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>