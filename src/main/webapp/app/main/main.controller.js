(function () {
    'use strict';

    angular.module('app.main').controller('MainController',
        MainController);

    /* @ngInject */
    function MainController($scope, $rootScope, MainPageService) {

        $scope.newsItems = MainPageService.query({url: "news", lang: $rootScope.lang});


        $scope.currencyItems = MainPageService.query({url: "currencies"});

        $scope.icoListItems = MainPageService.query({url: "icos"});

        $rootScope.$on('$translateChangeSuccess', function (event, data) {
            $scope.newsItems = MainPageService.query({url: "news", lang: $rootScope.lang});

            $scope.currencyItems = MainPageService.query({url: "currencies"});

            $scope.icoListItems = MainPageService.query({url: "icos"});
        });
    }
})();