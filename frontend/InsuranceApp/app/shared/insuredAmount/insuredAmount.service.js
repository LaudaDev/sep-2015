(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('insuredAmountService', insuredAmountService);

	insuredAmountService.$inject = ['$resource'];

	function insuredAmountService($resource) {
		var url = "https://localhost:8080/api/merchant/insuredAmount";
		return $resource(url, {});
	}
})();
