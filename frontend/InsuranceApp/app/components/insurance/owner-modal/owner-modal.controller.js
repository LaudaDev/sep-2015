(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('OwnerModalController', OwnerModalController);

  OwnerModalController.$inject = ['$uibModalInstance','owner'];

	function OwnerModalController($uibModalInstance,owner) {
		var omc = this;

		omc.cancel = cancel;
		omc.save = save;
		omc.owner = owner;
		omc.validateUser = validateUser;

		function save(){
			$uibModalInstance.close(omc.owner);
		}

		function cancel() {
			$uibModalInstance.dismiss();
		}

		function validateUser() {
			if (omc.stateForm.$valid) {
				omc.stateForm.$setUntouched();
				save();
			} else {
				touchControlls();
			}
		}

		function touchControlls() {
			//Prođi kroz sve propertie stateForm objekta
			angular.forEach(omc.stateForm, function(value, key) {
				//Pronađi propertie čiji naziv počinje sa "input"
				if (key.indexOf("input") === 0) {
					//"Dodirni" polje
					value.$setTouched();
				}
			});
		}
	}
})();
