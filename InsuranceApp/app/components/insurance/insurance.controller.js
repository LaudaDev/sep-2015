(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceController', InsuranceController);

  InsuranceController.$inject = ['insuranceService'];

  function InsuranceController(insuranceService) {
    var ic = this;
    ic.REButIsClicked = false;
    ic.VButIsClicked = false;
    ic.insuranceBase = 120;

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
    }
  }
})();
