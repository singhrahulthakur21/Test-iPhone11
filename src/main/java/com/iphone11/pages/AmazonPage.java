package com.iphone11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iphone11.base.TestBase;

public class AmazonPage extends TestBase{
	
	@FindBy (xpath = "//a[@id='nav-logo-sprites']") 
	public WebElement amLogo;
	
	@FindBy (xpath = "//span[contains(text(),'Best Sellers in Sports, Fitness & Outdoors')]") 
	public WebElement lastEle;
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']") 
	public WebElement search_input;
	
	@FindBy (xpath = "//span[@id='nav-search-submit-text']") 
	public WebElement search_btn;
	
	@FindBy (xpath = "//*[@class = 'a-price-whole']") 
	public WebElement iphonePrice_txt;
	

	
	public AmazonPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String product) {
		sendKeys(search_input,product);
	}
	
	public void clickSearchAmazonIcon() throws Throwable {
		click(search_btn);
	}
	
	public Double getIphone11Price() {
		String value=getText(iphonePrice_txt);
		value = value.replaceAll("[₹,]", "");
		Double price=stringToDoubleConversion(value);
		return price;
	}
}
