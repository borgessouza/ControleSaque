angular.module('main').controller('UsuarioController',['$scope', '$http', function ($scope, $http) {

    window.$scope = $scope;


   $scope.init = function() {
       console.log('Iniciando Usuario Controller');
       $scope.error = false;

    }


}]);