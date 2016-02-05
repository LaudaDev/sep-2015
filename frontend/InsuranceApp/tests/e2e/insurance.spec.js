describe("Testing home page and insurance basic info page", function(){	
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

describe("Testing insurance basic info form", function(){
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

describe("Testing adding persons details", function(){
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