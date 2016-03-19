<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script src="https://code.jquery.com/jquery-1.12.1.min.js" integrity="sha256-I1nTg78tSrZev3kjvfdM5A5Ak/blglGzlaZANLPDl3I=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		
		var mostrarInformacion =  function(data)
		{
			var table = "<table>";
					 
			
			for (var int = 0; int < data.length; int++) 
			{
				var val = data[int];
				table += "<tr><td>"+val.nombre+"</td>"+"<td>"+val.apellido+"</td></tr>";
			}
			
			table += "</table>";
			
			$("#table").html(table);
		};
	
		$(document).ready(function(){
			
			$("#save").click(function(){
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "./Clientes/Guardar",
					success : function(data) 
					{
						alert(data);
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
			});
			
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "./Clientes/Lista",
				dataType : "json",
				success : function(data) 
				{
					mostrarInformacion(data);
				},
				error : function(e) {
					console.log("ERROR: ", e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
			
		});
	</script>		  
	<title>Home</title>
	
</head>
<body>
<h1>
	Hello world!  
</h1>


<div id="table"></div>

<form action="./Clientes/Guardar" method="post">
	<input name="nombre" placeholder="Ingrese su nombre"/>
	<input name="apellido" placeholder="Ingrese su apellido"/>
	<button id="save" type="submit" title="Guardar">Guardar</button>
</form>


</body>
</html>
