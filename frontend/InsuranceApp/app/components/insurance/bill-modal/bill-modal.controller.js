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
    bmc.finalPrice = bmc.insurance.amountToPay;
    bmc.currentLocale = currentLocale;


    function currentLocale() {
      if ($translate.use() === 'sr-latn') {
        bmc.finalPrice *= 112.69;
      }
    }

    function cancel() {
      $uibModalInstance.close();
    }
  }
})();
