/**
 * angular controller to display all players
 */

//var app = angular.module("tabletennis", ["ui.grid",'ngFileUpload','ngRoute']);


app.controller("AllController", [ "$scope", "$http", function($scope, $http) {
    $http.get("/all").success(function(data) {
            $scope.all = data;
        });

    var phoneTemplate = '<a href="tel:{{ COL_FIELD }}">{{ COL_FIELD }}</a>';


    $scope.gridOptions = {
		data: "all",
		columnDefs: [
		             {field: "position", displayName: "Rang" },
		             {field: "firstName", displayName: "Vorname"},
		             {field: "lastName", displayName: "Nachname"},
		             {field: "privatePhone.number", displayName: "Festnetz", cellTemplate: phoneTemplate},
		             {field: "mobilePhone.number", displayName: "Mobil", cellTemplate: phoneTemplate}
		            ]
		};
}]);
