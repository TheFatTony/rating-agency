(function() {
	'use strict';

	var module = angular.module('app.contacts', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

		$routeProvider.when('/contacts', {
			templateUrl : 'app/contacts/contacts.html',
			controller : 'ContactsCreateController'
		});


	}

})();
