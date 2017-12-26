(function () {
    'use strict';

    angular.module('app').controller('LanguageSwitchController',
        LanguageSwitchController);

    /* @ngInject */
    function LanguageSwitchController($scope, $rootScope, $translate) {
        $scope.changeLanguage = function (langKey) {
            $translate.use(langKey);
        };

        $rootScope.$on('$translateChangeSuccess', function (event, data) {
            var language = data.language;

            $rootScope.lang = language;

            $rootScope.default_direction = 'ltr';
            $rootScope.opposite_direction = 'rtl';

            $rootScope.default_float = 'left';
            $rootScope.opposite_float = 'right';
        });

    }
})();