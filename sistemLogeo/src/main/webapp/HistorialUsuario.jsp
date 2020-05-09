<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
     $(document).ready(function(){
    	 $.post('ServeleHistorialUsuario',{
    			 
     }, function(respose){
    	 let datos = JSON.parse(respose);
    	 var tabladatos = document.getElementById("tablaDatos");
    	 for(let item of datos){
    		 tabladatos.innerHTML += `
    		 
    		   
    		 `
    	 }
     });
    	 });
 
</script>
<body>
<table class="table table-dark" id="tablaDatos">
     <thead>
     <th>ID </th>
     <th>NOMBRE </th>
     <th>PRECIO </th>
     <th>CANTIDAD </th>
     <th>TOTAL </th>
     <th> OPCIONES</th>

</table>
</body>
</html>