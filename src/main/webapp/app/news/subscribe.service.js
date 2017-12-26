(function() {
	'use strict';

	angular.module('app.news').factory('SubscribeService', SubscribeService);

	/* @ngInject */
	function SubscribeService($rootScope, $resource) {
		return $resource('rest/subscriptions/');
	}

})();