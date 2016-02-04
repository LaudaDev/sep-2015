(function() {
	"use strict";

	angular
		.module('insurance-app.shared')
		.controller('RedirectController', RedirectController);

	RedirectController.$inject = ['$state'];

	function RedirectController($state) {
		var rc = this;

    rc.redirectToHome = redirectToHome;

    function redirectToHome(){
      $state.go('main.home');
    }

	}
})();
