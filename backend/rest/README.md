#SEP 2015 - Merchant REST service

REST service for InsuranceApp

Spring Boot & MongoDB

Important methods:

https://localhost:8080/api/merchant/payment

{
    "vehicle" : {
        "duration" : 10,
        "model" : "m3",
        "typeVehicle" : "BMW",
        "owner" : {
            "name" : "Marko",
            "surname" : "Markovic",
            "jmbg" : "1103992710184",
            "phoneNum" : "0645126211",
            "address" : "Cirpanova 12",
            "passportNum" : "987654321"
        },
        "productionYear" : 2011,
        "registrationNumber" : "NS123-HF",
        "vinNumber" : "1213255124555",
        "packageV" : "towing",
        "packageDetail" : 300.0000000000000000
    },
    "realEstate" : {
        "duration" : 10,
        "sizeRE" : 65.0000000000000000,
        "age" : 12.0000000000000000,
        "estimatedValue" : 44000.0000000000000000,
        "owner" : {
            "name" : "Marko",
            "surname" : "Markovic",
            "jmbg" : "1103992710184",
            "phoneNum" : "0645126211",
            "address" : "Cirpanova 12",
            "passportNum" : "987654321"
        },
        "packageRE" : "Fire"
    },
    "amountToPay" : "83.1",
    "travel" : {
        "users" : [ 
            {
                "name" : "Marko Markovic",
                "surname" : "Marko Markovic",
                "jmbg" : "1103992710184",
                "phoneNum" : "0645126211",
                "address" : "Cirpanova 12",
                "passportNum" : "987654321",
                "email" : "marko.markovic@gmail.com"
            }
        ],
        "duration" : 10,
        "region" : "Europe",
        "less" : 1,
        "doesSport" : true,
        "sport" : "basketball",
        "numOfPersons" : 1,
        "insuredAmount" : 20000.0000000000000000
    },
    "carrier" : {
        "name" : "Marko",
        "surname" : "Markovic",
        "jmbg" : "1103992710184",
        "phoneNum" : "0645126211",
        "address" : "Cirpanova 12",
        "passportNum" : "987654321",
        "email" : "marko.markovic@gmail.com"
    }
}


#How to start project

- clone development branch from github
	git clone -b development https://github.com/LaudaDev/sep-merchant-web-app.git
	
- in eclipse import project as existing maven project

- right click on project -> team -> disconnect

- right click on src folder -> build path -> use as source folder

- right click on project -> run as -> maven build and set goals on "clean install"

- run as -> java application (select application and click ok)

- in case of Error: Could not find or load main class app.Application error, go to project -> clean and run again

Run project with InsuranceApp and Acquirer backend and frontend apps (https://github.com/LaudaDev/sep-acquirer-web-app.git)
to test all avaliable methods.
