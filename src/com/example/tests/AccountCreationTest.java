package com.example.tests;

import org.testng.annotations.Test;

public class AccountCreationTest extends TestBase {
	
  @Test
  public void testAccountCreation() throws Exception {
    
    AccountObject account = new AccountObject(
    		"Ivan", "Petrov", 
    		"ivan.petrov8888", "Qwerty123", 
    		"7", "9178616954");
    
    openMainPage(); 
    gotoSignInPage();
    initAccountCreation();
    fillAccountCreationForm(account);
    submitAccountCreation();
    sendsms();
    verificationAccountCreation();
    assertAccountRegistration();
  }
}
