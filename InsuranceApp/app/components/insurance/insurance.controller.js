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

    ic.types = vehicleModels.getTypes();


    ic.viewRealEstateOptions = viewRealEstateOptions;
    ic.viewVehicleOptions = viewVehicleOptions;

    ic.save = save;


    function viewRealEstateOptions() {

      ic.REButIsClicked = (ic.REButIsClicked == false) ? true : false;
    }


    function viewVehicleOptions() {

      ic.VButIsClicked = (ic.VButIsClicked == false) ? true : false;
    }

    function save() {
      console.log("sacuvano");
      insuranceService.save({},ic.insurance,onSuccesSave);

    }

    function onSuccesSave(){
      console.log("Osiguranje uspesno sacuvano i sad cistim formu...")
      ic.insurance = {};
      ic.REButIsClicked = false;
      ic.VButIsClicked = false;
      //$window.location.href = "http://localhost:8081/#/home"; //samo sam probao da vidim da l moze da se rediektuje na 2 angular aplikaciju
    }
  }
})();
