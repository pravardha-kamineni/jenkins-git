package bindings;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SigninPage;

public class SigninBinding {
	
	
	public static String url = "https://opensource-demo.orangehrmlive.com/";
	public static WebDriver driver;
	public static Actions action;
	
	//Test data
	public static String username = "Admin";
	public static String password = "admin123";
	
	

	//Locators
	public static By forsigninpage = By.xpath("//*[text()='Sign in']");
	public static By forusername = By.xpath("//*[@placeholder='Username']");
	public static By forpassword = By.xpath("//*[@placeholder='Password']");
	public static By forloginbttn = By.xpath("//*[@type='submit']");
	
	
	
	@Given("The application is launched")
	public void the_application_is_launched() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get(url);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@When("The Signin page is opened")
	public void the_signin_page_is_opened() {
		
		driver.findElement(forsigninpage).click();
		
	}

	@When("The user entered valid username and password")
	public void the_user_entered_valid_username_and_password() throws Exception {
		
		driver.findElement(forusername).sendKeys(username);
		driver.findElement(forpassword).sendKeys(password);
		
	}

	@And("The user hit the signin button")
	public void the_user_hit_the_signin_button() {
		
		driver.findElement(forloginbttn).click();
		
	}

	@Then("The user signed in successfully")
	public void the_user_signed_in_successfully() {
		
		String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		String actual = driver.getCurrentUrl();
		
		assertEquals(actual, expected);
		
	}

}
