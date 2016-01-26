db.createCollection("sport");
db.createCollection("region");
db.createCollection("realestateInsPackage");
db.createCollection("insuredAmount");


db.sport.insert({
  "name": "football",
  "coefficient": 5
});
db.sport.insert({
  "name": "basketball",
  "coefficient": 5
});
db.sport.insert({
  "name": "skiing",
  "coefficient": 9
});
db.sport.insert({
  "name": "boxing",
  "coefficient": 9
});
db.sport.insert({
  "name": "swimming",
  "coefficient": 3
});
db.sport.insert({
  "name": "tennis",
  "coefficient": 4
});

db.region.insert({

  "name": "Africa",
  "coefficient": 4
});

db.region.insert({

  "name": "Europe",
  "coefficient": 3
});

db.region.insert({

  "name": "North America",
  "coefficient": 5
});

db.region.insert({


  "name": "South America",
  "coefficient": 6

});

db.region.insert({


  "name": "Australia",
  "coefficient": 7
});

db.region.insert({

  "name": "Asia",
  "coefficient": 6
});

db.region.insert({
  "name": "Antarctic",
  "coefficient": 6

});


db.realestateInsPackage.insert({
  "name": "Flood",
  "coefficient": 4
});

db.realestateInsPackage.insert({
    "name" : "Fire",
    "coefficient" : 6
});

db.realestateInsPackage.insert({
  "name": "Burglary",
  "coefficient": 7
});

db.realestateInsPackage.insert({
  "name": "Earthquake",
  "coefficient": 6
});

db.insuredAmount.insert({
    "amount" : 10000,
    "coefficient" : 2
});

db.insuredAmount.insert({
    "amount" : 20000,
    "coefficient" : 3
});

db.insuredAmount.insert({

    "amount" : 30000,
    "coefficient" : 4
});

db.insuredAmount.insert({

    "amount" : 40000,
    "coefficient" : 5
});

db.insuredAmount.insert({

    "amount" : 50000,
    "coefficient" : 6
});
