(function() {
	'use strict';

	angular.module('app.currencies').factory('CurrenciesService', CurrenciesService);

	/* @ngInject */
	function CurrenciesService($rootScope, $resource) {
		return $resource('rest/currencies/:id', {
			id : '@id'
		});
	}

})();