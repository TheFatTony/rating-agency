(function() {
	'use strict';

	angular.module('app.admin.news').factory('NewsAdminService', NewsAdminService);

	/* @ngInject */
	function NewsAdminService($resource) {

		return $resource('rest/admin/news/:id', {
			id : '@id'
		});

	}

})();