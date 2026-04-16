package com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM;

import com.thetestingacademy.base.CommonToAllBasePage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAllBasePage {

    // Page Class
    // Step 0-Parameterized constructor
    // Step 1 - Page locators
    // Step 2 - Page Actions

    WebDriver driver;

    // Step 0-Parameterized constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Step 1 - Page locators
    private By userName  =  By.id("login-username");
    private By password  =  By.name("password");
    private By signIn    =  By.xpath("//button[@id=\"js-login-btn\"]");
    private By error_message = By.id("js-notification-box-msg");
    private By ssoLogin  =  By.xpath("//button[contains(text(),\"Sign in using SSO\")]");
    private By freeTrial =  By.xpath("//span[text()=\"Start a FREE TRIAL\"]");

    // Step 2 - Page Actions
    public String loginToVWOInvalidCredentials(String user, String pwd){
        openVWOUrl();
        getDriver().manage().window().maximize();
        enterInput(userName,user);
        enterInput(password,pwd);
        clickElement(signIn);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);
    }

    public void loginToVWOValidCredentials(String user, String pwd) throws InterruptedException {

        openVWOUrl();
        getDriver().manage().window().maximize();
        enterInput(userName,user);
        enterInput(password,pwd);
        clickElement(signIn);
        WaitHelpers.waitJVM(5000);

    }

}
