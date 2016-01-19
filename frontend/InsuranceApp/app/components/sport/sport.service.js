(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('sportService', sportService);

	sportService.$inject = ['$resource'];

	function sportService($resource) {
		var url = "http://localhost:8080/sport";
		return $resource(url, {});
	}
})();
