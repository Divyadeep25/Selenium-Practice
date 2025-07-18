package objects.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objects.pageobjects.Abstractwait;
import objects.pageobjects.ProudctsList;

public class Landingpage extends Abstractwait {

    WebDriver driver;

	public Landingpage(WebDriver driver) {

		super(driver);// this is important to use to get data from child class
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// We are suing PageFactory here
	@FindBy(id = "userEmail") // here instead of using driver.findelement use use findby
	WebElement userEmails;

	@FindBy(id = "userPassword") // here instead of using driver.findelement use use findby
	WebElement password;

	@FindBy(id = "login") // here instead of using driver.findelement use use findby
	WebElement submit;
	
	//By errorMes=By.cssSelector(".ng-trigger-flyInOut");

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMes;

	// here we need to create new method to send values to page

	public ProudctsList loginapp(String email, String pass) throws InterruptedException {
		userEmails.sendKeys(email);
		password.sendKeys(pass);
		submit.click();

		return new ProudctsList(driver);
	}

	public void goTo() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/client");
		
	}

	public String getErrorMessage() {
		waitForappear(errorMes);
		
		return errorMes.getText();
		
		 
	}
	


	
	
}
