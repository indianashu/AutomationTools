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
import java.security.Key;
import java.util.Hashtable;

/**
 * Created by habi.ravi on 10/3/2014.
 */
public class SelectionOfVisitorTraitsTestCase {
    @DataProvider
    public Object[][] testSelectionOfVisitorTraitsDataProvider() {
        return TestUtil.getdata("testSelectionOfVisitorTraits",
                Excel.getInstance());
    }
    @Test(dataProvider = "testSelectionOfVisitorTraitsDataProvider")
    public void testSelectionOfVisitorTraits(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testSelectionOfVisitorTraits",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testSelectionOfVisitorTraits "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testSelectionOfVisitorTraits" + "$$$$");

        try {
            Keywords.getKeywordInstance().launchBrowserOne(
                    data.get(Locator.getLocatorInstance().browserOne));

            Keywords.getKeywordInstance().navigateToTheUrl(
                    DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().afvURL);

            Thread.sleep(2000);
            Keywords.getKeywordInstance().maximizeWindow(DriverConfiguration.getDriverInstance().driver1);
            //////////////
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



            Thread.sleep(5000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(
                    DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorTraitsLink);
                Thread.sleep(1000);

            String habitLocator = Locator.getLocatorInstance().buyingHabitTrait;
            String moneyMindLocator =  Locator.getLocatorInstance().moneyMindTrait;
            String ourCustomerLocator =  Locator.getLocatorInstance().customerTrait;

            Keywords.getKeywordInstance().clickOnCustomerTrait(DriverConfiguration.getDriverInstance().driver1,habitLocator, data.get(Locator.getLocatorInstance().buyingHabit1));
            Thread.sleep(2000);
            Keywords.getKeywordInstance().clickOnCustomerTrait(DriverConfiguration.getDriverInstance().driver1,moneyMindLocator, data.get(Locator.getLocatorInstance().moneyMind1));
            Thread.sleep(2000);
            Keywords.getKeywordInstance().clickOnCustomerTrait(DriverConfiguration.getDriverInstance().driver1,ourCustomerLocator, data.get(Locator.getLocatorInstance().ourCustomer1));
            Thread.sleep(2000);


            Assert.assertTrue(Keywords.getKeywordInstance().containsVisitorTrait(DriverConfiguration.getDriverInstance().driver1, data.get(Locator.getLocatorInstance().buyingHabit1)),Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertTrue(Keywords.getKeywordInstance().containsVisitorTrait(DriverConfiguration.getDriverInstance().driver1, data.get(Locator.getLocatorInstance().moneyMind1)),Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertTrue(Keywords.getKeywordInstance().containsVisitorTrait(DriverConfiguration.getDriverInstance().driver1, data.get(Locator.getLocatorInstance().ourCustomer1)),Messages.getMessage().stringAssertionFailureMessage);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testSelectionOfVisitorTraits !!!!!");

        }
        System.out.println("Executed TC - testSelectionOfVisitorTraits.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testSelectionOfVisitorTraits" + "$$$$");
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
