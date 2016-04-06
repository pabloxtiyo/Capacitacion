

$(document).ready(function(){
	
	$(".update").click(function(){
  	     var id = $(this).data("id"); 
  	     
  		     $.ajax({
  		    	    type: "GET",
  		    		url: "/AppTest/Employees/SearchEmp/"+id,		    	    
  		    	    success: function(employee){
  		    	    	
  		    	    	$("#upnombres").val(employee.nombres);
  		    	    	$("#upapellidos").val(employee.apellidos);
  		    	    	$("#upedad").val(employee.edad);
  		    	    	$("#upnivel").val(employee.nivelAcademico);
  		    	    	$("#upfetcrg").val(employee.fechaRegistro);
  		    	    	$("#upfetcr").val(employee.fechaRetiro);
  		    	    	$("#upsalario").val(employee.salario);
  		    	    	$("#uphab").val(employee.habilidades);
  		    	    	//$("#uphab").val(employee.habilidades);
  		    	    	
  		    	    },
  		    	    error: function(e){
  		    	    	alert('Unable to find the server');
  		    	    }
  		   });
  		     
    		});
	    
	    $('.datatable').dataTable({
	    	"aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "Todos"]],
	    	"bStateSave": true,
	    	"sScrollY": "300px",
	    	"scrollX": true,
	    	"sPaginationType": "full_numbers",
	    	"bFilter": true,
			"autoWidth": false,
	    	"oSearch": {"sSearch": " "},
	    	"oLanguage": {
	    		"sProcessing":     "Procesando...",
	    	    "sLengthMenu":     "Mostrar _MENU_ registros",
	    	    "sZeroRecords":    "No se encontraron resultados",
	    	    "sEmptyTable":     "No hay datos disponibles",
	    	    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	    	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	    	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	    	    "sInfoPostFix":    "",
	    	    "sSearch":         " Buscar:",
	    	    "sUrl":            "",
	    	    "sInfoThousands":  ",",
	    	    "sLoadingRecords": "Cargando...",
	    	    "oPaginate": {
	    	        "sFirst":    "Primero",
	    	        "sLast":     "\u00DAltimo",
	    	        "sNext":     "Siguiente",
	    	        "sPrevious": "Anterior"
	    	    },
	    	    "oAria": {
	    	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	    	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	    	    },
	    	    "fnDrawCallback" : function() {
	    	    	
	    	    }
			}
	    	});
		
});

