ddescribe("regionService", function() {
	var regionService, $httpBackend;
	var appUrl = "https://localhost:8080/api/merchant/region";

	beforeEach(module("region"));

	beforeEach(inject(function(_regionService_, _$httpBackend_){
		regionService = _regionService_;
		$httpBackend = _$httpBackend_;
	}));

	it("should request all employees endpoints", function() {
		//očekujemo da će se izvršiti 1 HTTP GET zahtev na dati URL
		$httpBackend.expectGET(appUrl).respond([]);
		regionService.query();
		$httpBackend.flush();
	});

	it("should add region", function() {
 // 	//ako i kad se izvrši HTTP get zahtev na dati URL definišemo odgovor da bude [{jmbg:'1'}, {jmbg:'2'}]
	 $httpBackend.whenGET(appUrl).respond([{id:'1'}, {id:'2'}])
	 var regiones = regionService.query(); //bitno je staviti whenGET iznad
	 $httpBackend.flush();
	 var numberOfRegionBefore = regiones.length;
	 console.log(regiones.length);

	 //očekujemo da će se izvršiti HTTP post zatev na dati URL
	 $httpBackend.expectPOST(appUrl).respond(200,{id: '2'});
	 regionService.save(new regionService());
	 $httpBackend.flush();

	 //da bi shvatili zašto se promena desila potrebno je pogledati implementaciju saveEmployee metode u employee.service.js
	 expect(regiones.length).toBe(numberOfRegionBefore + 1);
 });

	//na kraju dodajemo ovaj blok da garantujemo da smo flushovali sve zahteve koje smo formirali,
	//kao i da ne postoje expect izrazi za HTTP zahteve koji nisu okinuti
	afterEach(function() {
		$httpBackend.verifyNoOutstandingRequest();
    	$httpBackend.verifyNoOutstandingExpectation();
	});
});
