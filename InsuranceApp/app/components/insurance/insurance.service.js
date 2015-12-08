(function() {
	"use strict";

	angular
		.module('insurance-app.insurance')
		.factory('insuranceService', insuranceService);

	insuranceService.$inject = ['$resource'];
	function insuranceService($resource) {
		var apiKey = "INXupqz0_X3m6Xp42025Tl54zoIT4Mfc";
		var dbName = "insuranceapp";
		var collectionName = "purchaseInsurances";
		return $resource("https://api.mongolab.com/api/1/databases/:dbName/collections/:collectionName/",
			{apiKey: apiKey,  dbName: dbName, collectionName: collectionName});
	}
})();
