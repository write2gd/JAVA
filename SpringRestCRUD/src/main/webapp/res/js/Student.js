angular.module('StudentDemo', [])
.controller('StudentController', function($scope, $http) {
    $http.get('http://localhost:8084/SpringRestCRUD/service/students').
        then(function(response) {
            $scope.courses = response.data;
        });
});