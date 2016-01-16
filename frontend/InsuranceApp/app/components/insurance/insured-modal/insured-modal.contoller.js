(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('InsuranceModalController', InsuranceModalController);

  InsuranceModalController.$inject = ['$uibModalInstance', 'user'];

	function InsuranceModalController($uibModalInstance, user) {
		var imc = this;

		imc.cancel = cancel;
		imc.save = save;
		imc.user = user;
		imc.validateUser = validateUser;

		function save() {
			$uibModalInstance.close(imc.user);
		}

		function cancel() {
			$uibModalInstance.dismiss();
		}

		function validateUser() {
			if (imc.stateForm.$valid) {
				imc.stateForm.$setUntouched();
				save();
			} else {
				touchControlls();
			}
		}

		function touchControlls() {
			//Prođi kroz sve propertie stateForm objekta
			angular.forEach(imc.stateForm, function(value, key) {
				//Pronađi propertie čiji naziv počinje sa "input"
				if (key.indexOf("input") === 0) {
				  //"Dodirni" polje
				  value.$setTouched();
				}
			});
		}
	}
})();
