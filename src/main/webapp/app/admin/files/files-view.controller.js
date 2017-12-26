(function () {
    'use strict';

    angular.module('app.admin.news').controller('FilesAdminViewController', FilesAdminViewController);

    /* @ngInject */
    function FilesAdminViewController($scope, $location, FilesAdminService) {

        $scope.people = FilesAdminService.query();

        $scope.curentRow = null;

        $scope.updateDisabled = true;

        $scope.columns = [{
            text: 'name',
            datafield: 'name',
            width: 200,
            cellsalign: 'left',
            align: 'left'
        },
            {
                text: 'url',
                datafield: 'url',
                width: 400,
                cellsalign: 'left',
                align: 'left'
            },
            {
                text: 'effectiveDate',
                datafield: 'effectiveDate',
                width: 400,
                cellsalign: 'left',
                align: 'left'
            }];

        $scope.settings = {
            width: "100%",
            height: "100%",
            altrows: true,
            sortable: true,
            selectionmode: "singlerow",
            pageable: true,
            pagesize: 20,
            columnsresize: true,
            showtoolbar: false,
            enablebrowserselection: true,
            source: $scope.people,
            columns: $scope.columns
        };


        $scope.refresh = function () {
            $scope.people = FilesAdminService.query();
            $scope.settings.source = $scope.people;
        };

        $scope.create = function () {
            $location.path('/admin/files/files-create');

        };

        $scope.delete = function () {
// $scope.curentRow.$remove(function() {
// $scope.refresh();
// });
        };

    }
})();