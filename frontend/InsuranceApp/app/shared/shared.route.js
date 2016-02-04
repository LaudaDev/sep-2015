(function() {
  "use strict";

  angular
    .module('insurance-app.shared')
    .config(config);

  config.$inject = ['$stateProvider'];

  function config($stateProvider) {
    $stateProvider.state('main.success', {
        url: '/success',
        views: {
          'content@': {
            templateUrl: 'app/shared/redirectPages/success.html',
            controller: 'RedirectController',
            controllerAs: 'rc'
          }
        }
      })
      .state('main.error', {
        url: '/error',
        views: {
          'content@': {
            templateUrl: 'app/shared/redirectPages/error.html',
            controller: 'RedirectController',
            controllerAs: 'rc'
          }
        }
      }).state('main.failed', {
        url: '/failed',
        views: {
          'content@': {
            templateUrl: 'app/shared/redirectPages/failed.html',
            controller: 'RedirectController',
            controllerAs: 'rc'
          }
        }
      });
  }
})();
