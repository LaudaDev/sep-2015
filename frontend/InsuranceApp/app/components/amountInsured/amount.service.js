(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('amountService', amountService);

	amountService.$inject = ['$resource'];

	function amountService($resource) {
		var url = "http://localhost:8080/amount";
		return $resource(url, {});
	}
})();
