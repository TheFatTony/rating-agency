(function() {
	'use strict';

	var module = angular.module('app.icolist', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

        $routeProvider.when('/ico-list', {
            templateUrl : 'app/ico-list/ico-list-list.html',
            controller : 'IcoListListController'
        });

        $routeProvider.when('/ico-list/view/:id', {
            templateUrl : 'app/ico-list/ico-list-view.html',
            controller : 'IcoListViewController'
        });


	}

})();
