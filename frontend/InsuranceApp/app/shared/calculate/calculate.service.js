(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('calculateService', calculateService);

	calculateService.$inject = ['$resource'];

	function calculateService($resource) {
		var url = "http://localhost:8080/api/merchant/insurance/calculate";
		return $resource(url, {});
	}
})();
