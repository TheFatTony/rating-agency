(function () {
    'use strict';

    angular.module('app.news').controller('NewsViewController',
        NewsViewController);

    /* @ngInject */
    function NewsViewController($scope, $routeParams, $rootScope, NewsItemService, NewsTopItemService) {
        NewsItemService.get({lang : $rootScope.lang,
            id: $routeParams.id
        }).$promise.then(
            function (value) {
                var options = {
                    weekday: "long", year: "numeric", month: "long",
                    day: "numeric"
                };
                var d = new Date(value.displayDate);
                value.displayDate = d.toLocaleDateString($rootScope.lang, options);
                $scope.newsItem = value;
            },
            function (error) {/*Do something with error*/
            }
        );

        $scope.newsItems = NewsTopItemService.query({lang : $rootScope.lang })

    }
})();