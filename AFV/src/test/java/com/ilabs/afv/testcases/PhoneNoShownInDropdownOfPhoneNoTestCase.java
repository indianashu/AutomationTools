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
public class PhoneNoShownInDropdownOfPhoneNoTestCase {
    @DataProvider
    public Object[][] testPhoneNoShownInDropdownOfPhoneNoProvider() {
        return TestUtil.getdata("testPhoneNoShownInDropdownOfPhoneNo",
                Excel.getInstance());
    }
    @Test(dataProvider = "testPhoneNoShownInDropdownOfPhoneNoProvider")
    public void testPhoneNoShownInDropdownOfPhoneNo(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testEnterEmailByAgent",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testEnterEmailByAgent "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testEnterEmailByAgent" + "$$$$");

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

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterSubject, data.get(Locator.getLocatorInstance().InviteSubject));

            Thread.sleep(3000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().clickInvite);


            String actualPhoneNo = data.get(Locator.getLocatorInstance().phoneNo1);
            System.out.println("Actual phone no: "+actualPhoneNo);

            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterPhoneNumber1 );
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterPhoneNumber1,actualPhoneNo );
            Thread.sleep(1000);
            String expectedPhoneNo = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,Locator.getLocatorInstance().enterPhoneNumber1);
            System.out.println("Expected phone no: "+expectedPhoneNo);

            Thread.sleep(5000);
            String locator = Locator.getLocatorInstance().selectPhone;
            Keywords.getKeywordInstance().clickOnDropdownByXpath(DriverConfiguration.getDriverInstance().driver1,locator);
            Thread.sleep(5000);
            System.out.println("Element present in dropdown: " +Keywords.getKeywordInstance().isElementPresentInDropdownByXpath(DriverConfiguration.getDriverInstance().driver1,locator,actualPhoneNo));
            Assert.assertTrue(Keywords.getKeywordInstance().isElementPresentInDropdownByXpath(DriverConfiguration.getDriverInstance().driver1,locator,actualPhoneNo),Messages.getMessage().stringAssertionFailureMessage);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testPhoneNoShownInDropdownOfPhoneNo !!!!!");

        }
        System.out.println("Executed TC - testPhoneNoShownInDropdownOfPhoneNo.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testPhoneNoShownInDropdownOfPhoneNo" + "$$$$");
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
