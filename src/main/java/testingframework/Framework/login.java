package testingframework.Framework;

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
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("abc12945@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Deep1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> products = driver.findElements(By.className("mb-3"));
		wait.until(ExpectedConditions.visibilityOfAllElements(products));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> addedproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = addedproducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("*[placeholder$='Select Country']")), "ind").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

		WebElement proceed = driver.findElement(By.cssSelector(".btnn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", proceed);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceed);

		String confirmed = driver.findElement(By.cssSelector(".hero-primary")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		Assert.assertTrue(confirmed.equalsIgnoreCase("Thankyou for the order."));

		driver.close();

	}

}
