(function() {
	'use strict';

	angular.module('app.icolist').controller('IcoListViewController',
        IcoListViewController);

	/* @ngInject */
	function IcoListViewController($rootScope, $routeParams, $scope, IcoListService) {
        $scope.item = IcoListService.get({
            id : $routeParams.id
        });
	}
})();