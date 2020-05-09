<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
HttpSession seccion2 = (HttpSession)request.getSession();
String usuariovariableseccion =(String)seccion2.getAttribute("usuario");//aca se castea()
if(usuariovariableseccion == null){
	response.sendRedirect("index.jsp");
	
	
}

%>
<body>
<form action="ServeleteUser" method="post">
<input type="submit"  value="CERRAR" name="btncerrar">
</form>
<a href="HistorialUsuario.jsp"> VER HISTORIAL USUARIOS</a>
<h1>HOLA MUNDO desde principal</h1>
</body>
</html>