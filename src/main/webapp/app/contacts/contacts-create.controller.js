(function () {
    'use strict';

    angular.module('app.contacts').controller('ContactsCreateController',
        ContactsCreateController);

    /* @ngInject */
    function ContactsCreateController($scope, $route, ContactsService) {

		$scope.newsItem = new ContactsService();
        $scope.newsItem.name = null;
        $scope.newsItem.email = null;
        $scope.newsItem.comment = null;

        $scope.ok = function () {
            $scope.newsItem.$save(function () {
                $route.reload();
            });
        };

    }
})();