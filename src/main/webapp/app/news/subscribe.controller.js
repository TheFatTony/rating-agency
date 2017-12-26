(function () {
    'use strict';

    angular.module('app.news').controller('SubscribeController',
        SubscribeController);

    /* @ngInject */
    function SubscribeController($scope, $rootScope, SubscribeService) {

		$scope.newsItem = new SubscribeService();
        $scope.newsItem.language = $rootScope.lang;
        $scope.newsItem.email = null;

        $scope.ok = function () {
            $scope.newsItem.$save(function () {
                $scope.newsItem.email = null;
            });
        };

    }
})();