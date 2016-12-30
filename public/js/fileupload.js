var app = angular.module("tabletennis", ["ui.grid",'ngFileUpload','ngRoute']);

app.service('fileUploadService', function ($http) {
  this.uploadFileToUrl = function(file, uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    $http.post(uploadUrl, fd, {
        transformRequest: angular.identity,
        headers: {'Content-Type': undefined}
      })
      .success(function(){
        $http.get("/sync");
        $http.get("/all").success(function(data) {
                $scope.all = data;
            });
        window.location.reload(true);
      })
      .error(function(){
      });
  }
});