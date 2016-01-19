(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('insuranceService', insuranceService);

	insuranceService.$inject = [];

	function insuranceService() {
		var insurance = {};
	  insurance.travel = {};
		insurance.travel.users = [];

		var getInsurance = function() {
			return insurance;
		};

		var setInsurance = function(value) {
			insurance = value;
		};

		var getTravelInsurance = function() {
			return insurance.travel;
		};

		var getInsuranceUsers = function() {
			return insurance.travel.users;
		};


		return {
		  getInsurance : getInsurance,
		  setInsurance : setInsurance,
			getTravelInsurance : getTravelInsurance,
			getInsuranceUsers : getInsuranceUsers

		};
	}
})();
