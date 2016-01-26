(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('insuranceResourceService', insuranceResourceService);

	insuranceResourceService.$inject = ['$resource'];

	function insuranceResourceService($resource) {
		var url = "http://localhost:8080/api/merchant/insurance";
		return $resource(url, {});
	}
})();
