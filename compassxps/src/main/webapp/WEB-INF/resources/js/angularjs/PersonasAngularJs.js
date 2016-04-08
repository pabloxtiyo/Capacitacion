var personas = 
		{
			user: "Pablo"
		};

var personaApp = angular.module("personaApp", []);

personaApp.controller("personaCntrl", function($scope,$http) 
{
	var config = {
			 method: 'GET',
			 url: './Clientes/Lista',
			 headers: {
			   'Content-Type': 'application/json'
			 }
			}
	
	$http.get('./Clientes/Lista', config)
		.then(
			function successCallback(response){
				$scope.persons = response.data;
			},
			function errorCallback(response){});
});