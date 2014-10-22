<%@page import="fr.upmc.bean.Train"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transilien</title>
</head>
<body>
<table border="1px" cellpadding="5px" cellspacing="2px">
	<%
	String numGareDepart = (String) request.getAttribute("numGareDepart");
	String numGareArrivee = (String) request.getAttribute("numGareArrivee");
	%>
<caption>Liste des trains</caption>
<%out.println("Départ : ");%><%=numGareDepart%><br>
<%out.println("Arrivée : ");%><%=numGareArrivee%><br>
  <tr>
    <th>Num</th>
    <th>Départ</th>
    <th>Miss</th>
    <th>Term</th>
  </tr>
  
<%
    ArrayList<fr.upmc.bean.Train> trains = new ArrayList();
    trains = (ArrayList<fr.upmc.bean.Train>) request.getAttribute("trainsAlaGare");
    out.println("TOTAL DES TRAINS : "+trains.size());
    for(Iterator<fr.upmc.bean.Train> it = trains.iterator(); it.hasNext();){
    	fr.upmc.bean.Train train = it.next();
        out.println("<tr><td>"+train.getNumero()+"</td>"
                +"<td>"+train.getDateDepart()+"</td>"
                +"<td>"+train.getMiss()+"</td>"
                +"<td>"+train.getTerm()+"</td></tr>");
    }
%>
</table>
</body>
</html>