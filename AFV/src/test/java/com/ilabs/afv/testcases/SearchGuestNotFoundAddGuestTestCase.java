package com.ilabs.afv.testcases;

import com.ilabs.afv.configuration.DriverConfiguration;
import com.ilabs.afv.excelUtility.Excel;
import com.ilabs.afv.excelUtility.TestUtil;
import com.ilabs.afv.keywords.Keywords;
import com.ilabs.afv.locators.Locator;
import com.ilabs.afv.messages.Messages;
import com.sun.xml.internal.ws.server.DraconianValidationErrorHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.security.Credentials;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Hashtable;

public class SearchGuestNotFoundAddGuestTestCase {

    @Test(dataProvider = "testSearchGuestNotFoundAddGuestDataProvider")
    public void testSearchGuestNotFoundAddGuest(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testSearchGuestNotFoundAddGuest",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testSearchGuestNotFoundAddGuest "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testSearchGuestNotFoundAddGuest" + "$$$$");

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

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().guestID, data.get(Locator.getLocatorInstance().guestName));

             Thread.sleep(3000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().guestSearch);

            Thread.sleep(5000);

            String guestNotFound = Keywords.getKeywordInstance().fetchLabelNamebyXpath(DriverConfiguration
                            .getDriverInstance().driver1,
                    Locator.getLocatorInstance().guestNotFound);

            Thread.sleep(7000);

            if (guestNotFound.equals("Could'nt find the associated account !")){

                Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                        Locator.getLocatorInstance().createNewAccountGuest);

                Thread.sleep(10000);

                String GuestName = Keywords.getKeywordInstance().executeJavascriptToFetchValueFromDisabledField
                        (DriverConfiguration
                        .getDriverInstance().driver1, Locator.getLocatorInstance().guestIDValue);

//                JavascriptExecutor js = (JavascriptExecutor) DriverConfiguration.getDriverInstance().driver1;
//                Object ABC = js.executeScript("return document.getElementById(\"guest_id\").value;");
//                System.out.print(ABC);
//
//                String DEF = ABC.toString();

                System.out.print(GuestName);

                Assert.assertEquals(GuestName, data.get(Locator.getLocatorInstance().guestName),
                        Messages.getMessage().stringAssertionFailureMessage);

            }

            Thread.sleep(7000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().logoutLink);

            Thread.sleep(4000);

            Alert a = DriverConfiguration.getDriverInstance().driver1.switchTo().alert();
            a.accept();



        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testSearchGuestNotFoundAddGuest !!!!!");

        }
        System.out.println("Executed TC - testSearchGuestNotFoundAddGuest.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testSearchGuestNotFoundAddGuest" + "$$$$");
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

    @DataProvider
    public Object[][] testSearchGuestNotFoundAddGuestDataProvider() {
        return TestUtil.getdata("testSearchGuestNotFoundAddGuest",
                Excel.getInstance());
    }
}