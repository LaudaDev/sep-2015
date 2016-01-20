(function() {
  angular
    .module('insurance-app.shared')
    .directive('uniqueJmbg', uniqueJmbg);

  uniqueJmbg.$inject = ['$q', 'jmbgService', '$timeout'];

  function uniqueJmbg($q, jmbgService, $timeout) {
    var uniqueJmbgDirective = {
      restrict: 'A',
      //ngModel nam je potreban da koristimo infrastrukturu forme za prikaz greške, a busyIndicator ćemo koristiti da prikažemo loading gif dok se učitava
      require: ['ngModel', '?^busyIndicator'],
      link: function(scope, elem, attrs, ctrls) {
        //uzimamo kontrolere
        var ngModelCtrl = ctrls[0];
        var busyIndicatorCtrl = ctrls[1];

        //pristupamo asinhronimValidatorima (koji se poslednji izvršavaju) i postavljamo uniqueJmbg funkciju koja je naša validaciona funkcija i prihvata vrednost iz modela
        ngModelCtrl.$asyncValidators.uniqueJmbg = function(value) {

          return jmbgService.get({jmbg : value})
            .$promise
            .then(function(response) {
              console.log(response);
              return $timeout(function() {
                if (response.result === false) {
                  return $q.reject('exists');
                }else{
									return true;
								}
              }, 500);
              //Ako radnik ne postoji (error funkcija) znači da je validan JMBG i vraćamo true
            });
        };

        //ukoliko postoji busyIndicator direktiva na nekom parent elementu posmatramo atribut $pending ngModel kontrolera
        //ako se izvršava provera (jeste $pending) onda prikaži indikator, u suprotnom ga sakri (ove metode su definisane u busyIndicator direktivi)
        if (busyIndicatorCtrl) {
          scope.$watch(function() {
            return ngModelCtrl.$pending;
          }, function(newValue) {
            if (newValue) busyIndicatorCtrl.show();
            else busyIndicatorCtrl.hide();
          });
        }
      }
    }
    return uniqueJmbgDirective;
  }
})();
