(function () {
    'use strict';

    angular.module('app.admin.news').controller('NewsAdminCreateController',
        NewsAdminCreateController);

    /* @ngInject */
    function NewsAdminCreateController($scope, $location, NewsAdminService) {

        var countries = [{
            value: "ru",
            label: "Russian"
        }, {
            value: "en",
            label: "English"
        }];

        $scope.comboBoxSettings = {
            created: function (args) {
                args.instance.focus();
            },
            source: countries,
            width: 230,
            height: 25,
            displayMember: "language",
            valueMember: "language"
        };

		$scope.newsItem = new NewsAdminService();
		$scope.newsItem.language = null;
		$scope.newsItem.imageUrl = null;
        $scope.newsItem.title = null;
		$scope.newsItem.shortContent = null;
		$scope.newsItem.content = null;
		$scope.newsItem.publishDate = null;
		$scope.newsItem.published = null;
		$scope.newsItem.author = null;

        $scope.editorSettingsContent = {
            width: 1020,
            height: 300
        };

        $scope.editorSettingsShContent = {
            width: 1020,
            height: 130
        };

        $scope.ok = function () {
            $scope.newsItem.$save(function () {
                $location.path('/admin/news/news-vew');
            });
        };
        $scope.cancel = function () {
            $location.path('/admin/news/news-vew');
        };

    }
})();