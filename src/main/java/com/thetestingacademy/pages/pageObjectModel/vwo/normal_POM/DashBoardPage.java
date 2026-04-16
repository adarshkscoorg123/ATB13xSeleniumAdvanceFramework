package com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {


    WebDriver driver;

    public DashBoardPage(WebDriver driver) {

        this.driver = driver;
    }

    //span[text()="Dashboard"]
    //h6[text()="Amcret"]
    //span[text()="Testing"]

    // Step 1 - Page locators
    private By dashBoard = By.xpath("//span[text()=\"Dashboard\"]");
    private By amcret = By.xpath("//h6[text()=\"Amcret\"]");
    private By testing = By.xpath("//span[text()=\"Testing\"]");

    // Step 2 - Page Actions
    public String loggedinName(){
        WaitHelpers.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard");
        String nameAmcret = driver.findElement(amcret).getText();
        return nameAmcret;
    }

    public String dashBoardName(){
        driver.get("https://app.vwo.com/#/dashboard");
        String nameDashboard = driver.findElement(dashBoard).getText();
        return nameDashboard;
    }

    public String testing(){
        driver.get("https://app.vwo.com/#/dashboard");
        String nameTesting = driver.findElement(testing).getText();
        return nameTesting;
    }

}
