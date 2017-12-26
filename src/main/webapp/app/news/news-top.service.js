(function() {
	'use strict';

	angular.module('app.news').factory('NewsTopItemService', NewsTopItemService);

	/* @ngInject */
	function NewsTopItemService($rootScope, $resource) {
		return $resource('rest/news/top/:lang');
	}

})();