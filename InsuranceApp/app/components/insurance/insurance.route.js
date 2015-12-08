(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.config(config);

	config.$inject = ['$stateProvider'];
	function config($stateProvider) {

		$stateProvider
			.state('main.insurance', {
				url:'/insurance',
				views: {
					'content@': {
						// resolve: {
						// 	insurance : createInsurance
						// },
						templateUrl: 'app/components/insurance/insuranceForm.html',
						controller: 'InsuranceController',
						controllerAs: 'ic'
					}
				}
			});

		// createInsurance.$inject = ['Insurance'];
		// function createInsurance(Insurance){
		// 	return new Insurance();
		// };
	}
})();
