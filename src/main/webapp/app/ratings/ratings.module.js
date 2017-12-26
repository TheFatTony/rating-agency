(function() {
	'use strict';

	var module = angular.module('app.ratings', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

		$routeProvider.when('/ratings', {
			templateUrl : 'app/ratings/ratings.html'
		});


	}

})();
