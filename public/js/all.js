/**
 * 
 */

var app = angular.module("tabletennis", ["ui.grid"]);


app.controller("AllController", [ "$scope", "$http", function($scope, $http) {
    $http.get("http://localhost:8080/all").success(function(data) {
            $scope.all = data;
        });


    $scope.gridOptions = {
		data: "all",
		columnDefs: [
		             {field: "id", displayName: "Rang" },
		             {field: "firstName", displayName: "Vorname"},
		             {field: "lastName", displayName: "Nachname"},
		             {field: "privatePhone.number", displayName: "Festnetz"},
		             {field: "mobilePhone.number", displayName: "Mobil"}
		            ]
		};
}]);
