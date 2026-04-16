package com.thetestingacademy.base;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import static com.thetestingacademy.driver.DriverManager.driver;
import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllBasePage {

    // Common to all Page
    public void openVWOUrl(){
        // The below statements can be used either of them
        // driver.get(PropertiesReader.readKey("url"));
        // DriverManager.getDriver().get(PropertiesReader.readKey("url")); // THis is a first way
        getDriver().get(PropertiesReader.readKey("url")); // This is a second way
    }

    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKey("ohr_url")); //
    }

    public void openKatalonUrl(){
        getDriver().get(PropertiesReader.readKey("katalon_url")); //
    }

    public void clickElement(By by){
        //driver.findElement(signIn).click(); // This statement is taken from LoginPage
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        //driver.findElement(signIn).click(); // This statement is taken from LoginPage
        by.click();
    }

    public void enterInput(By by, String key){
       //driver.findElement(userName).sendKeys(user);
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key){
        //driver.findElement(userName).sendKeys(user);
        by.sendKeys(key);
    }

    public String getText(By by){
        //return driver.findElement(error_message).getText()
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        //return driver.findElement(error_message).getText()
        return by.getText();
    }


}
