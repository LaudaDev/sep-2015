(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('regionService', regionService);

	regionService.$inject = ['$resource'];

	function regionService($resource) {
		var url = "http://localhost:8080/region";
		return $resource(url, {});
	}
})();
