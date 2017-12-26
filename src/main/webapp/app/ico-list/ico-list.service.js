(function() {
	'use strict';

	angular.module('app.icolist').factory('IcoListService', IcoListService);

	/* @ngInject */
	function IcoListService($rootScope, $resource) {
		return $resource('rest/icolist/:id', {
			id : '@id'
		});
	}

})();