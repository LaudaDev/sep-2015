(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .config(config);

  config.$inject = ['$stateProvider'];

  function config($stateProvider) {

    $stateProvider
      .state('main.insurance', {
        url: '/insurance',
        views: {
          'content@': {

            templateUrl: 'app/components/insurance/insuranceForm.html',
            controller: 'InsuranceController',
            controllerAs: 'ic'
          }
        }
      });
  }
})();
