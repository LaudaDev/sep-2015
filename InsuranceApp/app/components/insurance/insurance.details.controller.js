(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceDetailsController', InsuranceDetailsController);

  InsuranceDetailsController.$inject = ['insuranceService'];

  function InsuranceDetailsController(insuranceService) {
    var idc = this;

    idc.insuranceService = insuranceService;
    idc.objekat = idc.insuranceService.getInsurance();

    console.log(idc.objekat);

    idc.objekat.travel.user = {
      ime: "aleksa",
      prezime: "ratkov"
    };

    idc.insuranceService.setInsurance(idc.objekat);
    console.log("posle ovoga objekat je sledeci");
    console.log(idc.objekat);


  }
})();
