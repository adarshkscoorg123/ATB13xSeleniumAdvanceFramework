package com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM;

import com.thetestingacademy.base.CommonToAllBasePage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class DashboardPage extends CommonToAllBasePage {

    // Page Class
    // Step 0-Parameterized constructor
    // Step 1 - Page locators
    // Step 2 - Page Actions

    WebDriver driver;

    public DashboardPage(WebDriver driver) {

        this.driver = driver;
    }

    // Step 1 - Page locators
    private By dashBoard = By.xpath("//span[text()=\"Dashboard\"]");
    private By amcret = By.xpath("//h6[text()=\"Amcret\"]");
    private By testing = By.xpath("//span[text()=\"Testing\"]");

    // Step 2 - Page Actions
    public String loggedinName(){
        WaitHelpers.checkVisibility(getDriver(),amcret);
        getDriver().get("https://app.vwo.com/#/dashboard");
        return getText(amcret);
    }

    public String dashBoardName(){
        getDriver().get("https://app.vwo.com/#/dashboard");
        return getText(dashBoard);
    }

    public String testing(){
        getDriver().get("https://app.vwo.com/#/dashboard");
       return getText(testing);
    }

}
