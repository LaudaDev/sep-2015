(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('sportService', sportService);

	sportService.$inject = ['$resource'];

	function sportService($resource) {
		var url = "https://localhost:8080/api/merchant/sport";
		return $resource(url, {});
	}
})();
