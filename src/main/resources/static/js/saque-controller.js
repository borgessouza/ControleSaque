angular.module('main').controller('SaqueController', ['$scope' , '$http' , function($scope, $http) {
		window.$scope = $scope;
		
		
		$scope.init = function() {
			$scope.login = true;
			$scope.alertaLogin = false;
			$scope.alertaSaque = false;
		}
		
	$scope.limpa = function(usuario) {
			$scope.valorSaque = undefined;
			$scope.usuario = undefined;
			$http({
				method : 'POST',
				url : 'deslogar?usuario=' + usuario
				})
			
		}
		
	$scope.entrar = function(usuario) {
		$scope.saqueNegado = false;
		$scope.alertaSaque = false;	
		$scope.alertaLogin = false;
		$scope.saque = undefined;
		if (usuario == undefined || usuario == "") {
			$scope.loginMsg = "Favor preencher o Usuário!!";
			$scope.alertaLogin = true;
		} else {
			$http({
				method : 'GET',
				url : 'login?id=' + usuario
				}).then(function successCallback(response) {
				$('#saqueModal').modal('show');
				$scope.saqueId = response.data;
			}, function errorCallback(response) {
				if (response.status == 401) {
					$scope.loginMsg = response.data.retornoNegativa;
					$scope.alertaLogin = true;
				} else {
				$scope.loginMsg = "Ocorreu um erro, Favor verficar"
				$scope.alertaLogin = true;
				}
			})
		}
	}	
	
	$scope.realizarSaque= function(valorSaque, valorDisponivel,id) {
		$scope.saqueNegado = false;
		$scope.alertaSaque = false;
			if (valorSaque == undefined || valorSaque == "") {
			$scope.loginMsg = "Favor preencher o Valor o Saque!!";
		} else {
			$http({
				method : 'PATCH',
				url : 'realSaque?valorSaque=' + valorSaque + 
					'&valorDisponivel=' + valorDisponivel +
					'&id='+ id
				}).then(function successCallback(response) {
					$scope.saque = response.data;
					$scope.alertaSaque = true;
			}, function errorCallback(response) {
				$scope.saqueNegativa = response.data.retornoNegativo;
				$scope.saqueNegado = true;
			})
		}
		
	}
	

}]);