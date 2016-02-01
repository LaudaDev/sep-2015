(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('insuranceResourceService', insuranceResourceService);

	insuranceResourceService.$inject = ['$resource'];

	function insuranceResourceService($resource) {
		var url = "https://localhost:8080/api/merchant/payment";
		return $resource(url, {});
	}
})();
