(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.config(config);

	config.$inject = ['$stateProvider'];

	function config($stateProvider) {
		$stateProvider.state('main.insuranceBasic', {
			url: '/insurance',
			views: {
				'content@': {
				templateUrl: 'app/components/insurance/insuranceBasic.html',
				controller: 'InsuranceController',
				controllerAs: 'ic'
				}
			}
		})
		.state('main.insuranceDetails', {
			url: '/insuranceDetails',
			views: {
			  'content@': {
					templateUrl: 'app/components/insurance/insuranceDetails.html',
					controller: 'InsuranceDetailsController',
					controllerAs: 'idc'
				}
			}
		});
	}
})();
