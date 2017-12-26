(function () {
    'use strict';

    angular.module('app.contacts').factory('ContactsService', ContactsService);

    /* @ngInject */
    function ContactsService($resource) {
        return $resource('rest/contacts');
    }

})();