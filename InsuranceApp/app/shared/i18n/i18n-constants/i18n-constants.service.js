(function() {
	"use strict";

	var crTranslations = {
		"en": {
			"COMMON": {
				"SAVE":"Save",
				"REVERT":"Revert",
				"DELETE":"Delete",
				"BACK":"Back",
				"VIEW_DETAILS" : "View details"
			},

			"NAVBAR": {
				"TEAM":"Team18 - Insurance",
				"HOME":"Home",
				"ABOUT_US":"About us",
				"LANGUAGE":"Language",
				"ENGLISH":"English",
				"SERBIAN":"Serbian"
			},
			"CAROUSEL":{
				"SLIDE1" : "Our insurance company provides you several types of insurances",
				"SLIDE2" : "Your family is always on the first place!",
				"SLIDE3" : "Travel insurance. Good thing to have when you travel a lot. Be safe don't think",
				"SLIDE4" : "Real Estate insurance. Be safe from floods,fires and natural disasters",
				"SLIDE5" : "Vehicle insurance. Insure your car and have road asistance 00-24"

			},
			"MARKETING":{
				"PART1" : "Travel Insurance",
				"PART2" : "Real Estate insurance",
				"PART3" : "Vehicle insurance",
				"DETAIL" : {
					"PART1" : "",
					"PART2" : "",
					"PART3" : "",
				}
			}

		},
		"sr-latn": {
			"COMMON": {
				"SAVE":"Sačuvaj",
				"REVERT":"Poništi",
				"DELETE":"Obriši",
				"BACK":"Povratak",
				"VIEW_DETAILS" : "Više detalja"
			},

			"NAVBAR": {
				"TEAM":"Tim18 - Osiguranje",
				"HOME":"Početna",
				"ABOUT_US":"O nama",
				"LANGUAGE":"Jezik",
				"ENGLISH":"Engleski",
				"SERBIAN":"Srpski"
			},
			"CAROUSEL":{
				"SLIDE1" : "Naša kompanija vam nudi nekoliko osnovnih tipova osiguranja",
				"SLIDE2" : "Vaša porodica je uvek na prvom mestu!",
				"SLIDE3" : "Putno osiguranje. Stvar koju želite da imate ako putujete. Osiguraj se,ne razmišljaj",
				"SLIDE4" : "Osiguranje nekretnina. Osigurajte se od poplava,požara i ostalih prirodnih katastrofa",
				"SLIDE5" : "Osiguranje vozila. Osigurajte svoj auto i imajte pomoc na putu 00-24 "

			},
			"MARKETING":{
				"PART1" : "Putno Osiguranje",
				"PART2" : "Osiguranje Nekretnina",
				"PART3" : "Osiguranje Vozila",
				"DETAIL" : {
					"PART1" : "",
					"PART2" : "",
					"PART3" : "",
				}
			}

		},
	};

	angular
		.module('insurance-app.i18n.constants')
		.constant("crTranslations", crTranslations);
})();
