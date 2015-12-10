(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceController', InsuranceController);

  InsuranceController.$inject = ['insuranceService','vehicleModels','$window','$location'];

  function InsuranceController(insuranceService,vehicleModels,$window,$location) {
    var ic = this;
    ic.REButIsClicked = false;
    ic.VButIsClicked = false;
    ic.insuranceBase = 120;
    ic.idCounter = 1;

    ic.types = vehicleModels.getTypes();

    ic.viewRealEstateOptions = viewRealEstateOptions;
    ic.viewVehicleOptions = viewVehicleOptions;

    ic.save = save;


    function viewRealEstateOptions() {

      ic.REButIsClicked = (ic.REButIsClicked === false) ? true : false;
    }


    function viewVehicleOptions() {

      ic.VButIsClicked = (ic.VButIsClicked === false) ? true : false;
    }

    function save() {
      ic.insurance._id = ic.idCounter;
      insuranceService.save({},ic.insurance,onSuccesSave);
      console.log("sacuvano");
      $window.alert("http://localhost:8080/#/paying/" + ic.idCounter);

    }

    function onSuccesSave(){
      console.log("Osiguranje uspesno sacuvano i sad cistim formu...");
      var payingAppLink = "http://localhost:8080/#/paying/" + ic.idCounter;
      ic.idCounter++;
      ic.insurance = {};
      ic.REButIsClicked = false;
      ic.VButIsClicked = false;
      //$window.location.href = payingAppLink;
    }
  }
})();
