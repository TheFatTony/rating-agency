(function() {
	'use strict';

	angular.module('app.currencies').controller('CurrenciesListController',
        CurrenciesListController);

	/* @ngInject */
	function CurrenciesListController($rootScope, $scope, CurrenciesService) {
		$scope.items = CurrenciesService.query();
	}
})();