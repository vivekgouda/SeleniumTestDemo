package AdvanceAction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdvanceSelenumAction {

	@Test
	public void selenumAction() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		/*ChromeOptions ops=new ChromeOptions();
		
		ops.addArguments("--disable-notifications");
		*/
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://jqueryui.com/selectable/");
		driver.get("https://jqueryui.com/droppable/");
		//WebElement fra = driver.findElementByXPath("//iframe[@class='demo-frame']");
		
		driver.switchTo().frame(0);
		
//		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
//		WebElement item3 = driver.findElementByXPath("//li[text()='Item 3']");
//		WebElement item5 = driver.findElementByXPath("//li[text()='Item 5']");
		
		WebElement sourceDrag = driver.findElementById("draggable");
		WebElement targetDrop = driver.findElementById("droppable");
		
		//WebElement men = driver.findElementByLinkText("Men");
//		Thread.sleep(2000);
		Actions builder=new Actions(driver);
		
//		builder.click(item1).keyDown(Keys.CONTROL).click(item3).click(item5).keyUp(Keys.CONTROL).perform();
		
		builder.dragAndDrop(sourceDrag, targetDrop).perform();
		
		/*builder.moveToElement(driver.findElementByXPath("//a[text()='Men']")).perform();
		
		driver.findElementByLinkText("Jeans").click();*/
		
		driver.close();

	}

}
