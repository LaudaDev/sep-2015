(function() {
	"use strict";

	angular
		.module('insurance-app.core')
		.config(config);

	config.$inject = ['$stateProvider'];
	function config($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('main.insurance', {
				url:'/insurance',
				views: {
					'content@': {
						templateUrl: 'app/components/insurance/insuranceForm.html',
						controller: 'InsuranceController',
						controllerAs: 'ic'
					}
				}
			});
			// .state('main.home', {
			// 	url: '/home',
			// 	views: {
			// 		'content@': {
			// 			templateUrl: 'app/components/core/home.html'
			// 		}
			// 	}
			// });
	}
})();
