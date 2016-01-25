(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('realEstatePackageService', realEstatePackageService);

	realEstatePackageService.$inject = ['$resource'];

	function realEstatePackageService($resource) {
		var url = "http://localhost:8080/MerchantApp/realestate";
		return $resource(url, {});
	}
})();
