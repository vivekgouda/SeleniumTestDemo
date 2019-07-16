package com.altimetrik.SeleniumTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestApplication {

	@Test
	public void seleniumBasic() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/");

		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("DemoSalesManager");

		driver.findElementById("password").sendKeys("crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("Altimetrik");
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Vivek");
		
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Gouda");
		
		Select sourceDropDown = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		sourceDropDown.selectByVisibleText("Employee");
		Thread.sleep(1000);
		Select marketingDropDown = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		marketingDropDown.selectByValue("DEMO_MKTG_CAMP");
		Thread.sleep(1000);
		Select industryDropDown = new Select(driver.findElementById("createLeadForm_industryEnumId"));
		industryDropDown.selectByIndex(3);
		
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		
		String companyName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		String firstName = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		String lastName = driver.findElementByXPath("//span[@id='viewLead_lastName_sp']").getText();

		//
		// Thread.sleep(100000);

		// WebElement month = driver.findElementById("month");
		// Select dropdown = new Select(month);
		// dropdown.selectByVisibleText("Mar");
		// Thread.sleep(2000);
		// dropdown.selectByValue("5");
		// Thread.sleep(2000);
		// dropdown.selectByIndex(8);

		if (companyName.contains("Altimetrik")) {
			System.out.println("Test Pass : Correct Company Name");
		} else {
			System.out.println("Test Fail : Wrong Company Name");
		}

		if (firstName.equals("Vivek")) {
			System.out.println("Test Pass : Correct Name");
		} else {
			System.out.println("Test Fail : Wrong Name");
		}

		if (lastName.equals("Gouda")) {
			System.out.println("Test Pass : Correct Last Name");
		} else {
			System.out.println("Test Fail : Wrong Last Name");
		}

		// driver.findElementByLinkText("Forgotten account?").click();

		// driver.findElementByPartialLinkText("Forgotten").click();

		// driver.findElementByXPath("//input[@id='email']");

		/*
		 * List<WebElement> link = driver.findElementsByTagName("a");
		 * 
		 * for (WebElement webElement : link) {
		 * 
		 * String href = webElement.getAttribute("href");
		 * System.out.println(href); }
		 */

		/*
		 * driver.navigate().to("https://accounts.google.com");
		 * 
		 * driver.navigate().back();
		 * 
		 * driver.navigate().forward();
		 * 
		 * driver.navigate().refresh();
		 * 
		 * //driver.close();
		 */
		 driver.quit();

	}

}
