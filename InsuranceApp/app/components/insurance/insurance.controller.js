(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.controller('InsuranceController', InsuranceController);

	InsuranceController.$inject = [];
	function InsuranceController() {
		var ic = this;
    ic.REButIsClicked = false;
		ic.viewRealEstateOptions = viewRealEstateOptions;

    function viewRealEstateOptions(){

      ic.REButIsClicked = (ic.REButIsClicked == false) ? true:false;
    }
	}
})();
