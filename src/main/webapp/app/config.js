(function () {
    'use strict';

    var app = angular.module('app');

    var appConfig = {
        useAccessTokenHeader: true,
        debug: true
    };

    app.value('appConfig', appConfig);

    app.config(configure);


    app.filter("trust", ['$sce', function ($sce) {
        return function (htmlCode) {
            return $sce.trustAsHtml(htmlCode);
        }
    }]);

    /* @ngInject */
    function configure($locationProvider, $httpProvider) {

        $locationProvider.hashPrefix('!');

        $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
            return {
                'responseError': function (rejection) {
                    var status = rejection.status;
                    var config = rejection.config;
                    var statusText = rejection.statusText;
                    // var method = config.method;
                    // var url = config.url;

                    if ($rootScope.firstCall !== true) {
                        if (status == 401) {
                            $location.path("/login");
                        } else {
                            // $rootScope.error = method + " on " + url
                            //     + " failed with status " + status;
                            $rootScope.error = statusText;
                        }
                    } else {
                        $rootScope.firstCall = false;
                    }

                    return $q.reject(rejection);
                }
            };
        });

        $httpProvider.interceptors
            .push(function ($q, $rootScope, $location) {
                return {
                    'request': function (config) {
                        var isRestCall = config.url.indexOf('rest') == 0;
                        if (isRestCall
                            && angular
                                .isDefined($rootScope.accessToken)) {
                            var accessToken = $rootScope.accessToken;
                            if (appConfig.useAccessTokenHeader) {
                                config.headers['X-Access-Token'] = accessToken;
                            } else {
                                config.url = config.url + "?token="
                                    + accessToken;
                            }
                        }
                        return config || $q.when(config);
                    }
                };
            });

//        $.jqx.theme = 'darkblue';
         $.jqx.theme = 'orange';

    }

    app.run(run);

    /* @ngInject */
    function run($rootScope, $location, $cookieStore, UserService, matchmedia) {


        $rootScope.$on('$viewContentLoaded', function () {
            delete $rootScope.error;
        });

        $rootScope.hasRole = function (role) {

            if ($rootScope.user === undefined) {
                return false;
            }

            if ($rootScope.user.roles[role] === undefined) {
                return false;
            }

            return $rootScope.user.roles[role];
        };

        $rootScope.logout = function () {
            delete $rootScope.user;
            delete $rootScope.accessToken;
            $cookieStore.remove('accessToken');
            $location.path("/login");
        };

        var originalPath = $location.path();
        var accessToken = $cookieStore.get('accessToken');
        if (accessToken !== undefined) {
            $rootScope.accessToken = accessToken;
            $rootScope.firstCall = true;
            UserService.get(function (user) {
                $rootScope.user = user;
                $location.path(originalPath);
                $rootScope.firstCall = false;
            });
        }

        $rootScope.initialized = true;

        $rootScope.phone = matchmedia.isPhone();


    }

    app.directive('elSize', ['$parse', function ($parse) {
        return function (scope, elem, attrs) {
            var fn = $parse(attrs.elSize);

            scope.$watch(function () {
                // console.log(($(".footer").height() + elem.height() + 60));
                // console.log($(window).height());
                if (($(".footer").height() + elem.height() + 60) >= $(window).height()) {
                    $(".footer").removeClass("footer-fixed");
                    $(".footer").addClass("footer-relative");
                } else {
                    $(".footer").addClass("footer-fixed");
                    $(".footer").removeClass("footer-relative");
                }
                if ($(window).width() < 992) {
                    $("#main-menu").attr("data-toggle", "collapse");
                    $("#main-menu").attr("data-target", "#navbar-collapse");
                }

                return {width: elem.width(), height: elem.height()};
            }, function (size) {
                fn.assign(scope, size);
            }, true);

        }
    }]);
})
();
