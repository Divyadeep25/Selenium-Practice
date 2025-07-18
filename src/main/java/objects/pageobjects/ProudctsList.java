package objects.pageobjects;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProudctsList extends Abstractwait {

	WebDriver driver;

	public ProudctsList(WebDriver driver) {

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// We are suing PageFactory here
	@FindBy(css = ".mb-3") // here instead of using driver.findelement use use findby
	List<WebElement> pruductcatologue;

	By products = By.className("mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastVisibility = By.cssSelector(".toast-success");
//	@FindBy(css = "#toast-container")
//	WebElement toastVisibility;
	//By spinner = By.cssSelector("ngx-spinner[class='ng-tns-c31-1 ng-star-inserted'] div:nth-child(3)");
	

	@FindBy(css = "ngx-spinner[class='ng-tns-c31-1 ng-star-inserted']")
	WebElement spinner;

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	//

	public List<WebElement> ProductCat() {// here we collected list of all the products
		waitForwhile(products);

		return pruductcatologue;

	}

	public WebElement addingProductByname(String productName) {// here we are finding list of product that we wanted from
																// the list we alredy have above

		WebElement prod = ProductCat().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addTocart(String productName) {
		WebElement prod = addingProductByname(productName);
		prod.findElement(addtocart).click();

		waitForwhile(toastVisibility);// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitForDisappear(spinner);
		
	}

}
