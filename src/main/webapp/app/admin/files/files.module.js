(function() {
	'use strict';

	var module = angular.module('app.admin.files', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {
		$routeProvider.when('/admin/files/files-vew', {
			templateUrl : 'app/admin/files/files-vew.html',
			controller : 'FilesAdminViewController'
		});
		
		$routeProvider.when('/admin/files/files-create', {
			templateUrl : 'app/admin/files/files-create.html',
			controller : 'FilesAdminCreateController'
		});
	}

})();
