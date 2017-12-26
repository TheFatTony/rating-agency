(function() {
	'use strict';

	var module = angular.module('app.translation', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider, $translateProvider) {

		$translateProvider.useStaticFilesLoader({
			prefix : 'app/translations/',
			suffix : '.json'
		}).preferredLanguage('en').useLocalStorage();

	}

	angular.module('app').run(run);

	/* @ngInject */
	function run($rootScope, $location, $cookieStore, UserService, matchmedia) {
		$rootScope.lang = 'en';

		$rootScope.default_float = 'left';
		$rootScope.opposite_float = 'right';

		$rootScope.default_direction = 'ltr';
		$rootScope.opposite_direction = 'rtl';
	}

})();
