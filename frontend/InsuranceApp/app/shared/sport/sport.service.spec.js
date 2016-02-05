ddescribe("regionService", function() {
	var sportService, $httpBackend;
	var appUrl = "https://localhost:8080/api/merchant/sport";

	beforeEach(module("sport"));

	beforeEach(inject(function(_sportService_, _$httpBackend_){
		sportService = _sportService_;
		$httpBackend = _$httpBackend_;
	}));

	it("should request all employees endpoints", function() {
		//očekujemo da će se izvršiti 1 HTTP GET zahtev na dati URL
		$httpBackend.expectGET(appUrl).respond([]);
		sportService.query();
		$httpBackend.flush();
	});

	//na kraju dodajemo ovaj blok da garantujemo da smo flushovali sve zahteve koje smo formirali,
	//kao i da ne postoje expect izrazi za HTTP zahteve koji nisu okinuti
	afterEach(function() {
		$httpBackend.verifyNoOutstandingRequest();
    	$httpBackend.verifyNoOutstandingExpectation();
	});
});
