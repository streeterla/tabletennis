/**
 * angular controller to upload a new excel file containing players
 */

//app.controller('FileUploadController', ['$scope', 'Upload', function ($scope, Upload) {
//    // upload later on form submit or something similar
//    $scope.submit = function() {
//        $scope.upload($scope.file);
//    };
//
//    // upload on file select or drop
//    $scope.upload = function (file) {
//        Upload.upload({
//            url: './upload/',
//            data: {file: file,}
//        }).then(function (resp) {
//            console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
//        }, function (resp) {
//            console.log('Error status: ' + resp.status);
//        }, function (evt) {
//            var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
//            console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
//        });
//    };
//}]);


app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);

app.service('fileUpload', ['$http', function($http) {
	this.uploadFileToUrl = function(uploadUrl, file, name, date) {
		var fd = new FormData();
		fd.append('file', file);
		fd.append('person', name);
		fd.append('date', date);
		$http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function() {
//
		}).error(function() {
		});
	}
} ]);

app.controller('FileUploadController', [ '$scope', 'fileUpload',
		function($scope, fileUpload) {
			$scope.uploadFile = function() {
				var file = $scope.myFile;
				var name = $scope.name;
				var date = $scope.date;
				console.log('file is ' + JSON.stringify(file));
				var uploadUrl = "/upload";
				fileUpload.uploadFileToUrl(uploadUrl, file, name, date);
			};
		} ]);