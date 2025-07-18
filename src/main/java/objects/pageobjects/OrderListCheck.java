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

public class OrderListCheck extends Abstractwait {

	public OrderListCheck(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderList;

	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement clickOrders;
	
	
	public Boolean Verifyorderadded(String productName) {
		Boolean match=orderList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	



	

	

}
