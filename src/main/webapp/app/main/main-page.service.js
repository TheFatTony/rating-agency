(function () {
    'use strict';

    angular.module('app.main').factory('MainPageService', MainPageService);

    /* @ngInject */
    function MainPageService($rootScope, $resource) {
        return $resource('rest/main/:url/:lang', {
            lang: $rootScope.lang
        });
    }

})();