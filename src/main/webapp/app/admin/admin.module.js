(function() {
	'use strict';

	var module = angular.module('app.admin', ['app.admin.news', 'app.admin.files' ,'app.admin.contacts']);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

	}

})();
