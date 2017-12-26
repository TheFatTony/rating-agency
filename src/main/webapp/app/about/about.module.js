(function() {
	'use strict';

	var module = angular.module('app.about', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

		$routeProvider.when('/about', {
			templateUrl : 'app/about/about.html'
		});


	}

})();
