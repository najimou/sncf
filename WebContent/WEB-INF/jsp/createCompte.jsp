<%@page import="fr.upmc.mappings.MappedNames"%>
<%@page import="org.hibernate.metamodel.source.annotations.attribute.MappedAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form name="input" action="" method="post">
Nom <input type="text" name="<%=MappedNames.NOM%>">
Prenom <input type="text" name="<%=MappedNames.PRENOM%>">
Mail <input type="text" name="<%=MappedNames.MAIL%>">
Password <input type="password" name="<%=MappedNames.PASSWORD%>">
<input type="submit" value="Creer compte">
</form>


</body>
</html>