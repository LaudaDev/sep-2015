(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .config(config);

  config.$inject = ['$stateProvider'];

  function config($stateProvider) {
    $stateProvider.state('main.insuranceBasic', {
        url: '/insurance',
        views: {
          'content@': {
            resolve: {

              regions: getRegions,
              sports: getSports,
              amounts: getAmounts

            },
            templateUrl: 'app/components/insurance/insuranceBasic.html',
            controller: 'InsuranceController',
            controllerAs: 'ic'
          }
        }
      })
      .state('main.insuranceDetails', {
        url: '/insuranceDetails',
        views: {
          'content@': {
            resolve: {

              realEstatePackage: getRealEstatePackage
            },
            templateUrl: 'app/components/insurance/insuranceDetails.html',
            controller: 'InsuranceDetailsController',
            controllerAs: 'idc'
          }
        }
      });

    getRegions.$inject = ['regionService'];

    function getRegions(regionService) {
      return regionService.query().$promise;
    }

    getSports.$inject = ['sportService'];

    function getSports(sportService) {
      return sportService.query().$promise;
    }

    getAmounts.$inject = ['insuredAmountService'];

    function getAmounts(insuredAmountService) {
      return insuredAmountService.query().$promise;
    }

		getRealEstatePackage.$inject = ['realEstatePackageService'];

    function getRealEstatePackage(realEstatePackageService) {
      return realEstatePackageService.query().$promise;
    }
  }
})();
