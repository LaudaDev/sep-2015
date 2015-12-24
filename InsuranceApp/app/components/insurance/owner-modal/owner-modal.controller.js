(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('OwnerModalController', OwnerModalController);

  OwnerModalController.$inject = ['$uibModalInstance','owner'];

  function OwnerModalController($uibModalInstance,owner) {
    var imc = this;

    imc.cancel = cancel;
    imc.save = save;
    imc.owner = owner;


    function save(){
      $uibModalInstance.close(imc.owner);
    }

    function cancel() {
      $uibModalInstance.dismiss();
    }

  }
})();
