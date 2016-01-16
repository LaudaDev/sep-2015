(function() {
	"use strict";

	angular
		.module('insurance-app.core')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];
	function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');

		$stateProvider
			.state('main', {
				abstract: true,
				views: {
					'header': {
						templateUrl: 'app/components/core/header.html',
						controller: 'HeaderController',
						controllerAs: 'hc'
					},
					'footer' : {
						templateUrl: 'app/components/core/footer.html'
					}
				}
			})
			.state('main.home', {
				url: '/home',
				views: {
					'content@': {
						templateUrl: 'app/components/core/home.html'
					}
				}
			})
			.state('main.about',{
					url: '/aboutUs',
					views: {
						'content@': {
							templateUrl: 'app/components/core/aboutUs.html'
						}
					}

			});
	}
})();
