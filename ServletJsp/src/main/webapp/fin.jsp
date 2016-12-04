<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,Servlet.*" %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>
</head>
<body>
<form method="post" action="List">	
	<input type="submit"  value="List">
	
	<input type="button" onclick="window.location.href='datos.jsp'"  value="Comeback">
</form>	


<table border="1">
		<thead>
			<tr>
				<td>Country</td>
				<td>Language</td>
				<td>Delete</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="user" items="${listAllCountries}">
				<tr>
					<td><c:out value="${user.country}"/> </td>
					<td><c:out value="${user.language}"/> </td>
					<td><a name="user1" href="Confirmacion?language=${user1.language}">Delete Language</a></td>
		    	</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>