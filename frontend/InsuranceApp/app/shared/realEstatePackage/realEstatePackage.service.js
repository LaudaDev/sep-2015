(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.factory('realEstatePackageService', realEstatePackageService);

	realEstatePackageService.$inject = ['$resource'];

	function realEstatePackageService($resource) {
		var url = "https://localhost:8080/api/merchant/realestate";
		return $resource(url, {});
	}
})();
