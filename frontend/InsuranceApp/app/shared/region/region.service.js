(function() {
	"use strict";

	angular
		.module('region')
		.factory('regionService', regionService);

	regionService.$inject = ['$resource'];

	function regionService($resource) {
		var url = "https://localhost:8080/api/merchant/region";
		return $resource(url, {});
	}
})();
