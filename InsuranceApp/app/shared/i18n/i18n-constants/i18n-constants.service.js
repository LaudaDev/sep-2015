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
				"PART3" : "Vehicle insurance"
			},
			"FEATURETTES":{
				"PART1" : "First insurance is Travel insurance.",
				"PART1_1" : "It'll blow your mind.",
				"PART2" : "Oh yeah, it's that good.Second one is Real Estate insurance.",
				"PART2_2" : "See for yourself.",
				"PART3" : "And lastly, this one. Vehicle insurance!",
				"PART3_3" : "Checkmate!"
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
				"PART3" : "Osiguranje Vozila"
			},
			"FEATURETTES":{
				"PART1" : "Prvo osiguranje koje nudimo je putničko.",
				"PART1_1" : "Oduševiće vas skroz.",
				"PART2" : "Ako ste mislili da je to sve varate se. Nudimo vam i osiguranje nekretnina.",
				"PART2_2" : "Razmislite o ovome.",
				"PART3" : "I za kraj,ali ne i manje bitno. Osiguranje vozila!",
				"PART3_3" : "Sve što vam je potrebno!"
			}

		},
	};

	angular
		.module('insurance-app.i18n.constants')
		.constant("crTranslations", crTranslations);
})();
