(function() {
	'use strict';

	angular.module('app.login').factory('UserService', UserService);

	/* @ngInject */
	function UserService($resource) {

		return $resource('rest/user/:action', {}, {
			authenticate : {
				method : 'POST',
				params : {
					'action' : 'authenticate'
				},
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}
		});

	}

})();