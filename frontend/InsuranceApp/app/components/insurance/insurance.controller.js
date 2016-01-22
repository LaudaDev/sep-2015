(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceController', InsuranceController);

  InsuranceController.$inject = ['$uibModal', 'priceList', 'insuranceService', '$state', 'regions', 'sports', 'amounts', 'calculateService'];

  function InsuranceController($uibModal, priceList, insuranceService, $state, regions, sports, amounts, calculateService) {
    var ic = this;

    ic.insuranceService = insuranceService;
    ic.regions = regions;
    ic.sports = sports;
    ic.amounts = amounts;
    ic.calculateService = calculateService;
    ic.priceList = priceList;
    ic.insurance = ic.insuranceService.getInsurance();
    ic.insurance.travel = ic.insuranceService.getTravelInsurance();
    ic.calculate = calculate;
    ic.validateInsurance = validateInsurance;
    ic.isOneFieldRequired = isOneFieldRequired;
    ic.setObject = setObject;

    console.log(ic.insurance);

    function openModal() {

      $uibModal.open({
        animation: true,
        resolve: {

          insurance: function() {
            return ic.insurance;
          }
        },
        templateUrl: 'app/components/insurance/bill-modal/bill-modal.html',
        controller: 'BillModalController',
        controllerAs: 'bmc'
      });
    }

    function setObject() {

      ic.insurance.travel.numOfPersons = 0;

      if (ic.insurance.travel.less !== undefined) {
        ic.insurance.travel.numOfPersons += ic.insurance.travel.less;
      }

      if (ic.insurance.travel.between !== undefined) {
        ic.insurance.travel.numOfPersons += ic.insurance.travel.between;
      }

      if (ic.insurance.travel.over !== undefined) {
        ic.insurance.travel.numOfPersons += ic.insurance.travel.over;
      }
    
      ic.insuranceService.setInsurance(ic.insurance);
    }

    function calculate() {

      ic.calculateService.save({}, ic.insurance, onSuccesCalculation, onError);

    }

    function onError(reason) {
      console.log(reason);
    }

    function onSuccesCalculation(response) {
      console.log(response);
      console.log("uspesno je odradjen calculate");
      ic.insurance = response;
      ic.validateInsurance('preview');
    }

    function validateInsurance(text) {
      if (ic.stateForm.$valid) {
        ic.stateForm.$setUntouched();
        if (text === 'preview') { //otvori samo modal
          openModal();
        } else {
          setObject();
          $state.go('main.insuranceDetails'); // prebaci se na sledecu stranu i pre toga sacuvaj objekat
        }

      } else {
        touchControlls();
      }
    }

    function touchControlls() {
      //Prođi kroz sve propertie stateForm objekta
      angular.forEach(ic.stateForm, function(value, key) {
        //Pronađi propertie čiji naziv počinje sa "input"
        if (key.indexOf("input") === 0) {
          //"Dodirni" polje
          value.$setTouched();
        }
      });
    }

    function isOneFieldRequired() {
      return !(ic.insurance.travel.less || ic.insurance.travel.between || ic.insurance.travel.over);
    }
  }
})();
