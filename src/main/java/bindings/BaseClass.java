package bindings;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static String url = "https://jpetstore.aspectran.com/catalog/";
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;

	
	
	//@BeforeAll
	public static void start() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get(url);
		
		//implicit weight
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//explicit wait
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		driver.manage().window().maximize();

	}
	
	
//
//	@AfterAll
//	public void end() {
//
//		driver.quit();
//
//	}
	
	
	
}
