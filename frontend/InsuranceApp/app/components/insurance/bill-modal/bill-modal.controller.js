(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('BillModalController', BillModalController);

<<<<<<< Updated upstream
	BillModalController.$inject = ['$modalInstance', 'insurance', '$translate'];

	function BillModalController($modalInstance, insurance, $translate) {
		var bmc = this;
=======
  BillModalController.$inject = ['$uibModalInstance', 'insurance', '$translate'];

  function BillModalController($uibModalInstance, insurance, $translate) {
    var bmc = this;
>>>>>>> Stashed changes

		bmc.cancel = cancel;
		bmc.insurance = insurance;
		bmc.currentLocale = currentLocale;

		function currentLocale() {
		if ($translate.use() === 'sr-latn') {
			bmc.insurance.amountToPay *= 112.69;
		}
    }

    function cancel() {
<<<<<<< Updated upstream
		$modalInstance.close();
=======
      $uibModalInstance.close();
>>>>>>> Stashed changes
    }
  }
})();
