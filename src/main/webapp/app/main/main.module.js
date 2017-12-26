(function () {
    'use strict';

    var module = angular.module('app.main', []);

    angular.module('app').config(configure);

    /* @ngInject */
    function configure($routeProvider) {

        $routeProvider.when('/', {
            templateUrl: 'app/main/main-page.html',
            controller: 'MainController'
        });

        $routeProvider.otherwise({
            templateUrl: 'app/main/404.html'
        });


    }

})();
