(function() {
	'use strict';

	var module = angular.module('app.admin.contacts', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {
		$routeProvider.when('/admin/contacts/contacts-vew', {
			templateUrl : 'app/admin/inquiries/inquiries-vew.html',
			controller : 'ContactsAdminViewController'
		});
		
	}

})();
