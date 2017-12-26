(function() {
	'use strict';

	angular.module('app.admin.contacts').factory('ContactsAdminService', ContactsAdminService);

	/* @ngInject */
	function ContactsAdminService($resource) {

		return $resource('rest/admin/contacts');

	}

})();