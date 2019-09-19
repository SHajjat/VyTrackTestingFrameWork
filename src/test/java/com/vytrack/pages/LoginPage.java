package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
	
	@FindBy (id = "prependedInput")
	public WebElement Username;
	
	@FindBy (id ="prependedInput2")
	public WebElement password;
	
	@FindBy (css = "button[type='submit']")
	public WebElement submit;
	
	@FindBy(xpath = "//div/div[text()='Invalid user name or password.']")
	public WebElement invalidUser;
	
	
	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver = Driver.get();
		driver.get(ConfigurationReader.get("url"));
		PageBase pageBase = new PageBase();
		pageBase.loginPage().Username.sendKeys(ConfigurationReader.get("salesman_user")+"s");
		pageBase.loginPage().password.sendKeys(ConfigurationReader.get("salesman_password"));
		pageBase.loginPage().submit.click();
		Thread.sleep(3000);
		System.out.println(pageBase.loginPage().invalidUser.getText());
		driver.quit();
	}
}
