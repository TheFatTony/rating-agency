(function() {
	'use strict';

	angular.module('app.news').controller('NewsListController',
			IcoListController);

	/* @ngInject */
	function IcoListController($rootScope, $scope, NewsItemService) {
		$scope.newsItems = NewsItemService.query({lang : $rootScope.lang});

		$rootScope.$on('$translateChangeEnd', function(event, data) {
            $scope.newsItems = NewsItemService.query({lang : $rootScope.lang});
		});
	}
})();