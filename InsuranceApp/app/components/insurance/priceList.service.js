(function() {
  "use strict";

  var priceList = {

    "age": {
      "lessCf": 3,
      "betweenCf": 2,
      "overCf": 1

    },
    "sport": [
      { "name":"kosarka",
        "koeficijent": 5
      },
      { "name":"fudbal",
        "koeficijent": 5
      },
      { "name":"skiajnje",
        "koeficijent": 9
      },
      { "name":"plivanje",
        "koeficijent": 2
      },
      { "name":"boks",
        "koeficijent": 8
      },
      { "name":"tenis",
        "koeficijent": 4
      }
    ],
    "insuredAmount":[
      {
        "price" : "10000",
        "koeficijent" : 2
      },
      {
        "price" : "20000",
        "koeficijent" : 3
      },
      {
        "price" : "30000",
        "koeficijent" : 4
      },
      {
        "price" : "40000",
        "koeficijent" : 5
      }
    ]
  };

  angular
    .module('insurance-app.insurance')
    .constant("priceList", priceList);

})();
