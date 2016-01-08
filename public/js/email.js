/**
 * controller to send email to all
 */

app.controller("MailToAll", [ "$scope", "$http", function($scope, $http) {
    $http.get("/emaillist").success(function(data) {
    	$scope.link = angular.fromJson(data)[0];
    });
    
    $scope.emailToAll = function() {
        	window.location.href = "mailto:" + $scope.link.one;
    }
}]);
