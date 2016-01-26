(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('BillModalController', BillModalController);

  BillModalController.$inject = ['$uibModalInstance', 'insurance', '$translate'];

  function BillModalController($uibModalInstance, insurance, $translate) {
    var bmc = this;

    bmc.cancel = cancel;
    bmc.insurance = insurance;
    console.log(bmc.insurance);
    bmc.currentLocale = currentLocale;


    function currentLocale() {
      if ($translate.use() === 'sr-latn') {
        bmc.insurance.amountToPay *= 112.69;
      }
    }

    function cancel() {
      $uibModalInstance.close();
    }
  }
})();
