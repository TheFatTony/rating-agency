(function() {
	'use strict';

	var app = angular.module('app', [ 'ngRoute', 'ngSanitize', 'ngCookies',
			'ngResource', 'jqwidgets', 'jqwidgets-amd', 'matchmedia-ng',
			'pascalprecht.translate',
			/*
			 * App modules
			 */
			'app.translation', 'app.login', 'app.main', 'app.news',
			'app.about', 'app.contacts', 'app.admin', 'app.ratings', 'app.icolist', 'app.currencies' ]);

})();
