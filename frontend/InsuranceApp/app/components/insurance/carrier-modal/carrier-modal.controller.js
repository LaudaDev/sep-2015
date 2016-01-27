(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('CarrierModalController', CarrierModalController);

  CarrierModalController.$inject = ['$uibModalInstance','insurance'];

	function CarrierModalController($uibModalInstance,insurance) {
		var cmc = this;

		cmc.cancel = cancel;
		cmc.save = save;
    cmc.insurance = insurance;
		cmc.carriers = cmc.insurance.travel.users;
		cmc.validateUser = validateUser;

		function save(){
			$uibModalInstance.close(cmc.carrier);
		}

		function cancel() {
			$uibModalInstance.dismiss();
		}

		function validateUser() {
			if (cmc.stateForm.$valid) {
				cmc.stateForm.$setUntouched();
				save();
			} else {
				touchControlls();
			}
		}

		function touchControlls() {
			//Prođi kroz sve propertie stateForm objekta
			angular.forEach(cmc.stateForm, function(value, key) {
				//Pronađi propertie čiji naziv počinje sa "input"
				if (key.indexOf("input") === 0) {
					//"Dodirni" polje
					value.$setTouched();
				}
			});
		}
	}
})();
