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
 * Created by habi.ravi on 10/13/2014.
 */
public class SearchForFormTestCase {

    @Test(dataProvider = "testSearchForFormDataProvider")
    public void testSearchForForm(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testSearchForForm",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testSearchForForm "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testSearchForForm" + "$$$$");

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
            String mainWindowTitle = DriverConfiguration.getDriverInstance().driver1.getTitle();

            System.out.println("Main Window handle: " + MainWindow + "main window title" + mainWindowTitle);

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

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().testInvite);

            Thread.sleep(10000);

            //Keywords.getKeywordInstance().switchToWindow(DriverConfiguration.getDriverInstance().driver2);

            Alert a = DriverConfiguration.getDriverInstance().driver1.switchTo().alert();
            a.accept();
            //Get Visitor window handle;
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1, "Chat");
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1, "247-afv-stage - 247-afv-stage");

            Thread.sleep(10000);


            DriverConfiguration.getDriverInstance().driver1.switchTo().window(MainWindow);

            Keywords.getKeywordInstance().clickOnDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().formButton);
            Thread.sleep(1000);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().searchForm, data.get(Locator.getLocatorInstance().searchFormKeyword));
            Thread.sleep(2000);


            int countOfForm = Keywords.getKeywordInstance().countOfElementPresentInPanelByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().formList);
            System.out.println("count = " + countOfForm);

            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().searchForm);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().searchForm, data.get(Locator.getLocatorInstance().searchFormKeyword1));
            Thread.sleep(2000);


            int countOfForm1 = Keywords.getKeywordInstance().countOfElementPresentInPanelByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().formList);
            System.out.println("count1 = " + countOfForm1);
            double actualCountOfForm = Double.parseDouble(data.get(Locator.getLocatorInstance().countOfForm));
            double actualCountOfForm1 = Double.parseDouble(data.get(Locator.getLocatorInstance().countOfForm1));

            Assert.assertEquals((int) actualCountOfForm, countOfForm, Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals((int) actualCountOfForm1, countOfForm1, Messages.getMessage().stringAssertionFailureMessage);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testSearchForForm !!!!!");

        }
        System.out.println("Executed TC - testSearchForForm.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testSearchForForm" + "$$$$");
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
    public Object[][] testSearchForFormDataProvider() {
        return TestUtil.getdata("testSearchForForm",
                Excel.getInstance());
    }
}
