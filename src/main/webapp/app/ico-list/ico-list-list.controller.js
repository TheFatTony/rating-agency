(function() {
	'use strict';

	angular.module('app.icolist').controller('IcoListListController',
        IcoListListController);

	/* @ngInject */
	function IcoListListController($rootScope, $scope, IcoListService) {
		$scope.items = IcoListService.query();
	}
})();