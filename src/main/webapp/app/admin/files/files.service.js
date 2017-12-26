(function() {
	'use strict';

	angular.module('app.admin.news').factory('FilesAdminService', FilesAdminService);

	/* @ngInject */
	function FilesAdminService($resource) {

		return $resource('rest/admin/files/:id', {
			id : '@id'
		});

	}

})();