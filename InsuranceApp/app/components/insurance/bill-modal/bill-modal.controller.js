(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('BillModalController', BillModalController);

	BillModalController.$inject = ['$uibModalInstance','insurance'];
	function BillModalController($uibModalInstance,insurance) {
		var bmc = this;
		bmc.cancel = cancel;
		bmc.insurance = insurance;
		console.log(bmc.insurance);

		function cancel() {
			$uibModalInstance.dismiss();
		}
	}
})();
