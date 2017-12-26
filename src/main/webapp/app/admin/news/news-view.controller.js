(function () {
    'use strict';

    angular.module('app.admin.news').controller('NewsAdminViewController', NewsAdminViewController);

    /* @ngInject */
    function NewsAdminViewController($scope, $location, NewsAdminService) {

        $scope.people = NewsAdminService.query();

        $scope.curentRow = null;

        $scope.updateDisabled = true;

        $scope.columns = [{
            text: 'language',
            datafield: 'language',
            width: 200,
            cellsalign: 'left',
            align: 'left'
        }, {
            text: 'publishDate',
            datafield: 'publishDate',
            cellsformat: 'd',
            width: 200,
            cellsalign: 'left',
            align: 'left'
        }, {
            text: 'title',
            datafield: 'title',
            width: 200,
            cellsalign: 'left',
            align: 'left'
        }, {
            text: 'published',
            datafield: 'published',
            width: 200,
            cellsalign: 'left',
            align: 'left'
        }, {
            text: 'author',
            datafield: 'author',
            width: 200,
            cellsalign: 'left',
            align: 'left'
        }, {
            text: 'shortContent',
            datafield: 'shortContent',
            width: 350,
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
            source: $scope.people,
            rowselect: function (event) {
                $scope.updateDisabled = false;
                $scope.curentRow = NewsAdminService.get({
                    id: event.args.row.id
                });
            },
            columns: $scope.columns
        };


        $scope.refresh = function () {
            $scope.people = NewsAdminService.query();
            $scope.settings.source = $scope.people;
        };

        $scope.create = function () {
            $location.path('/admin/news/news-create');
        };

        $scope.edit = function () {
            $location.path('/admin/news/news-edit/' + $scope.curentRow.id);
        };

        $scope.delete = function () {
            $scope.curentRow.$remove(function () {
                $scope.refresh();
            });
        };

    }
})();