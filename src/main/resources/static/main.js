var app = angular.module("RestauranteManagement", []);
app.controller("RestauranteController", function($scope, $http) {	
	$scope.names = ["1", "2", "3","4","5"];
	$scope.semana = ["Segunda-feira", "Terça-feira", "Quarta-feira","Quinta-feira","Sexta-feira","Sabado"];
	$scope.restaurante = [];
    $scope.restauranteForm = {
    	restauranteId: 1,
    	restauranteNome: "",
    	restauranteEndereco: "",
    	restauranteVoto: "",
    	restauranteDiaSemana: ""
    };
    
    _refreshRestauranteData();
 
    $scope.submitRestaurante = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.restauranteForm.restauranteId == -1) {
            method = "POST";
            url = '/restaurante';
        } else {
            method = "PUT";
            url = '/restaurante';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.restauranteForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createRestaurante = function() {
        _clearFormData();
    }
 
    $scope.deleteRestaurante = function(restaurante) {
        $http({
            method: 'DELETE',
            url: '/restaurante/' + restaurante.restauranteId
        }).then(_success, _error);
    };
 
    $scope.editRestaurante = function(restaurante) {
    	console.log('editando')
    	if(restaurante.restauranteDiaSemana==""){
    		$scope.restauranteForm.restauranteId = restaurante.restauranteId;
            $scope.restauranteForm.restauranteNome = restaurante.restauranteNome;
            $scope.restauranteForm.restauranteEndereco = restaurante.restauranteEndereco;
            $scope.restauranteForm.restauranteVoto = restaurante.restauranteVoto;
            $scope.restauranteForm.restauranteDiaSemana = restaurante.restauranteDiaSemana;
    	}else{
    		alert("Restaurante já foi frequentado essa semana");
    	}
        
    };
 
    function _refreshRestauranteData() {
    	console.log('todos restaurantes');
        $http({
            method: 'GET',
            url: '/restaurantes'
        }).then(
            function(res) { // success
                $scope.restaurantes = res.data;
                for (var i = 0; i < res.data.length; i++) {
                	if(res.data[i].restauranteDiaSemana!=""){
                		if($scope.semana.indexOf(res.data[i].restauranteDiaSemana)>=0){
                			var index = $scope.semana.indexOf(res.data[i].restauranteDiaSemana);
                    		$scope.semana.splice(index,1);
                        	console.log("Semana:"+res.data[i].restauranteDiaSemana);
                		}
                		 
                	}
                	
				}
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
    	_refreshRestauranteData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // limpa
    function _clearFormData() {
    	$scope.restauranteForm.restauranteId = -1;
        $scope.restauranteForm.restauranteNome = "";
        $scope.restauranteForm.restauranteEndereco = "";
        $scope.restauranteForm.restauranteVoto = "";
        $scope.restauranteForm.restauranteDiaSemana = "";
        
    };
});