package bindings;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Petstore_Ques1_Binding {
	
	public static String url = "https://jpetstore.aspectran.com/catalog/";
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static ChromeOptions opt;

	
	//Locators
	public static By for_signin_page = By.linkText("Sign In");
	public static By for_username = By.name("username");
	public static By for_password = By.name("password");
	public static By for_loginbttn = By.xpath("//button[text()='Login']");
	public static By for_addto_cart = By.linkText("Add to Cart");
	public static By for_checkout = By.linkText("Proceed to Checkout");
	public static By for_order_continue = By.xpath("//button[@type='submit' and text()='Continue']");
	public static By for_order_confirm = By.xpath("//button[@type='submit' and text()='Confirm']");
	public static By for_myorder = By.linkText("My Orders");
	
	
	@Given("I navigate to Sign in page")
	public void i_navigate_to_sign_in_page() {
	    
		WebDriverManager.chromedriver().setup();
		
		opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		
		driver = new ChromeDriver(opt);
		action = new Actions(driver);
	    driver.get(url);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	    
	    driver.findElement(for_signin_page).click();
	    
	}

	@When("I enter user credentials {string} {string}")
	public void i_enter_user_credentials(String string, String string2) {
	   
		WebElement username = driver.findElement(for_username);
		action
		.doubleClick(username)
		.build().perform();
		
		username.sendKeys(string);
		
		WebElement password = driver.findElement(for_password);
		
		action
		.doubleClick(password)
		.build().perform();
		
		password.sendKeys(string2);
		
		
	}
	

	@And("I click on login button")
	public void i_click_on_login_button() {
	    
		driver.findElement(for_loginbttn).click();
		
	}

	@Then("I navigate to welcome page")
	@Given("I am on welcome page")
	public void i_navigate_to_welcome_page() {
	    
		assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
	    
	}

//	@Given("I navigate to welcome page")
//	public void i_navigate_to_welcome_page() {
//	    
//		assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
//	    
//	}
//	
//	@Given("I am on welcome page")
//	public void i_am_on_welcome_page() {
//	    
//		assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
//		
//	}

	@When("I choose the type of pet i want to buy")
	public void i_choose_the_type_of_pet_i_want_to_buy(DataTable dataTable) {
	    
		List<List<String>> input = dataTable.asLists(String.class);
		
		driver.findElement(By.linkText(input.get(0).get(0))).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(input.get(0).get(1))));
		driver.findElement(By.linkText(input.get(0).get(1))).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(input.get(0).get(2))));
		driver.findElement(By.linkText(input.get(0).get(2))).click();
	}

	@And("I add the item to cart")
	public void i_add_the_item_to_cart() {
	    
		 driver.findElement(for_addto_cart).click();
	    
	}

	@And("I click on proceed to checkout")
	public void i_click_on_proceed_to_checkout() {
	    
		driver.findElement(for_checkout).click();
		driver.findElement(for_order_continue).click();
	    
	}

	@And("I confirm the order")
	public void i_confirm_the_order() {
	    
		driver.findElement(for_order_confirm).click();
		
	}

	@Then("I verify the order in MyOrder section")
	public void i_verify_the_order_in_my_order_section() {
	    
		String order_id = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]")).getText();
		
		driver.findElement(for_myorder).click();
		
		String myorders_1storder = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[2]/td[1]")).getText();
		
		assertEquals(order_id.split("#")[1], myorders_1storder);
		
	}
	
	@AfterAll
	public static void end() {
		driver.quit();
	}
	
}
