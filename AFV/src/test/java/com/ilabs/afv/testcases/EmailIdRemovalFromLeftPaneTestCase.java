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
public class EmailIdRemovalFromLeftPaneTestCase {
    @DataProvider
    public Object[][] testEmailIdRemovalFromLeftPaneDataProvider() {
        return TestUtil.getdata("testEmailIdRemovalFromLeftPane",
                Excel.getInstance());
    }

    @Test(dataProvider = "testEmailIdRemovalFromLeftPaneDataProvider")
    public void testEmailIdRemovalFromLeftPane(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testEmailIdRemovalFromLeftPane",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testEmailIdRemovalFromLeftPane "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testEmailIdRemovalFromLeftPane" + "$$$$");

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

            Thread.sleep(10000);


            String actualEmailID1 = data.get(Locator.getLocatorInstance().emailId1);
            String actualEmailID2 = data.get(Locator.getLocatorInstance().emailId2);
            String actualEmailID3 = data.get(Locator.getLocatorInstance().emailId3);


            String imgButton = Locator.getLocatorInstance().emailIDPlus;
            //Click the plus image 3 times
            int count = 0;
            for (count = 0; count < 3; count++) {
                Keywords.getKeywordInstance().clickOnImageButtonByXpath(DriverConfiguration.getDriverInstance().driver1, imgButton);
            }
            System.out.println();
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID1);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID2);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID3);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID1, actualEmailID1);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID2, actualEmailID2);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID3, actualEmailID3);
            Thread.sleep(1000);

            String expectedEmailID1 = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().enterEmailID1);
            String expectedEmailID2 = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().enterEmailID2);
            String expectedEmailID3 = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().enterEmailID3);

            Assert.assertEquals(expectedEmailID1, actualEmailID1);
            Assert.assertEquals(expectedEmailID2, actualEmailID2);
            Assert.assertEquals(expectedEmailID3, actualEmailID3);

            //removing email id
            String locator = Locator.getLocatorInstance().selectEmail;

            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().enterEmailID1);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().clickOnDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, locator);
            Thread.sleep(5000);


            Assert.assertFalse(Keywords.getKeywordInstance().isElementPresentInDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, locator, actualEmailID1));

        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testEmailIdRemovalFromLeftPane !!!!!");

        }
        System.out.println("Executed TC - testEmailIdRemovalFromLeftPane.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testEmailIdRemovalFromLeftPane" + "$$$$");
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
