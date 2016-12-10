<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,model.*,service.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
Services service = new Services();
List<Languages> listAllLanguages = service.listLanguages(); 
pageContext.setAttribute("languages", listAllLanguages);
%>

<form method="post" action="index">
	<table width="40%" align="center">
		<tr>
			<td><p>Country</p></td>
			<td>
				<input type="text" id="country" name="country" size="30">
			</td>
		</tr>
		
		<tr>
			<td><p>Language</p></td>
			<td><select name ="Language" id="Language">
			  	<%  
			  		if (null != listAllLanguages && !listAllLanguages.isEmpty()){
				  		for (Languages language : listAllLanguages){
						   out.println("<option value ='"+language.getLanguages()+"'>"+language.getLanguages()+"</option>");
						}
			  		}
				%>
			</select></td>
		</tr>
		
		<tr>
			<td>Insert language</td>
			<td>
				<input type="text" id="newLanguage" name="newLanguage" size="30">
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="Send">
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="button" onclick="window.location.href='end.jsp'"  value="List Countries">
			</td>
		</tr>
	</table>
</form>
</body>
</html>