(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('insuranceService', insuranceService);

	insuranceService.$inject = [];

	function insuranceService() {
		var insurance = {};
		
		var getInsurance = function() {
			return insurance;
		}

		var setInsurance = function(value) {
			insurance = value;
		}

		return {
		  getInsurance: getInsurance,
		  setInsurance: setInsurance
		};
	}
})();
