(function() {
  "use strict";

  angular
    .module('paying-app.paying')
    .controller('PayingController', PayingController);

  PayingController.$inject = ['insurance','$window','$location'];

  function PayingController(insurance,$window,$location) {
    var pc = this;
    pc.showTooltip = false;
    pc.howerOwer = howerOwer;

    pc.insurance = insurance;
    pc.backToInsurance = backToInsurance;

    function howerOwer() {
      pc.showTooltip = (pc.showTooltip === false) ? true : false;
    }

    function backToInsurance(){
      $window.location.href = "http://localhost:8081/#/home/"
    }
  }
})();
