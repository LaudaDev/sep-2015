(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('insuredAmountService', insuredAmountService);

	insuredAmountService.$inject = ['$resource'];

	function insuredAmountService($resource) {
		var url = "http://localhost:8080/MerchantApp/insuredAmount";
		return $resource(url, {});
	}
})();
