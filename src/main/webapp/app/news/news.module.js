(function() {
	'use strict';

	var module = angular.module('app.news', []);

	angular.module('app').config(configure);

	/* @ngInject */
	function configure($routeProvider) {

		$routeProvider.when('/news', {
			templateUrl : 'app/news/news-list.html',
            controller : 'NewsListController'
		});
		
		$routeProvider.when('/news_view/:id', {
			templateUrl : 'app/news/news-view.html',
			controller : 'NewsViewController'
		});


	}

})();
