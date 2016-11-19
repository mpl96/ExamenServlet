<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<form action="hello" method="post" name="form1">
			<h1 align="center">Servlet</h1>
			<table align="center">
				<tr>
					<td>Nombre del pais</td>
					<td><input type="text" name="pais" size="50"></td>
				</tr>
				<!-- 
				<tr>
					<td>Idioma que se habla</td>
					<td>
						<select name="idiomas">
							<option value="datos"></option>
						</select>
					</td>
				</tr>
				-->
				<tr>
					<td>Introducir idioma</td>
					<td><input type="text" name="idioma" size="50"></td>
				</tr>
				 -
				<tr>
					<td align="center">
						<input type="submit">
					</td>
				</tr>
				
			</table>
		</form>
	</body>
</html>