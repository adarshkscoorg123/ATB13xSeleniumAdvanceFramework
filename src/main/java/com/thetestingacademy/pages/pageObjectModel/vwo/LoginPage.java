package com.thetestingacademy.pages.pageObjectModel.vwo;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

   /* The below statements are taken from "Lab_55_DDT_TestNG_POI_Real" in "ex_17_Data_driven_testing_POI" package
    So by referring the below statements we will locate the elements and perform actions on these locators
    So basically Page Object Model is "finding the locators and performing actions on them" */

    //WebElement email_inputBox = driver.findElement(By.id("login-username")); // finding locators
    //email_inputBox.sendKeys(email); // performing actions on locators

    //WebElement passwordInputBox = driver.findElement(By.name("password"));
    //passwordInputBox.sendKeys(password);

    //WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id=\"js-login-btn\"]"));
    //buttonSubmit.click();

    //WebElement error_message = driver.findElement(By.className("notification-box-description"));
    //Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

     // So consider the first statement which is
     // WebElement email_inputBox = driver.findElement(By.id("login-username"));
     // email_inputBox.sendKeys(email);

     // Here we will take (by.id) part and separate it from "driver.findElement" part

      // Page Class
      WebDriver driver;

      // Step 0-Parametrized constructor
      public LoginPage(WebDriver driver){
       this.driver = driver;
      }


    //input[@id="login-username"]
    //name="password"
    //button[@id="js-login-btn"]
    //id="js-notification-box-msg"
    //button[contains(text(),"Sign in using SSO")]

    // Step 1 - Page locators
     private By userName  =  By.id("login-username");
     private By password  =  By.name("password");
     private By signIn    =  By.xpath("//button[@id=\"js-login-btn\"]");
     private By error_message = By.id("js-notification-box-msg");
     private By ssoLogin  =  By.xpath("//button[contains(text(),\"Sign in using SSO\")]");
     private By freeTrial =  By.xpath("//span[text()=\"Start a FREE TRIAL\"]");


 // Step 2 - Page Actions
 public String loginToVWOInvalidCredentials(String user, String pwd){
  driver.get(PropertiesReader.readKey("url"));
  driver.manage().window().maximize();
  driver.findElement(userName).sendKeys(user);
  driver.findElement(password).sendKeys(pwd);
  driver.findElement(signIn).click();

  WaitHelpers.checkVisibility(driver,error_message);
  String error_message_text = driver.findElement(error_message).getText();
  return error_message_text;

 }

 public void loginToVWOValidCredentials(String user, String pwd) throws InterruptedException {

  driver.get(PropertiesReader.readKey("url"));
  driver.manage().window().maximize();
  driver.findElement(userName).sendKeys(user);
  driver.findElement(password).sendKeys(pwd);
  driver.findElement(signIn).click();
  WaitHelpers.waitJVM(5000);

 }


}
