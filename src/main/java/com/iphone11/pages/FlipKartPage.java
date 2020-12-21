package com.iphone11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iphone11.base.TestBase;

public class FlipKartPage extends TestBase{
	
	@FindBy (xpath = "//*[@class = '_2KpZ6l _2doB4z']") 
	public WebElement loginPopup;
	
	@FindBy (xpath = "//*[@class = '_3704LK']") 
	public WebElement searchBox_input;
	
	@FindBy (xpath = "//*[@class = 'L0Z3Pu']") 
	public WebElement search_btn;
	
	@FindBy (xpath = "//*[@class = '_30jeq3 _1_WHN1']") 
	public WebElement iphonePrice_txt;
	
	
	public FlipKartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginCrossBtn() throws Throwable {
		click(loginPopup);
	}
	
	public void searchProduct(String product) {
		sendKeys(searchBox_input,product);
	}
	
	public void clickSearchIcon() throws Throwable {
		click(search_btn);
	}
	
	public Double getIphone11Price() {
		String value=getText(iphonePrice_txt);
		value = value.replaceAll("[₹,]", "");
		Double price=stringToDoubleConversion(value);
		return price;
	}

}
