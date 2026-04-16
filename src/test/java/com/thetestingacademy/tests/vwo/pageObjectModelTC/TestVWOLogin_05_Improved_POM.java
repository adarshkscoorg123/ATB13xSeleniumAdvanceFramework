package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.LoginPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM.DashBoardPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_05_Improved_POM extends CommonToAllTest {

    // D - Driver
    // L - Locators
    // V - Validation

    public static final Logger logger = LogManager.getLogger(TestVWOLogin_05_Improved_POM.class);


    @Owner("Adarsh")
    @Description("Verify that with invalid email, password, error message is displayed")
    @Test
    public void test_negative_vwo_login() {

        logger.info("Starting the Testcases Page Object Model");
        //Driver manager code-1 - D
        // From CommonToAllTEst

        // So the flow will be first before method is called from CommonToAllTest,
        // Then "test_negative_vwo_login" will be executed
        // Then After method is called from CommonToAllTest

        //Page Class Code(POM Code)-2 - L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_message_login = loginPage.loginToVWOInvalidCredentials(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Asserting the invalid credentials");

        //Assertions-3 - V
        assertThat(error_message_login).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_message_login,PropertiesReader.readKey("error_message"));


    }

    @Owner("Adarsh")
    @Description("Verify that with valid email, password, dashboard page is displayed")
    @Test
    public void test_login_positive_vwo() throws InterruptedException {

        //Driver manager code-1 - D
        // From CommonToAllTEst

        // So the flow will be first before method is called from CommonToAllTest,
        // Then "test_negative_vwo_login" will be executed
        // Then After method is called from CommonToAllTest

        logger.info("Starting the Testcases Page Object Model_positive");


        //Page Class Code(POM Code)-2 - L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginToVWOValidCredentials(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        String userNameLoggedIn = dashBoardPage.loggedinName();

        logger.info("Done the test cases");

        assertThat(userNameLoggedIn).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(userNameLoggedIn,PropertiesReader.readKey("expected_username"));


    }

}
