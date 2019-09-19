package com.vytrack.step_defenition;

import com.vytrack.pages.PageBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class LoginStepDefin {
	WebDriver driver = Driver.get();
	PageBase pageBase = new PageBase();
	WebDriverWait wait = new WebDriverWait(driver,5);
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		driver.get(ConfigurationReader.get("url"));
	}
	
	@And("user enter valid username and password")
	public void user_enter_valid_username_and_password(Map<String , String> credintials) {
	pageBase.loginPage().Username.sendKeys(ConfigurationReader.get("salesman_user"));
	pageBase.loginPage().password.sendKeys(ConfigurationReader.get("salesman_password"));
	pageBase.loginPage().submit.click();
	}
	
	@Then("user should be able to see home page")
	public void user_should_be_able_to_see_home_page() {
		Assert.assertEquals("Dashboard",driver.getTitle());
		Assert.assertEquals("https://qa3.vytrack.com/",driver.getCurrentUrl());
	}
	
	@Given("user enter invalid username and valid password")
	public void user_enter_invalid_username_and_valid_password() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
	
	
	
	@Given("user enter invalid {string} or invalid {string}")
	public void user_enter_invalid_or_invalid(String user, String password) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(pageBase.loginPage().Username)).clear();
		pageBase.loginPage().Username.sendKeys(user);
		Thread.sleep(2000);
		pageBase.loginPage().password.sendKeys(password);
		pageBase.loginPage().submit.click();
		
	}
	@Then("user should see {string}")
	public void user_should_see(String msg) {
		Assert.assertEquals(msg,pageBase.loginPage().invalidUser.getText());
	}
	
}
