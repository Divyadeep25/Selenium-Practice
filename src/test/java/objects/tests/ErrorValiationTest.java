package objects.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import objects.Testcomponent.Basetest;
import objects.Testcomponent.Retry;
import objects.pageobjects.Cartopen;
import objects.pageobjects.ProudctsList;

public class ErrorValiationTest extends Basetest {

	@Test(groups = { "ErrorHandling" })
	public void LoginErrorValiation() throws InterruptedException {

		String productName = "ADIDAS ORIGINAL";
		ladp.loginapp("ab12945@gmail.com", "Deep1234");

		Assert.assertEquals("Incorrect email or password.", ladp.getErrorMessage());

	}

	@Test(groups = { "ProductError" }, retryAnalyzer=Retry.class)
	public void ProductErrorValidation() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";

		ProudctsList productContent = ladp.loginapp("abc12945@gmail.com", "Deep1234");

		productContent.addTocart(productName);

		Cartopen opencart = new Cartopen(driver);
		opencart.Cartpage();

		Boolean match = opencart.VerifyProductadded(productName);
		Assert.assertTrue(match);
	}

}
