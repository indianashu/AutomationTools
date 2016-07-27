package com.ilabs.afv.testcases;

import com.ilabs.afv.configuration.DriverConfiguration;
import com.ilabs.afv.excelUtility.Excel;
import com.ilabs.afv.excelUtility.TestUtil;
import com.ilabs.afv.keywords.Keywords;
import com.ilabs.afv.locators.Locator;
import com.ilabs.afv.messages.Messages;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Hashtable;

/**
 * Created by habi.ravi on 10/3/2014.
 */
public class EnterPhoneNoByAgentTestCase {
    @DataProvider
    public Object[][] testEnterPhoneNoByAgentDataProvider() {
        return TestUtil.getdata("testEnterPhoneNoByAgent",
                Excel.getInstance());
    }

    @Test(dataProvider = "testEnterPhoneNoByAgentDataProvider")
    public void testEnterPhoneNoByAgent(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testEnterPhoneNoByAgent",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testEnterPhoneNoByAgent "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testEnterPhoneNoByAgent" + "$$$$");

        try {
            Keywords.getKeywordInstance().launchBrowserOne(
                    data.get(Locator.getLocatorInstance().browserOne));

            Keywords.getKeywordInstance().navigateToTheUrl(
                    DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().afvURL);

            Thread.sleep(2000);
            Keywords.getKeywordInstance().maximizeWindow(DriverConfiguration.getDriverInstance().driver1);

            Thread.sleep(2000);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().loginName, Locator.getLocatorInstance().agentlogin);
            Thread.sleep(5000);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().loginPassword, Locator.getLocatorInstance().agentpassword);

            Thread.sleep(5000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(
                    DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().loginButton);

            Thread.sleep(5000);


            String MainWindow = DriverConfiguration.getDriverInstance().driver1.getWindowHandle();

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().guestID, data.get(Locator.getLocatorInstance().guestName));

            Thread.sleep(3000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().guestSearch);

            Thread.sleep(5000);


            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().foundthemStart);

            Thread.sleep(5000);


            String actualPhoneNo = data.get(Locator.getLocatorInstance().phoneNo1);
            System.out.println("Actual phone no: " + actualPhoneNo);

            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterPhoneNumber1);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterPhoneNumber1, actualPhoneNo);
            Thread.sleep(1000);
            String expectedPhoneNo = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().enterPhoneNumber1);
            System.out.println("Expected phone no: " + expectedPhoneNo);
            Assert.assertEquals(expectedPhoneNo, actualPhoneNo,  Messages.getMessage().stringAssertionFailureMessage);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testEnterPhoneNoByAgent !!!!!");

        }
        System.out.println("Executed TC - testEnterPhoneNoByAgent.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testEnterPhoneNoByAgent" + "$$$$");
    }

    @AfterMethod
    // After a test case is executed,this method closes the browsers
    public void closeBrowsers() throws InterruptedException {
        try {
            Keywords.getKeywordInstance().closeBrowser(
                    DriverConfiguration.getDriverInstance().driver1);
        } catch (NullPointerException e) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Could not close the browser due to the error ---->"
                            + e.getMessage());
        }

    }
}
