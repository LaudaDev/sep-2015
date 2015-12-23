(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceModalController', InsuranceModalController);

  InsuranceModalController.$inject = ['$uibModalInstance','user'];

  function InsuranceModalController($uibModalInstance,user) {
    var imc = this;

    imc.cancel = cancel;
    imc.save = save;
    imc.user = user;


    function save(){
      $uibModalInstance.close(imc.user);
    }

    function cancel() {
      $uibModalInstance.dismiss();
    }

  }
})();
