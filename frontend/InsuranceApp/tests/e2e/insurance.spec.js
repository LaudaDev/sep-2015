xdescribe("Testing home page and insurance basic info page", function(){
	beforeEach(function(){
		browser.get("");
	});

	it("Check if home page is loaded", function(){
		expect(browser.getTitle()).toBe("InsuranceApp");
		expect(browser.getCurrentUrl()).toContain("home");
		browser.sleep(2000);
	});

	it("Go to insurance basic info page", function(){
		var purchase = element(by.linkText("Purchase Insurance"));
		purchase.click();
		expect(browser.getCurrentUrl()).toContain("/#/insurance");
		browser.sleep(2000);
	});
});

xdescribe("Testing insurance basic info form", function(){
	var InsuranceBasicForm = function(){
		this.days = element(by.model("ic.insurance.travel.duration"));
		this.less = element(by.model("ic.insurance.travel.less"));
		this.between = element(by.model("ic.insurance.travel.between"));
		this.over = element(by.model("ic.insurance.travel.over"));
		this.regions = element(by.model('ic.insurance.travel.region')).all(by.tagName('option'));
		this.amount = element(by.model('ic.insurance.travel.insuredAmount')).all(by.tagName('option'));
		this.doesSport = element(by.model("ic.insurance.travel.doesSport"));
	};

	var browserPause = 1000;
	beforeEach(function(){
		browser.get("/#/insurance");
	});

	it("Check insurance basic info form", function(){
		browser.sleep(browserPause);
		var basicForm = new InsuranceBasicForm();

		basicForm.days.sendKeys("5");
		browser.sleep(browserPause);

		basicForm.regions.get(3).click();
		browser.sleep(browserPause);

		basicForm.less.sendKeys("1");
		browser.sleep(browserPause);

		basicForm.between.sendKeys("3");
		browser.sleep(browserPause);

		basicForm.amount.get(4).click();
		browser.sleep(browserPause);

		var sportSelectDiv = element(by.id("sportSelectDiv"));
		expect(sportSelectDiv.getAttribute("class")).toContain("ng-hide");

		var purchase = element(by.buttonText("Prewiew"));
		purchase.click();
		browser.sleep(browserPause * 2);

		var price = element(by.id("priceLabel")).getText();
		expect(price).toBe("$28.00");

		var back = element(by.id("back"));
		back.click();
		browser.sleep(browserPause * 2);

		var menu  = element(by.id("langDropDown"))
		browser.actions().mouseMove(menu).perform();
		browser.sleep(browserPause * 2);
		var serbianLanguage = element(by.id("serbianLanguage"));
		serbianLanguage.click();
		browser.sleep(browserPause * 2);

		purchase = element(by.buttonText("Pregled"));
		purchase.click();
		browser.sleep(browserPause * 2);

		price = element(by.id("priceLabel")).getText();
		expect(price).toBe("3.155,32 din");

	});

	it("Check if select for sport is visible when checkbox is checked", function(){
		browser.sleep(browserPause * 2);

		var basicForm = new InsuranceBasicForm();
		basicForm.doesSport.click();

		var sportSelectDiv = element(by.id("sportSelectDiv"));
		expect(sportSelectDiv.getAttribute("class")).not.toContain("ng-hide");

		browser.sleep(browserPause * 2);

	});
});

xdescribe("Testing adding persons details", function(){
	var InsuranceBasicForm = function(){
		this.days = element(by.model("ic.insurance.travel.duration"));
		this.less = element(by.model("ic.insurance.travel.less"));
		this.between = element(by.model("ic.insurance.travel.between"));
		this.over = element(by.model("ic.insurance.travel.over"));
		this.regions = element(by.model('ic.insurance.travel.region')).all(by.tagName('option'));
		this.amount = element(by.model('ic.insurance.travel.insuredAmount')).all(by.tagName('option'));
		this.doesSport = element(by.model("ic.insurance.travel.doesSport"));
	};

	var AddInsuredForm = function(){
		this.name = element(by.model("imc.user.name"));
		this.surname = element(by.model("imc.user.surname"));
		this.jmbg = element(by.model("imc.user.jmbg"));
		this.passport = element(by.model("imc.user.passportNum"));
		this.address = element(by.model("imc.user.address"));
		this.phone = element(by.model("imc.user.phoneNum"));
	};

	beforeEach(function(){
		browser.driver.manage().window().setSize(1280, 800);
		browser.get("/#/insurance");
	});

	var browserPause = 500;

	it("Check persons details form", function(){
		var basicForm = new InsuranceBasicForm();

		basicForm.days.sendKeys("7");
		basicForm.regions.get(2).click();
		basicForm.between.sendKeys("2");
		basicForm.amount.get(4).click();

		var next = element(by.buttonText("Next"));
		next.click();

		expect(browser.getCurrentUrl()).toContain("insuranceDetails");
		var addInsured = element(by.id("addInsured"));
		expect(addInsured.getAttribute("disabled")).toEqual(null);
		var addCarrier = element(by.id("addCarrier"));
		expect(addCarrier.getAttribute("disabled")).toEqual("true");

		addInsured.click();
		browser.sleep(browserPause);

		var addInsured1 = new AddInsuredForm();
		addInsured1.name.sendKeys("Pera");
		browser.sleep(browserPause);
		addInsured1.surname.sendKeys("Peric");
		browser.sleep(browserPause);
		addInsured1.jmbg.sendKeys("0306992180740");
		browser.sleep(browserPause);
		addInsured1.passport.sendKeys("123456789");
		browser.sleep(browserPause);
		addInsured1.address.sendKeys("Perina adresa");
		browser.sleep(browserPause);
		addInsured1.phone.sendKeys("065336663");
		browser.sleep(browserPause);

		var saveInsured = element(by.id("saveInsured"));
		saveInsured.click();

		expect(addInsured.getAttribute("disabled")).toEqual(null);
		expect(addCarrier.getAttribute("disabled")).toEqual("true");
		browser.sleep(browserPause * 3);

		addInsured.click();

		var addInsured2 = new AddInsuredForm();
		addInsured1.name.sendKeys("Zika");
		browser.sleep(browserPause);
		addInsured1.surname.sendKeys("Zikic");
		browser.sleep(browserPause);
		addInsured1.jmbg.sendKeys("0306992180783");
		browser.sleep(browserPause);
		addInsured1.passport.sendKeys("987654321");
		browser.sleep(browserPause);
		addInsured1.address.sendKeys("Zikina adresa");
		browser.sleep(browserPause);
		addInsured1.phone.sendKeys("065222000");
		browser.sleep(browserPause);

		saveInsured.click();
		expect(addInsured.getAttribute("disabled")).toEqual("true");
		expect(addCarrier.getAttribute("disabled")).toEqual(null);
		browser.sleep(browserPause * 3);
	});


});

describe("Test for project demo - SUCCESS", function(){
	var InsuranceBasicForm = function(){
		this.days = element(by.model("ic.insurance.travel.duration"));
		this.less = element(by.model("ic.insurance.travel.less"));
		this.between = element(by.model("ic.insurance.travel.between"));
		this.over = element(by.model("ic.insurance.travel.over"));
		this.regions = element(by.model("ic.insurance.travel.region")).all(by.tagName("option"));
		this.amount = element(by.model("ic.insurance.travel.insuredAmount")).all(by.tagName("option"));
		this.doesSport = element(by.model("ic.insurance.travel.doesSport"));
		this.sports = element(by.model("ic.insurance.travel.sport")).all(by.tagName("option"));
	};

	var AddInsuredForm = function(){
		this.name = element(by.model("imc.user.name"));
		this.surname = element(by.model("imc.user.surname"));
		this.jmbg = element(by.model("imc.user.jmbg"));
		this.passport = element(by.model("imc.user.passportNum"));
		this.address = element(by.model("imc.user.address"));
		this.phone = element(by.model("imc.user.phoneNum"));
	};

	var AddCarrierForm = function(){
		this.carrier = element(by.model("cmc.carrier")).all(by.tagName("option"));
		this.email = element(by.model("cmc.carrier.email"));
	};

	var CreditCardForm = function(){
		this.visa = element(by.id("visa"));
		this.number = element(by.model("pc.payment.cardNumber"));
		this.code = element(by.model("pc.payment.securityCode"));
		this.expirationMonth = element(by.model("pc.payment.expirationMonth"));
		this.expirationYear = element(by.model("pc.payment.expirationYear"));
		this.holderName = element(by.model("pc.payment.cardholderName"));
		this.holderSurname = element(by.model("pc.payment.cardholderSurname"));
	};

	var VehicleForm = function(){
		this.duration = element(by.model("idc.insurance.vehicle.duration"));
		this.towing = element(by.id("towing"));
		this.kilometers = element(by.model("idc.insurance.vehicle.packageDetail"));
		this.type = element(by.model("idc.insurance.vehicle.typeVehicle"));
		this.model = element(by.model("idc.insurance.vehicle.model"));
		this.year = element(by.model("idc.insurance.vehicle.productionYear"));
		this.registration = element(by.model("idc.insurance.vehicle.registrationNumber"));
		this.vin = element(by.model("idc.insurance.vehicle.vinNumber"));
		this.owner = element(by.model("idc.insurance.vehicle.owner")).all(by.tagName("option"));
	};

	beforeEach(function(){
		browser.driver.manage().window().maximize();
		browser.get("/#/insurance");
	});

	var browserPause = 1000;

	it("Default data entering in forms", function(){
		var basicForm = new InsuranceBasicForm();

		basicForm.days.sendKeys("10");
		browser.sleep(browserPause);
		basicForm.regions.get(2).click();
		browser.sleep(browserPause);
		basicForm.between.sendKeys("1");
		browser.sleep(browserPause);
		basicForm.over.sendKeys("1");
		browser.sleep(browserPause);
		basicForm.doesSport.click();
		browser.sleep(browserPause);
		basicForm.sports.get(3).click();
		browser.sleep(browserPause);
		basicForm.amount.get(4).click();
		browser.sleep(browserPause * 2);

		var purchase = element(by.buttonText("Prewiew"));
		purchase.click();
		browser.sleep(browserPause * 2);

		var back = element(by.id("back"));
		back.click();
		browser.sleep(browserPause * 2);

		var next = element(by.buttonText("Next"));
		next.click();

		expect(browser.getCurrentUrl()).toContain("insuranceDetails");
		var addInsured = element(by.id("addInsured"));
		addInsured.click();
		browser.sleep(browserPause);

		var addInsured1 = new AddInsuredForm();
		addInsured1.name.sendKeys("Zika");
		browser.sleep(browserPause);
		addInsured1.surname.sendKeys("Zikic");
		browser.sleep(browserPause);
		addInsured1.jmbg.sendKeys("0306992180740");
		browser.sleep(browserPause);
		addInsured1.passport.sendKeys("123456789");
		browser.sleep(browserPause);
		addInsured1.address.sendKeys("Zikina adresa");
		browser.sleep(browserPause);
		addInsured1.phone.sendKeys("0653366633");
		browser.sleep(browserPause);

		var saveInsured = element(by.id("saveInsured"));
		saveInsured.click();
		browser.sleep(browserPause * 2);
		addInsured.click();
		browser.sleep(browserPause);

		var addInsured2 = new AddInsuredForm();
		addInsured2.name.sendKeys("Pera");
		browser.sleep(browserPause);
		addInsured2.surname.sendKeys("Peric");
		browser.sleep(browserPause);
		addInsured2.jmbg.sendKeys("0306992180783");
		browser.sleep(browserPause);
		addInsured2.passport.sendKeys("987654321");
		browser.sleep(browserPause);
		addInsured2.address.sendKeys("Perina adresa");
		browser.sleep(browserPause);
		addInsured2.phone.sendKeys("0652220000");
		browser.sleep(browserPause);

		saveInsured.click();
		browser.sleep(browserPause * 2);

		var addCarrier = element(by.id("addCarrier"));
		expect(addCarrier.getAttribute("disabled")).toEqual(null);
		addCarrier.click();
		browser.sleep(browserPause * 3);

	  var carrierForm = new AddCarrierForm();
	  carrierForm.carrier.get(1).click();
		browser.sleep(browserPause);
		carrierForm.email.sendKeys("zaric.jovica.zaric@gmail.com");
		browser.sleep(browserPause * 2);

	  var saveCarrier = element(by.id("saveCarrier"));
	  saveCarrier.click();
		browser.sleep(browserPause * 2);

		var vehicle = element(by.id("vehicle_insurance"));
		vehicle.click();
		browser.sleep(browserPause);

		var vehicleForm = new VehicleForm();
		vehicleForm.duration.sendKeys("10");
		browser.sleep(browserPause);
		vehicleForm.towing.click();
		browser.sleep(browserPause);
		vehicleForm.kilometers.sendKeys("1500");
		browser.sleep(browserPause);
		vehicleForm.type.sendKeys("Audi");
		browser.sleep(browserPause);
		vehicleForm.model.sendKeys("A4");
		browser.sleep(browserPause);
		vehicleForm.year.sendKeys("2012");
		browser.sleep(browserPause);
		vehicleForm.registration.sendKeys("NS101NS");
		browser.sleep(browserPause);
		vehicleForm.vin.sendKeys("1");
		browser.sleep(browserPause);
		vehicleForm.owner.get(1).click();
		browser.sleep(browserPause);

		var preview = element(by.id("preview"));
		preview.click();

		browser.sleep(browserPause * 4);

		var back2 = element(by.id("back"));
		back2.click();

		browser.sleep(browserPause * 3);


		var next = element(by.id("next"));
		next.click();
		browser.sleep(5000);

		expect(browser.getCurrentUrl()).toContain("payApp");

		var paying = new CreditCardForm();
		paying.visa.click();
		browser.sleep(browserPause);
		paying.number.sendKeys("1111111111111111");
		browser.sleep(browserPause);
		paying.expirationMonth.sendKeys("11");
		browser.sleep(browserPause);
		paying.expirationYear.sendKeys("17");
		browser.sleep(browserPause);
		paying.code.sendKeys("111");
		browser.sleep(browserPause);
		paying.holderName.sendKeys("Zika");
		browser.sleep(browserPause);
		paying.holderSurname.sendKeys("Zikic");
		browser.sleep(browserPause * 2);

		var pay = element(by.id("pay"));
		pay.click();

		browser.sleep(5000);
		expect(browser.getCurrentUrl()).toContain("error");

	});
});
