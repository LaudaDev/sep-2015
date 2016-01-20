(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('regionService', regionService);

	regionService.$inject = ['$resource'];

	function regionService($resource) {
		var url = "http://localhost:8080/MerchantApp/region";
		return $resource(url, {});
	}
})();
