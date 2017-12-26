(function() {
	'use strict';

	angular.module('app.admin.news').controller('NewsAdminEditController',
        NewsAdminEditController);

	/* @ngInject */
	function NewsAdminEditController($scope, $routeParams, $location, NewsAdminService) {

		var countries = [ {
			value : "ru",
			label : "Russian"
		}, {
			value : "en",
			label : "English"
		} ];

		$scope.comboBoxSettings = {
			created : function(args) {
				args.instance.focus();
			},
			source : countries,
			width : 230,
			height : 25
		};

		$scope.newsItem = NewsAdminService.get({
            id : $routeParams.id
        });

		$scope.editorSettingsContent = {
			width : 1020,
			height : 300
		};
		
		$scope.editorSettingsShContent = {
				width : 1020,
				height : 130
			};

		$scope.ok = function() {
			$scope.newsItem.$save(function() {
				$location.path('/admin/news/news-vew/');
			});
		};
		$scope.cancel = function() {
			$location.path('/admin/news/news-vew');
		};

	}
})();