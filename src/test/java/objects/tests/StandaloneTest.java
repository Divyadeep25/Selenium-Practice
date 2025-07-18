package objects.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objects.Testcomponent.Basetest;
import objects.pageobjects.Cartopen;
import objects.pageobjects.OrderListCheck;
import objects.pageobjects.Proceedtopayment;
import objects.pageobjects.ProudctsList;

public class StandaloneTest extends Basetest {

	
	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider="getData", groups={"Purchase"})
	public void loginPage(HashMap<String,String>input) throws IOException, InterruptedException {

		ProudctsList productContent=  ladp.loginapp(input.get("email"), input.get("password"));

		
		List<WebElement> products = productContent.ProductCat();
		productContent.addTocart(input.get("product"));
		
		Cartopen opencart =new Cartopen(driver);
		opencart.Cartpage();
		opencart.VerifyProductadded(input.get("product"));
		opencart.moveforward();

		Proceedtopayment proceed = new Proceedtopayment(driver);
//		Boolean match=proceed.VerifyProductadded(productName);
//		Assert.assertTrue(match);
		//proceed.matchElement(productName);
		proceed.selectCountry();
		proceed.finalProceed();
		proceed.thankYou();

	}
	@Test(dependsOnMethods= {"loginPage"})
	public void OrderList() throws InterruptedException {
		ProudctsList productContent=  ladp.loginapp("abc12945@gmail.com", "Deep1234");
		OrderListCheck order=new OrderListCheck(driver);
		order.OrderCheck();
		order.Verifyorderadded(productName);
		

	}
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"abc12945@gmail.com", "Deep1234","ADIDAS ORIGINAL"},{"azy@gmail.com", "Kalash18","ZARA COAT 3"}};
//		
//	}
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "abc12945@gmail.com");
//		map.put("password", "Deep1234");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "azy@gmail.com");
//		map1.put("password", "Kalash18");
//		map1.put("product", "ZARA COAT 3");
		List<HashMap<String,String>>data=getJsondata(System.getProperty("user.dir")+"//src//test//java//PurchaseData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

}
