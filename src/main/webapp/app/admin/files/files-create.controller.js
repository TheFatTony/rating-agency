(function() {
	'use strict';

	angular.module('app.admin.news').controller('FilesAdminCreateController',
			FilesAdminCreateController);

	/* @ngInject */
	function FilesAdminCreateController($scope, $location, FilesAdminService) {

		// $scope.newsItem = new FilesService();

		$scope.fileUploadSettings = {
			width : 300,
			uploadUrl : 'rest/admin/files/upload',
			fileInputName : 'content',
            multipleFilesUpload: false
		};

		$scope.ok = function() {
			$location.path('/admin/files/files-vew');
		};
		$scope.cancel = function() {
			$location.path('/admin/files/files-vew');
		};

	}
})();