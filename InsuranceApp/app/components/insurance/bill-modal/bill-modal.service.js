(function() {
	'use strict';

	angular
		.module('insurance-app.insurance')
		.factory('billModal', billModal);

	billModal.$inject = ['$uibModal'];
	function billModal( $uibModal) {
		return {
			open: openBillModal
		};

		function openBillModal() {

			var modalInstance = $uibModal.open({
				animation: true,
				resolve: {

					insurance : function() {
						return ic.insurance.travel;
					}
				},
				templateUrl: 'app/components/insurance/bill-modal/bill-modal.html',
				controller: 'BillModalController',
				controllerAs: 'bmc'
			});
		}
	}
})();
