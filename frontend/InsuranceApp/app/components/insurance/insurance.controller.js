(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceController', InsuranceController);

  InsuranceController.$inject = ['$uibModal', 'priceList', 'insuranceService', '$state', 'regions', 'sports', 'amounts'];

  function InsuranceController($uibModal, priceList, insuranceService, $state, regions, sports, amounts) {
    var ic = this;

    ic.insuranceService = insuranceService;
    ic.regions = regions;
    ic.sports = sports;
    ic.amounts = amounts;
    ic.priceList = priceList;
    ic.insurance = ic.insuranceService.getInsurance();
    ic.insurance.travel = ic.insuranceService.getTravelInsurance();
    ic.calculate = calculate;
    ic.validateInsurance = validateInsurance;
    ic.isOneFieldRequired = isOneFieldRequired;
    ic.setObject = setObject;

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

      if (ic.insurance.travel.less !== null) {
        ic.insurance.travel.numOfPersons += ic.insurance.travel.less;
      }

      if (ic.insurance.travel.between !== null) {
        ic.insurance.travel.numOfPersons += ic.insurance.travel.between;
      }

      if (ic.insurance.travel.over !== null) {
        ic.insurance.travel.numOfPersons += ic.insurance.travel.over;
      }

      //calculate();
      ic.insuranceService.setInsurance(ic.insurance);
    }

    function calculate() {

      //TODO odraditi na serverskoj strani racunanje cene 

      ic.insurance.amountToPay = ic.insurance.travel.duration + (ic.insurance.travel.region + '').length;

      if (ic.insurance.travel.less !== null) {
        ic.insurance.amountToPay += ic.priceList.age.lessCf * ic.insurance.travel.less;
      }

      if (ic.insurance.travel.between !== null) {
        ic.insurance.amountToPay += ic.priceList.age.betweenCf * ic.insurance.travel.between;
      }

      if (ic.insurance.travel.over !== null) {
        ic.insurance.amountToPay += ic.priceList.age.overCf * ic.insurance.travel.over;
      }

      if (ic.insurance.travel.sport !== null && ic.insurance.travel.doesSport !== false) {

        for (var i = 0; i < ic.priceList.sport.length; i++) {
          if (ic.priceList.sport[i].name === ic.insurance.travel.sport) {
            ic.insurance.amountToPay += ic.priceList.sport[i].koeficijent;
          }
        }

      }

      if (ic.insurance.travel.insuredAmount) {
        for (var j = 0; j < ic.priceList.insuredAmount.length; j++) {
          if (ic.priceList.insuredAmount[j].price === ic.insurance.travel.insuredAmount) {
            ic.insurance.amountToPay += ic.priceList.insuredAmount[j].koeficijent;
          }
        }
      }



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
