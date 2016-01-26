(function() {
	'use strict';
	angular
		.module('insurance-app.shared')
		.factory('jmbgService', jmbgService);

	jmbgService.$inject = ['$resource'];
	function jmbgService($resource) {
		var url = "http://localhost:8080/api/merchant/insurance/jmbg/:jmbg";
		return $resource(url, {});
	}
})();
