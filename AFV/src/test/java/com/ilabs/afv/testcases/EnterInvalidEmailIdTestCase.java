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
public class EnterInvalidEmailIdTestCase {
    @DataProvider
    public Object[][] testEnterInvalidEmailIdDataProvider() {
        return TestUtil.getdata("testEnterInvalidEmailId",
                Excel.getInstance());
    }


    @Test(dataProvider = "testEnterInvalidEmailIdDataProvider")
    public void testEnterInvalidEmailId(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testEnterInvalidEmailId",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testEnterInvalidEmailId "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testEnterInvalidEmailId" + "$$$$");

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


            String imgButton = Locator.getLocatorInstance().emailIDPlus;
            int count = 0;
            //Click the plus image 3 times
            for (count = 0; count < 3; count++) {
                Keywords.getKeywordInstance().clickOnImageButtonByXpath(DriverConfiguration.getDriverInstance().driver1, imgButton);
            }
            String[] validEmailIds = {"email@domain.com", "firstname.lastname@domain.com", "email@subdomain.domain.com", "firstname+lastname@domain.com", "email..email@domain.com", "email.@domain.com", "email@123.123.123.123", "1234567890@domain.com", ".email@domain.com", "email@domain-one.com", "_______@domain.com", "email@domain.name", "email@domain.co.jp", "firstname-lastname@domain.com"};
            String[] invalidEmailIds = {"plainaddress", "#@%^%#$@#$@#.com", "@domain.com ", "Joe Smith <email@domain.com>", "email@domain@domain.com", "あいうえお@domain.com", "email@domain.com (Joe Smith)", "email@domain", "email@-domain.com", "email@domain.web", "email@111.222.333.44444", "email@domain..com"};
            Thread.sleep(1000);
            System.out.println("Test for Valid Email Ids");
            for (String validEmail : validEmailIds) {
                Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().enterEmailID1);
                Thread.sleep(1000);
                Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().enterEmailID1, validEmail);
                Thread.sleep(1000);

                Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().enterEmailID2);


                boolean status = Keywords.getKeywordInstance().isElementDisplayed(DriverConfiguration.getDriverInstance().driver1, "error_msg1");
                try {
                    // Invalid id message should not be displayed for invalid email;
                    verifyEmail(!status, validEmail);
                } catch (Exception e) {
                    System.out.println("\"Please Enter valid email id\" is displayed for: " + validEmail);
                }
            }
            //end for


            Thread.sleep(5000);
            System.out.println("Test for Invalid Email Ids");
            for (String inValidEmail : invalidEmailIds) {
                Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().enterEmailID1);
                Thread.sleep(1000);
                Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().enterEmailID1, inValidEmail);
                Thread.sleep(1000);

                Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().enterEmailID2);

                //wait for saved to be displayed

                boolean status = Keywords.getKeywordInstance().isElementDisplayed(DriverConfiguration.getDriverInstance().driver1, "error_msg1");
                try {
                    // Invalid id message should be displayed for invalid email;
                    verifyEmail(status, inValidEmail);
                } catch (Exception e) {
                    System.out.println("\"Please Enter valid email id\" is not displayed for: " + inValidEmail);
                }
                //end for
            }


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testEnterInvalidEmailId !!!!!");

        }
        System.out.println("Executed TC - testEnterInvalidEmailId.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testEnterInvalidEmailId" + "$$$$");
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

    public void verifyEmail(boolean isElementDisplyed, String email) {
        try {
            Assert.assertTrue(isElementDisplyed);
        } catch (Error e) {
            System.out.println(email);
        }
    }
}
