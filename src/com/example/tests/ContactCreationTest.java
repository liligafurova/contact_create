package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.yahoo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateAccount() throws Exception {
    driver.get(baseUrl + "");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div//ul/li[2]//a/em"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div//ul/li[2]//a/em")).click();
    driver.findElement(By.xpath("//div[4]/a")).click();
    driver.findElement(By.id("first-name")).clear();
    driver.findElement(By.id("first-name")).sendKeys("testuser");
    driver.findElement(By.id("last-name")).clear();
    driver.findElement(By.id("last-name")).sendKeys("user");
    driver.findElement(By.id("user-name")).clear();
    driver.findElement(By.id("user-name")).sendKeys("user.testuser1234");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Qwerty123");
    driver.findElement(By.linkText("United States (+1)+1")).click();
    new Select(driver.findElement(By.id("country-code"))).selectByVisibleText("Russia (+7)");
    driver.findElement(By.id("mobile")).clear();
    driver.findElement(By.id("mobile")).sendKeys("9176816954");
    new Select(driver.findElement(By.id("month"))).selectByVisibleText("April");
    new Select(driver.findElement(By.id("day"))).selectByVisibleText("7");
    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1981");
    driver.findElement(By.id("male")).click();
    driver.findElement(By.cssSelector("input.button.submit")).click();
    driver.findElement(By.id("captchaV5Answer")).clear();
    driver.findElement(By.id("captchaV5Answer")).sendKeys("");
    driver.findElement(By.cssSelector("input.button.submit")).click();
    assertTrue(isElementPresent(By.id("search-submit")));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
