(function() {
	'use strict';

	angular.module('app.admin.contacts').controller('ContactsAdminViewController', ContactsAdminViewController);

	/* @ngInject */
	function ContactsAdminViewController($scope, $location, ContactsAdminService) {

		$scope.people = ContactsAdminService.query();

		$scope.curentRow = null;

		$scope.updateDisabled = true;

		$scope.columns = [ {
			text : 'effectiveDate',
			datafield : 'effectiveDate',
            cellsformat: 'd',
			width : 200,
			cellsalign : 'left',
			align : 'left'
		},
		{
			text : 'name',
			datafield : 'name',
			width : 200,
			cellsalign : 'left',
			align : 'left'
		},
        {
            text : 'email',
            datafield : 'email',
            width : 200,
            cellsalign : 'left',
            align : 'left'
        },
        {
            text : 'comment',
            datafield : 'comment',
            width : 800,
            cellsalign : 'left',
            align : 'left'
        }];

		$scope.settings = {
			width : "100%",
			height : "100%",
			altrows : true,
			sortable : true,
			selectionmode : "singlerow",
			pageable : true,
			pagesize : 20,
			columnsresize : true,
			showtoolbar : false,
			enablebrowserselection: true,
			source : $scope.people,
			columns : $scope.columns
		};


		$scope.refresh = function() {
			$scope.people = ContactsAdminService.query();
			$scope.settings.source = $scope.people;
		};


	}
})();