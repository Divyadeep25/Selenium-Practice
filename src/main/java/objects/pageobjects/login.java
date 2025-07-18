package objects.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class login {

	public static void main(String[] args) throws InterruptedException {

		String productName = "ADIDAS ORIGINAL";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Landingpage ladp = new Landingpage(driver);
		ladp.goTo();
		ladp.loginapp("abc12945@gmail.com", "Deep1234");

		ProudctsList productContent = new ProudctsList(driver);
		List<WebElement> products = productContent.ProductCat();
		productContent.addTocart(productName);

		
		Cartopen opencart =new Cartopen(driver);
		opencart.Cartpage();
		opencart.VerifyProductadded(productName);
		opencart.moveforward();

		Proceedtopayment proceed = new Proceedtopayment(driver);
//		Boolean match=proceed.VerifyProductadded(productName);
//		Assert.assertTrue(match);
		//proceed.matchElement(productName);
		proceed.selectCountry();
		proceed.finalProceed();
		proceed.thankYou();
		
		driver.close();

	}

}
