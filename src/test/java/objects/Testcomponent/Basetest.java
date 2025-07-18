package objects.Testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.pageobjects.Landingpage;
import objects.pageobjects.ProudctsList;

public class Basetest {

	public WebDriver driver; // shared instance for each thread
	public Landingpage ladp;
	public ProudctsList productContent;

	public WebDriver filepath() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/globalproperty/resources/setglobal.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// prop.getProperty("browser");

		if (browsername.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();

			WebDriverManager.chromedriver().setup();
			if (browsername.contains("--headless")) {
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");

			}
			driver = new ChromeDriver(options);
			// Force full-screen via JavaScript
			((JavascriptExecutor) driver).executeScript("window.moveTo(0, 0); window.resizeTo(1920, 1080);");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return driver;
		}

		else if (browsername.contains("firefox")) {
			// WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException, InterruptedException {
		driver = filepath(); // assigns to this.driver
		ladp = new Landingpage(driver);
		ladp.goTo();
	}

	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}

	public List<HashMap<String, String>> getJsondata(String filepath) throws IOException {
		String jsonData = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonData,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/report/" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "/report/" + testCaseName + ".png";
	}
}
