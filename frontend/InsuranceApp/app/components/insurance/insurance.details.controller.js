(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceDetailsController', InsuranceDetailsController);

  InsuranceDetailsController.$inject = ['insuranceService', '$uibModal', 'vehicleModels', 'insuranceResourceService', '$window', '$location', 'calculateService','realEstatePackage'];

  function InsuranceDetailsController(insuranceService, $uibModal, vehicleModels, insuranceResourceService, $window, $location, calculateService,realEstatePackage) {
    var idc = this;

    idc.insuranceService = insuranceService;
    idc.vehicleModels = vehicleModels;
    idc.calculateService = calculateService;
    idc.insurance = idc.insuranceService.getInsurance();
    idc.insurance.travel.users = idc.insuranceService.getInsuranceUsers();
    idc.insurance.realEstate = idc.insuranceService.getRealEstateInsurance();
    idc.insurance.vehicle = idc.insuranceService.getVehicleInsurance();
    idc.openModal = openModal;
    idc.realEstatePackage = realEstatePackage;
    idc.user = {};
    idc.numToInsert = idc.insurance.travel.numOfPersons - idc.insurance.travel.users.length;
    idc.addUser = addUser;
    idc.editSelected = editSelected;
    idc.isEditable = false; //kad je false radi se add,a kad je true onda se radi dodavanje
    idc.addOwnerModal = addOwnerModal;
    idc.users = idc.insuranceService.getOwners();
    idc.areOtherFieldsRequired = areOtherFieldsRequired;
    idc.validateVehicleInsurance = validateVehicleInsurance;
    idc.validateRealEstateInsurance = validateRealEstateInsurance;
    idc.vehicleValid = false;
    idc.realEstateValid = false;
    idc.saveInsurance = saveInsurance;
    idc.calculate = calculate;
    idc.openPreviewModal = openPreviewModal;

    function openPreviewModal() {

      $uibModal.open({
        animation: true,
        resolve: {

          insurance: function() {
            return idc.insurance;
          }
        },
        templateUrl: 'app/components/insurance/bill-modal/bill-modal.html',
        controller: 'BillModalController',
        controllerAs: 'bmc'
      });
    }

    function calculate() {

      idc.calculateService.save({}, idc.insurance, onSuccesCalculation, onError);

    }

    function onError(reason) {
      console.log(reason);
    }

    function onSuccesCalculation(response) {
      console.log("uspesno je odradjen calculate u idc-u");
      idc.insurance = response;
      console.log("ovo je objekat koji cuvam");
      console.log(idc.insurance);
      idc.insuranceService.setInsurance(idc.insurance);
    }

    function saveInsurance() {
      if (idc.vehicleValid && idc.saveInsurance) {
        // console.log(idc.insurance);
        insuranceResourceService.save({}, idc.insurance, onSuccesSave);
        idc.vehicleValid = false;
        idc.realEstateValid = false;
      } else {
        console.log("ne moze da se sacuva nije validno");
      }

    }

    function onSuccesSave() {
      console.log("uspesno je sacuvano pogledaj mongo");
      var emptyInsurance = {};
      idc.insuranceService.setInsurance(emptyInsurance); // kad novi korisnik pokrene aplikaciju da polja budu prazna
      $window.location.href = 'http://localhost:8082';
    }

    //modal za dodavanje korisnika
    function openModal() {
      var uibModalInstance = $uibModal.open({
        animation: true,
        resolve: {

          user: function() {
            return idc.user;
          }
        },
        templateUrl: 'app/components/insurance/insured-modal/insured-modal.html',
        controller: 'InsuranceModalController',
        controllerAs: 'imc'
      });

      return uibModalInstance.result.then(function(user) {
        if (idc.isEditable === false) {

          idc.insurance.travel.users.push(user);
          idc.numToInsert--;
          //za potrebe usera koji su potencijalni vlasnici vozila
          idc.users.push(user);
          idc.insuranceService.setOwners(idc.users);

        }
        idc.user = {};
      });
    }

    // uzima usera koji je selektovan u tabeli kako bi ga editovao
    function editSelected(user) {
      idc.user = user;
      idc.isEditable = true;
    }

    //kako bih mogao koristiti isti modalni dijalog za dodavanje i editovanje
    function addUser() {
      idc.isEditable = false;
    }

    function addOwnerModal() {
      var uibModalInstance = $uibModal.open({
        animation: true,
        resolve: {

          owner: function() {
            return idc.owner;
          }
        },
        templateUrl: 'app/components/insurance/owner-modal/owner-modal.html',
        controller: 'OwnerModalController',
        controllerAs: 'omc'
      });

      return uibModalInstance.result.then(function(owner) {
        console.log("Owner je");

        idc.users.push(owner);
        idc.insurance.vehicle.owner = owner; //idc.users[idc.users.length - 1]; // nzm zasto ne radi...
        idc.insuranceService.setOwners(idc.users);
        console.log(idc.insurance.vehicle.owner);
      });
    }

    function validateVehicleInsurance() {
      if (idc.stateForm.$valid) {
        idc.stateForm.$setUntouched();
        idc.vehicleValid = true;
        console.log("tacanVeh");
      } else {
        touchControllsVehicles();
        console.log("netacanVeh");

      }
    }

    function touchControllsVehicles() {
      //Prođi kroz sve propertie stateForm objekta
      angular.forEach(idc.stateForm, function(value, key) {
        //Pronađi propertie čiji naziv počinje sa "input"
        if (key.indexOf("input") === 0) {
          //"Dodirni" polje
          value.$setTouched();
        }
      });
    }

    function validateRealEstateInsurance() {
      if (idc.stateForm2.$valid) {
        idc.stateForm2.$setUntouched();
        idc.realEstateValid = true;
        console.log("tacanRE");

      } else {
        touchControllsRealEstate();
        console.log("netacanRE");

      }
    }

    function touchControllsRealEstate() {
      //Prođi kroz sve propertie stateForm objekta
      angular.forEach(idc.stateForm2, function(value, key) {
        //Pronađi propertie čiji naziv počinje sa "input"
        if (key.indexOf("input") === 0) {
          //"Dodirni" polje
          value.$setTouched();
        }
      });
    }

    function areOtherFieldsRequired(text) {
      if (text === 'vehicle') {
        return (idc.insurance.vehicle.duration || idc.insurance.vehicle.typeVehicle || idc.insurance.vehicle.model || idc.insurance.vehicle.productionYear || idc.insurance.vehicle.registrationNumber || idc.insurance.vehicle.vinNumber || idc.insurance.vehicle.owner);
      } else {
        return (idc.insurance.realEstate.duration || idc.insurance.realEstate.sizeRE || idc.insurance.realEstate.age || idc.insurance.realEstate.estimatedValue || idc.insurance.realEstate.packageRE || idc.insurance.realEstate.owner);
      }
    }
  }
})();
