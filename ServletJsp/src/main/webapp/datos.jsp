<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<form action="hello" method="post">
			<table align="center">
				<tr>
					<td>Nombre del pais</td>
					<td><input type="text" name="country" size="50"></td>
				</tr>
				
				<tr>
					<td>Idioma que se habla</td>
					<td>
						<select name="language">
							
						</select>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit">
					</td>
				</tr>
			</table>
		</form>
		
		<form action="insert" method="post">
			<table align="center">
				<tr>
					<td>Introducir idioma</td>
					<td><input type="text" name="language" size="50"></td>
				</tr>
				
				<tr>
					<td align="center">
						<input type="submit" name="Insertar idioma">
					</td>
				</tr>
				
			</table>
		</form>
	</body>
</html>