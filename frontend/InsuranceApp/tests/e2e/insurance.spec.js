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
		expect(price).toBe("3.155,32 dins");
		
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