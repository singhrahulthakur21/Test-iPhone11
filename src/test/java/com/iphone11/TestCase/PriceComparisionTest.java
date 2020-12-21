package com.iphone11.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iphone11.base.TestBase;
import com.iphone11.pages.AmazonPage;
import com.iphone11.pages.FlipKartPage;

public class PriceComparisionTest extends TestBase{
	FlipKartPage flipcartPage;
	AmazonPage amazonPage;
	
	public PriceComparisionTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		flipcartPage = new FlipKartPage();
		amazonPage = new AmazonPage();
	}
	
	@Test
	public void Test1() throws Throwable {
		launchUrl(prop.getProperty("flipkartUrl"));
		flipcartPage.clickLoginCrossBtn();
		flipcartPage.searchProduct(prop.getProperty("product"));
		flipcartPage.clickSearchIcon();
		Double flipkartPrice=flipcartPage.getIphone11Price();
		launchUrl(prop.getProperty("amazonUrl"));
		amazonPage.searchProduct(prop.getProperty("product"));
		amazonPage.clickSearchAmazonIcon();
		Double amazonPrice=amazonPage.getIphone11Price();
		if(amazonPrice>flipkartPrice) {
			System.out.println("iPhone 11 64GB price on Amazon is higher than Flipkart");
			System.out.println("iPhone 11 64GB price on Amazon is "+amazonPrice);
			System.out.println("iPhone 11 64GB price on Flipkart is "+flipkartPrice);
		}
		else if(amazonPrice<flipkartPrice){
			System.out.println("iPhone 11 64GB price on Flipkart is higher than Amazon");
			System.out.println("iPhone 11 64GB price on Flipkart is "+flipkartPrice);
			System.out.println("iPhone 11 64GB price on Amazon is "+amazonPrice);
		}
		else {
			System.out.println("iPhone 11 64GB price on Flipkart and Amazon are same price ");
			System.out.println("iPhone 11 64GB price on Flipkart is "+flipkartPrice);
			System.out.println("iPhone 11 64GB price on Amazon is "+amazonPrice);
		}
		System.out.println("Test Completed");
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
