(function() {
	'use strict';

	var module = angular.module('app.currencies', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

        $routeProvider.when('/currencies', {
            templateUrl : 'app/currencies/currencies-list.html',
            controller : 'CurrenciesListController'
        });



	}

})();
