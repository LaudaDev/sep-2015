(function() {
	"use strict";

	angular
		.module('insurance-app.core')
		.controller('HeaderController', HeaderController);

	HeaderController.$inject = ['$translate', 'tmhDynamicLocale', 'crTranslations','insuranceService'];

	function HeaderController($translate, tmhDynamicLocale, crTranslations,insuranceService) {
		var hc = this;
		hc.changeLocale = changeLocale;
		hc.currentLocale = $translate.use();
		hc.insurance = insuranceService.getInsurance();
		console.log("osiguranje u head controlleru");
		console.log( hc.insurance);

		function changeLocale(locale) {
			console.log("osiguranje u head controlleru kad promenim lokal");
			console.log( hc.insurance);
			$translate.use(locale);
			tmhDynamicLocale.set(locale);
			hc.currentLocale = $translate.use();
		}
	}
})();
