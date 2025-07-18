package objects.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import objects.pageobjects.Abstractwait;

public class Proceedtopayment extends Abstractwait {

	WebDriver driver;

	public Proceedtopayment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	

	@FindBy(css = "*[placeholder$='Select Country']")
	WebElement country;

	By countryValues = By.cssSelector(".ta-results");

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement countrySelect;

	@FindBy(css = ".btnn")
	WebElement proceedButton;

	@FindBy(css = ".hero-primary")
	WebElement success;

	By successMess = By.cssSelector(".hero-primary");
	

	public void selectCountry() {
		//clickButton.click();
		
		Actions a = new Actions(driver);
		a.sendKeys(country, "ind").build().perform();
		waitForwhile(countryValues);
		countrySelect.click();

	}

	public void finalProceed() throws InterruptedException {
		WebElement proceed = proceedButton;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", proceed);
		Thread.sleep(200);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceed);
	}

	public void thankYou() {

		String confirmed = success.getText();
		waitForwhile(successMess);
		Assert.assertTrue(confirmed.equalsIgnoreCase("Thankyou for the order."));
	}
}
