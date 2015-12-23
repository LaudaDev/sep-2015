(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceDetailsController', InsuranceDetailsController);

  InsuranceDetailsController.$inject = ['insuranceService', '$uibModal'];

  function InsuranceDetailsController(insuranceService, $uibModal) {
    var idc = this;

    idc.insuranceService = insuranceService;
    idc.insurance = idc.insuranceService.getInsurance();
    idc.insurance.travel.users = [];
    idc.openModal = openModal;
    idc.user = {};
    idc.numToInsert = idc.insurance.travel.numOfPersons;
    idc.addUser = addUser;
    idc.editSelected = editSelected;
    idc.isEditable = false; //kad je false radi se add,a kad je true onda se radi dodavanje

    //modal za dodavanje korisnika
    function openModal() {
      var modalInstance = $uibModal.open({
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

      return modalInstance.result.then(function(user) {
        if (idc.isEditable === false) {

          idc.insurance.travel.users.push(user);
          idc.numToInsert--;

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

    console.log(idc.insurance);
  }
})();
