(function() {
	"use strict";

	angular
		.module('insurance-app.core')
		.controller('HeaderController', HeaderController);

	HeaderController.$inject = ['$translate', 'tmhDynamicLocale', 'crTranslations'];

	function HeaderController($translate, tmhDynamicLocale, crTranslations) {
		var hc = this;
		hc.changeLocale = changeLocale;
		hc.currentLocale = $translate.use();

		function changeLocale(locale) {
			$translate.use(locale);
			tmhDynamicLocale.set(locale);
			hc.currentLocale = $translate.use();
		}
	}
})();
