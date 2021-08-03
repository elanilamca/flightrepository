<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Location</title>
</head>
<body>
<form action="updateLoc" method="post">
<pre>
	Id :	<input type="text" name="id" value="${upadteLocation.id}" readonly/>
	Code :	<input type="text" name="code" value="${upadteLocation.code}" />
	Name :	<input type="text" name="name" value="${upadteLocation.name}"/>
	Type :  Urban <input type="radio" name="type" value="URBAN" ${upadteLocation.type=='URBAN'?'checked':''}/> 
			Rural <input type="radio" name="type" value="RURAL" ${upadteLocation.type=='RURAL'?'checked':''}/>
	
	<input type="submit" value="save"/>
</pre>	
</form>

</body>
</html>