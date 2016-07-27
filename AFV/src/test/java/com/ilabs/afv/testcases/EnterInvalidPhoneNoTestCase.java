package com.ilabs.afv.testcases;

import com.ilabs.afv.configuration.DriverConfiguration;
import com.ilabs.afv.excelUtility.Excel;
import com.ilabs.afv.excelUtility.TestUtil;
import com.ilabs.afv.keywords.Keywords;
import com.ilabs.afv.locators.Locator;
import com.ilabs.afv.messages.Messages;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Hashtable;

/**
 * Created by habi.ravi on 10/10/2014.
 */
public class EnterInvalidPhoneNoTestCase {
    @DataProvider
    public Object[][] testEnterInvalidPhoneNoDataProvider() {
        return TestUtil.getdata("testEnterInvalidPhoneNo",
                Excel.getInstance());
    }

    @Test(dataProvider = "testEnterInvalidPhoneNoDataProvider")
    public void testEnterInvalidPhoneNo(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testEnterInvalidPhoneNo",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testEnterInvalidPhoneNo "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testEnterInvalidPhoneNo" + "$$$$");

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
            //Phone No plus Button
            String imgButton = Locator.getLocatorInstance().phoneNumberPlus;
            int count = 0;
            for (count = 0; count < 3; count++) {
                Keywords.getKeywordInstance().clickOnImageButtonByXpath(DriverConfiguration.getDriverInstance().driver1, imgButton);
            }
        //Test For Phone

            testForPhoneNo(Locator.getLocatorInstance().enterPhoneNumber1);
            testForPhoneNo(Locator.getLocatorInstance().enterPhoneNumber2);
            testForPhoneNo(Locator.getLocatorInstance().enterPhoneNumber3);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testEnterInvalidPhoneNo !!!!!");

        }
        System.out.println("Executed TC - testEnterInvalidPhoneNo.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testEnterInvalidPhoneNo" + "$$$$");
    }




    public void verifyPhone(boolean isElementDisplyed, String phone) {
        try {
            Assert.assertTrue(isElementDisplyed);
        } catch (Error e) {
            System.out.println(phone);
        }
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

    public void testForPhoneNo(String locator) throws InterruptedException {
        String[] validPhoneNo = {"1234567890", "+911234567890", "01234567890"};
        String[] invalidPhoneNo = {"abcdefkdsk", "123456789a", "+12345a6789", "++1234567890", "$$$adsaf123", ".", "\t\t\t\t\t\t"};


        System.out.println("Test for Valid PhoneNos");
        for (String validPhone : validPhoneNo) {
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    locator);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    locator, validPhone);
            Thread.sleep(1000);


            boolean status = Keywords.getKeywordInstance().isElementDisplayed(DriverConfiguration.getDriverInstance().driver1, "error_msg");
            try {
                // Invalid id message should not be displayed for invalid email;
                verifyPhone(!status, validPhone);
            } catch (Exception e) {
                System.out.println("\"Please Enter valid phone no\" message is displayed for: " + validPhone);
            }
        }
        //end for


        Thread.sleep(5000);
        System.out.println("Test for Invalid PhoneNos");
        for (String invalidPhone : invalidPhoneNo) {
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    locator);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    locator, invalidPhone);
            Thread.sleep(1000);

            //wait for saved to be displayed

            boolean status = Keywords.getKeywordInstance().isElementDisplayed(DriverConfiguration.getDriverInstance().driver1, "error_msg");
            try {
                // Invalid id message should be displayed for invalid email;
                verifyPhone(status, invalidPhone);
            } catch (Exception e) {
                System.out.println("\"Please Enter valid email id\" message is not displayed for: " + invalidPhone);
            }
        }
    }
}
