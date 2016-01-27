(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .factory('insuranceService', insuranceService);

  insuranceService.$inject = [];

  function insuranceService() {
    var insurance = {};
    insurance.vehicle = {};
    insurance.travel = {};
    insurance.travel.users = [];
    insurance.realEstate = {};
    insurance.carrier = {};

    var owners = [];

    var getOwners = function() {
      return owners;
    };

    var setOwners = function(value) {
       owners = value;
    };

    var getInsurance = function() {
      return insurance;
    };

    var setInsurance = function(value) {
      insurance = value;
    };

    var getTravelInsurance = function() {
      return insurance.travel;
    };

    var getInsuranceUsers = function() {
      return insurance.travel.users;
    };

    var getRealEstateInsurance = function() {
      return insurance.realEstate;
    };

		var getVehicleInsurance = function() {
			return insurance.vehicle;
		};

    var getCarrier = function() {
			return insurance.carrier;
		};

    return {
      getInsurance: getInsurance,
      setInsurance: setInsurance,
      getTravelInsurance: getTravelInsurance,
      getInsuranceUsers: getInsuranceUsers,
      getRealEstateInsurance: getRealEstateInsurance,
			getVehicleInsurance : getVehicleInsurance,
      getOwners : getOwners,
      setOwners : setOwners,
      getCarrier : getCarrier

    };
  }
})();
