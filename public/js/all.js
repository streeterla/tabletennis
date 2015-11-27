/**
 * 
 */

var app = angular.module("tabletennis", ['ngGrid']);


function AllController($scope, $http) {
    $http.get("http://localhost:8080/all").
        success(function(data) {
            $scope.all = data;
        });


    $scope.gridOptions = {
		data: "all",
		columnDefs: [
		             {field: "id", displayName: "Rang" },
		             {field: "firstName", displayName: "Vorname"},
		             {field: "lastName", displayName: "Nachname"}
		            ]
		};
});
