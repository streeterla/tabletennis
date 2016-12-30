/**
 * 
 */



app.config(function($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
      templateUrl : 'home.html',
      controller : 'AllController',
      controllerAs: 'controller'
    }).when('/login', {
      templateUrl : 'login.html',
      controller : 'navigation',
      controllerAs: 'controller'
    }).otherwise('/');

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

  })
  .controller('navigation', function($rootScope, $http, $location, fileUploadService) {

	  var self = this

	  var authenticate = function(credentials, callback) {

	    var headers = credentials ? {authorization : "Basic "
	        + btoa(credentials.username + ":" + credentials.password)
	    } : {};

	    $http.get('user', {headers : headers}).success(function(data) {
	      if (data.name) {
	        $rootScope.authenticated = true;
	      } else {
	        $rootScope.authenticated = false;
	      }
	      callback && callback();
	    }).error(function() {
	      $rootScope.authenticated = false;
	      callback && callback();
	    });

	  }

	  authenticate();
	  self.credentials = {};
	  self.login = function() {
	      authenticate(self.credentials, function() {
	        if ($rootScope.authenticated) {
	          $location.path("/");
	          self.error = false;
	        } else {
	          $location.path("/login");
	          self.error = true;
	        }
	      });
	  };
	  
	  self.logout = function() {
		  $http.post('logout', {}).finally(function() {
		    $rootScope.authenticated = false;
		    $location.path("/");
		  });
		};

		self.fileupload = function() {
            var file = document.getElementById('file').files[0];
            var uploadUrl = "/fileUpload";
            fileUploadService.uploadFileToUrl(file, uploadUrl);
		};
	});