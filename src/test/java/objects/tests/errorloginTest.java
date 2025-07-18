package objects.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import objects.pageobjects.Abstractwait;

public class errorloginTest {
	@Test
	public void checkLoginerror() {
	    WebDriver driver = new ChromeDriver();
	    try {
	        driver.get("https://rahulshettyacademy.com/client/");
	        driver.findElement(By.id("userEmail")).sendKeys("ab12945@gmail.com");
	        driver.findElement(By.id("userPassword")).sendKeys("Deep1234");
	        driver.findElement(By.id("login")).click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        // Wait until the toast appears
	        WebElement errorToast = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.cssSelector(".ng-trigger-flyInOut")));

	        // Get the text immediately before it disappears
	        String errorMessage = errorToast.getText();
	        System.out.println("Error Message: " + errorMessage);

	    } catch (Exception e) {
	        System.out.println("Error toast was too fast or not found.");
	        e.printStackTrace();
	    } finally {
	        driver.quit();
	    }
	}

}
