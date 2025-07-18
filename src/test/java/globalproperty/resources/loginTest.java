package globalproperty.resources;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.Testcomponent.Basetest;
import objects.pageobjects.Cartopen;
import objects.pageobjects.OrderListCheck;
import objects.pageobjects.Proceedtopayment;
import objects.pageobjects.ProudctsList;

public class loginTest extends Basetest {

	
	String productName = "ADIDAS ORIGINAL";

	@Test
	public void loginPage() throws IOException, InterruptedException {

		String productName = "ADIDAS ORIGINAL";
		//Landingpage ladp = launchAppliocation();
		ProudctsList productContent=  ladp.loginapp("abc12945@gmail.com", "Deep1234");

		
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

	}
	@Test(dependsOnMethods= {"loginPage"})
	public void OrderList() throws InterruptedException {
		ProudctsList productContent=  ladp.loginapp("abc12945@gmail.com", "Deep1234");
		OrderListCheck order=new OrderListCheck(driver);
		order.OrderCheck();
		Boolean match=order.Verifyorderadded(productName);
		Assert.assertTrue(match);
		

	}

}
