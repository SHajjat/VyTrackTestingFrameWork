package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	private WebDriver driver = Driver.get();
	private LoginPage loginPage;
	public PageBase(){
		PageFactory.initElements(driver,this);
	}
	public LoginPage loginPage(){
		if(loginPage == null){
			loginPage = new LoginPage();
		}
		return loginPage;
	}
}
