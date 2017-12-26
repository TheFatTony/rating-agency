(function () {
    'use strict';

    var module = angular.module('app.admin.news', []);

    angular.module('app').config(configure);

    /* @ngInject */
    function configure($routeProvider) {

        $routeProvider.when('/admin/news/news-vew', {
            templateUrl: 'app/admin/news/news-vew.html',
            controller: 'NewsAdminViewController'
        });

        $routeProvider.when('/admin/news/news-create', {
            templateUrl: 'app/admin/news/news-create.html',
            controller: 'NewsAdminCreateController'
        });

        $routeProvider.when('/admin/news/news-edit/:id', {
            templateUrl: 'app/admin/news/news-edit.html',
            controller: 'NewsAdminEditController'
        });

    }

})();
