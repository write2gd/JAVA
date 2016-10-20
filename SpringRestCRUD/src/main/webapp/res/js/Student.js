angular.module('StudentDemo', [])
.controller('StudentController', function($scope, $http) {
    $http.get('http://localhost:8084/SpringRestCRUD/service/').
        then(function(response) {
            $scope.countries = response.data;
        });
});