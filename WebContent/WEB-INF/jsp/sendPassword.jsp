<%@page import="fr.upmc.mappings.MappedNames"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if (request.getAttribute("error")!=null) out.print("<div id =\"error\">" + request.getAttribute("error") +"</div>"); %> 

<form name="input" action="" method="post">
Mail <input type="text" name="<%=MappedNames.MAIL%>">
<input type="submit" value="Renvoyer MDP">
</form>

</body>
</html>