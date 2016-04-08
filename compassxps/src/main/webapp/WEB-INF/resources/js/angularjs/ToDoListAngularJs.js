var ToDoListApp = angular.module("ToDoListApp",[]);

var demoList = 
	{
		mensaje : 'Lista de tareas por hacer',
		items : 
		[
			{actividad:'Ir de compras',hecho:false},
			{actividad:'Jugar play',hecho:false},
			{actividad:'Programar compass xps en un dia',hecho:true},
			{actividad:'Arreglar rastreo en dos dias ;)',hecho:true}
		]
	}
		

ToDoListApp.controller("ToDoListCntrl", function($scope) 
{
	$scope.demoList = demoList;
	
	$scope.agregarNuevoItem=function(nuevaTarea)
	{
		$scope.demoList.items.push({actividad:nuevaTarea,hecho:false});
		$scope.nuevaTarea="";
	}
});
