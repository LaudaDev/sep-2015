(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('BillModalController', BillModalController);

	BillModalController.$inject = ['$modalInstance', 'insurance', '$translate'];

	function BillModalController($modalInstance, insurance, $translate) {
		var bmc = this;

		bmc.cancel = cancel;
		bmc.insurance = insurance;
		bmc.currentLocale = currentLocale;

		function currentLocale() {
		if ($translate.use() === 'sr-latn') {
			bmc.insurance.amountToPay *= 112.69;
		}
    }

    function cancel() {
		$modalInstance.close();
    }
  }
})();
