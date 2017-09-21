angular.module('mainModule').controller('StudentController', function($scope, $http,$window){

	$scope.testing = "PROBANDO por si acaso";
	$scope.students = [];

	$scope.getStudents = function() {
		$http.get('http://localhost:1414/student/all').then(function(data) {
			$scope.students = data.data;
		});
	};

	$scope.addStudent = function() {
		$http.post('http://localhost:1414/student/new', 
			{
				first_name : $scope.first_name,
				last_name : $scope.last_name,
				rut: $scope.rut,
				career:$scope.career,
				email:$scope.email,
				entry_year:$scope.entry_year
			}
		).then(function(data) {
			$scope.msg = 'Pelicula creada correctamente';
			$scope.getStudents();
		}).catch(function(data) {
			$scope.msg = 'Se ha producido un error';
		});

		$window.location.reload();
	};

});