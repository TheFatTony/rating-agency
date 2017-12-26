(function() {
	'use strict';

	var module = angular.module('app.login', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

		$routeProvider.when('/login', {
			templateUrl : 'app/login/login.html',
			controller : 'LoginController'
		});

	}

})();
