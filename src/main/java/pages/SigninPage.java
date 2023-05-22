package pages;

import org.openqa.selenium.By;

import baseActions.PageActions;
import bindings.BaseClass;

public class SigninPage{

	//Locators
	public static By forusername = By.xpath("//*[@placeholder='Username']");
	public static By forpassword = By.xpath("//*[@placeholder='Password']");
	public static By forloginbttn = By.xpath("//*[@type='submit']");
	
	
	
	
	
	//respective actions
	
	
	public static void enter_user_credentials(String username, String password) throws Exception {
		
//		PageActions.Sendkeys(forusername, username);
//		PageActions.Sendkeys(forloginbttn, password);
		
	}
	
	public static void click_login_bttn() {
		
//		PageActions.Click(forloginbttn);
		
	}
	
	
	
	
	
	
	
}
