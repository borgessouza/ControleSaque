angular.module('main').controller('NavController', ['$scope' , '$http' , function($scope, $http) {
		window.$scope = $scope;

	$scope.init = function() {
		$scope.sucesso = false;
		$scope.erro = false;
		$scope.alerta = false;
		$scope.recuperarTodos();
	}

	$scope.atualizar = function(id) {
		$scope.atualizando = id;
	}
	
	
	$scope.carregar = function(id) {
		location.reload();
	}
	
	
	$scope.retornarAtualizacao = function() {
		$scope.atualizando = 0;
		
	}
	
	$scope.atualizarUsuario = function(clienteId, clienteUsuario, clienteNome, clienteValor) {
		
		$http({
			method : 'PATCH',
			url : 'atualizarCliente/',
			data : {
				id : clienteId,
				usuario : clienteUsuario,
				nome : clienteNome,
				valor : clienteValor
			}
		}).then(function successCallback(response) {
			$scope.atualizando = 0;
			
		  }, function errorCallback(response) { 
			 
		  })

	}

	$scope.addUser = function(usuarioCliente, nomeCliente, valorCliente) {
		$scope.sucesso = false;
		$scope.alerta = false;
		if (nomeCliente == undefined || valorCliente == undefined 
				|| usuarioCliente == undefined || usuarioCliente == ""
				|| nomeCliente == "" || valorCliente == "") {
			$scope.alerta = true;
		} else {
		
			$http({
				method:'POST',
				url:'cadastroCliente',
				data : {
					usuario : usuarioCliente,
					nome : nomeCliente,
					valor : valorCliente
				} 
			}).then(function successCallback(response) {
				$scope.sucesso = true;
				$scope.clienteNome = undefined;
				$scope.clienteUsuario= undefined;
				$scope.clienteValor = undefined;
			  }, function errorCallback(response) { 
				 
			  })
		}
		
			
			
	}
	
	$scope.limpaModal = function() { 
		$scope.sucesso = false;
		$scope.erro = false;
		$scope.alerta = false;
		$scope.clienteNome = undefined;
		$scope.clienteUsuario= undefined;
		$scope.clienteValor = undefined;
		$scope.recuperarTodos();
		location.reload();
		
	}
	

	$scope.deleteUser = function(id) {
		$http({
			method:'DELETE',
			url:'removerCliente/' + id
		})
		$scope.recuperarTodos();
		$scope.carregar();
	}

	$scope.recuperarTodos = function() {
		
		$http({
			method : 'GET',
			url : 'recuperarTodos/'
		}).then(function successCallback(response) {
			$scope.clientes = response.data; 
		  }, function errorCallback(response) {
		    throw new Error("Error");
		  })
	};

}]);