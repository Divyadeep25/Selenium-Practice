package objects.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Cartopen extends Abstractwait {

	public Cartopen(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> addedproducts;

	@FindBy(css = ".totalRow button")
	WebElement proceedBtn;
	
	
	public Boolean VerifyProductadded(String productName) {
		Boolean match=addedproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public WebElement moveforward() {
		proceedBtn.click();
		return proceedBtn;
	}



	

	

}
