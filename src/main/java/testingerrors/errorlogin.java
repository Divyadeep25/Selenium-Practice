package testingerrors;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objects.pageobjects.Abstractwait;

public class errorlogin {

	
	public void checkLoginerror() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/auth/login");
		driver.findElement(By.id("userEmail")).sendKeys("ab12945@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Deep1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class*=flyout]"))));
		
		String errorMessage=driver.findElement(By.cssSelector("[class*=flyout]")).getText();
		System.out.println(errorMessage);
		
		
		
		
	}
}
