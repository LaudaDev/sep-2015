(function() {
  "use strict";

  angular
    .module('insurance-app.insurance')
    .controller('InsuranceController', InsuranceController);

  InsuranceController.$inject = ['$uibModal', 'priceList','insuranceService'];

  function InsuranceController($uibModal, priceList,insuranceService) {
    var ic = this;

    ic.priceList = priceList;
    ic.insurance = {};
    ic.insurance.travel = {};
    ic.calculate = calculate;

    ic.insuranceService = insuranceService;
    ic.insuranceService.setInsurance(ic.insurance);


    ic.insurance.travel.region = undefined;
    ic.states = ["Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Anguilla", "Albania", "Armenia", "Angola", "Antarctica", "Argentina", "American Samoa", "Austria", "Australia", "Aruba", "Åland", "Azerbaijan", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin", "Saint Barthélemy", "Bermuda", "Brunei", "Bolivia", "Bonaire", "Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize", "Canada", "Cocos [Keeling] Islands", "Congo", "Central African Republic", "Republic of the Congo", "Switzerland", "Ivory Coast", "Cook Islands", "Chile", "Cameroon", "China", "Colombia", "Costa Rica", "Cuba", "Cape Verde", "Curacao", "Christmas Island", "Cyprus", "Czechia", "Germany", "Djibouti", "Denmark", "Dominica", "Dominican Republic", "Algeria", "Ecuador", "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain", "Ethiopia", "Finland", "Fiji", "Falkland Islands", "Micronesia", "Faroe Islands", "France", "Gabon", "United Kingdom", "Grenada", "Georgia", "French Guiana", "Guernsey", "Ghana", "Gibraltar", "Greenland", "Gambia", "Guinea", "Guadeloupe", "Equatorial Guinea", "Greece", "South Georgia and the South Sandwich Islands", "Guatemala", "Guam", "Guinea-Bissau", "Guyana", "Hong Kong", "Heard Island and McDonald Islands", "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "Ireland", "Israel", "Isle of Man", "India", "British Indian Ocean Territory", "Iraq", "Iran", "Iceland", "Italy", "Jersey", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati", "Comoros", "Saint Kitts and Nevis", "North Korea", "South Korea", "Kuwait", "Cayman Islands", "Kazakhstan", "Laos", "Lebanon", "Saint Lucia", "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania", "Luxembourg", "Latvia", "Libya", "Morocco", "Monaco", "Moldova", "Montenegro", "Saint Martin", "Madagascar", "Marshall Islands", "Macedonia", "Mali", "Myanmar [Burma]", "Mongolia", "Macao", "Northern Mariana Islands", "Martinique", "Mauritania", "Montserrat", "Malta", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique", "Namibia", "New Caledonia", "Niger", "Norfolk Island", "Nigeria", "Nicaragua", "Netherlands", "Norway", "Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama", "Peru", "French Polynesia", "Papua New Guinea", "Philippines", "Pakistan", "Poland", "Saint Pierre and Miquelon", "Pitcairn Islands", "Puerto Rico", "Palestine", "Portugal", "Palau", "Paraguay", "Qatar", "Réunion", "Romania", "Serbia", "Russia", "Rwanda", "Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena", "Slovenia", "Svalbard and Jan Mayen", "Slovakia", "Sierra Leone", "San Marino", "Senegal", "Somalia", "Suriname", "South Sudan", "São Tomé and Príncipe", "El Salvador", "Sint Maarten", "Syria", "Swaziland", "Turks and Caicos Islands", "Chad", "French Southern Territories", "Togo", "Thailand", "Tajikistan", "Tokelau", "East Timor", "Turkmenistan", "Tunisia", "Tonga", "Turkey", "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania", "Ukraine", "Uganda", "U.S. Minor Outlying Islands", "United States", "Uruguay", "Uzbekistan", "Vatican City", "Saint Vincent and the Grenadines", "Venezuela", "British Virgin Islands", "U.S. Virgin Islands", "Vietnam", "Vanuatu", "Wallis and Futuna", "Samoa", "Kosovo", "Yemen", "Mayotte", "South Africa", "Zambia", "Zimbabwe"];

    ic.openModal = openModal;
    ic.setObject = setObject;

    function openModal() {

      $uibModal.open({
        animation: true,
        resolve: {

          insurance: function() {
            return ic.insurance.travel;
          }
        },
        templateUrl: 'app/components/insurance/bill-modal/bill-modal.html',
        controller: 'BillModalController',
        controllerAs: 'bmc'
      });
    }

    function setObject(){

        ic.insuranceService.setInsurance(ic.insurance);
        ic.insurance.travel.numOfPersons = 0;

        if (ic.insurance.travel.less != null) {
          ic.insurance.travel.numOfPersons += ic.insurance.travel.less;
        }

        if (ic.insurance.travel.between != null) {
          ic.insurance.travel.numOfPersons += ic.insurance.travel.between;
        }

        if (ic.insurance.travel.over != null) {
          ic.insurance.travel.numOfPersons += ic.insurance.travel.over;
        }
    }

    function calculate() {

      ic.insurance.travel.amountToPay = ic.insurance.travel.duration + (ic.insurance.travel.region + '').length;

      if (ic.insurance.travel.less != null) {
        ic.insurance.travel.amountToPay += ic.priceList.age.lessCf * ic.insurance.travel.less;
      }

      if (ic.insurance.travel.between != null) {
        ic.insurance.travel.amountToPay += ic.priceList.age.betweenCf * ic.insurance.travel.between;
      }

      if (ic.insurance.travel.over != null) {
        ic.insurance.travel.amountToPay += ic.priceList.age.overCf * ic.insurance.travel.over;
      }

      if (ic.insurance.travel.sport != null) {

        for (var i = 0; i < ic.priceList.sport.length; i++) {
          if (ic.priceList.sport[i].name === ic.insurance.travel.sport) {
            ic.insurance.travel.amountToPay += ic.priceList.sport[i].koeficijent;
          }
        }

      }

      if (ic.insurance.travel.insuredAmount) {

        for (var i = 0; i < ic.priceList.insuredAmount.length; i++) {
          if (ic.priceList.insuredAmount[i].price === ic.insurance.travel.insuredAmount) {
            ic.insurance.travel.amountToPay += ic.priceList.insuredAmount[i].koeficijent;
          }
        }
      }

    }


  }
})();
