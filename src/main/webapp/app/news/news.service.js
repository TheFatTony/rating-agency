(function() {
	'use strict';

	angular.module('app.news').factory('NewsItemService', NewsItemService);

	/* @ngInject */
	function NewsItemService($rootScope, $resource) {

		return $resource('rest/news/:lang/:id');

	}

})();