package com.example.tests;

import static org.junit.Assert.assertTrue;

import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	protected WebDriver driver;
	protected String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeSuite
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.yahoo.com/";
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }

	@AfterSuite
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
	  }

	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	protected void openMainPage() {
		driver.get(baseUrl + "");
	}

	protected void gotoSignInPage() {
		driver.findElement(By.xpath("//div//ul/li[2]//a/em")).click();
	}
	
	protected void fillAccountCreationForm(AccountObject account) {
		driver.findElement(By.id("first-name")).clear();
	    driver.findElement(By.id("first-name")).sendKeys(account.first_name);
	    driver.findElement(By.id("last-name")).clear();
	    driver.findElement(By.id("last-name")).sendKeys(account.last_name);
	    
	    driver.findElement(By.id("user-name")).clear();
	    driver.findElement(By.id("user-name")).sendKeys(account.username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(account.password);
	    
	    driver.findElement(By.id("selected-country-code-1")).click();
	    driver.findElement(By.xpath("//li/a[@data-code="+account.country_code+"]")).click();
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys(account.mobile);
	    
	    new Select(driver.findElement(By.id("month"))).selectByVisibleText("April");
	    new Select(driver.findElement(By.id("day"))).selectByVisibleText("7");
	    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1981");
	    
	    driver.findElement(By.id("male")).click();
	}

	protected void initAccountCreation() {
		driver.findElement(By.xpath("//div[4]/a")).click();
	}

	protected void submitAccountCreation() {
		driver.findElement(By.cssSelector("input.button.submit")).click();
	}	

	protected void sendsms() {
		driver.findElement(By.xpath("//div[2]/input")).click();
	}
	
	protected void verificationAccountCreation() {
		driver.findElement(By.id("verification-code")).clear();
	    try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[2]/input")).click();
	    
	}
	
	protected void assertAccountRegistration() {
		try {
			Thread.sleep(20000);
			assertTrue(isElementPresent(By.id("search-submit")));	
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
