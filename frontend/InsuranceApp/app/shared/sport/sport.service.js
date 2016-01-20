(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('sportService', sportService);

	sportService.$inject = ['$resource'];

	function sportService($resource) {
		var url = "http://localhost:8080/MerchantApp/sport";
		return $resource(url, {});
	}
})();
