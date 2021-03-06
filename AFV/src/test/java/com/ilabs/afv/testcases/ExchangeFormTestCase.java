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
import java.util.List;

/**
 * Created by habi.ravi on 10/3/2014.
 */
public class ExchangeFormTestCase {
    @Test(dataProvider = "testExchangeFormDataProvider")
    public void testExchangeForm(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testExchangeForm",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testExchangeForm "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testExchangeForm" + "$$$$");

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

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().testInvite);

            Thread.sleep(10000);

            //Keywords.getKeywordInstance().switchToWindow(DriverConfiguration.getDriverInstance().driver2);

            Alert a = DriverConfiguration.getDriverInstance().driver1.switchTo().alert();
            a.accept();

            Thread.sleep(10000);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().typeText, data.get(Locator.getLocatorInstance().ChatMsg));

            Thread.sleep(4000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().agentSendText);

            Thread.sleep(10000);

            Keywords.getKeywordInstance().switchToWindowTitle(DriverConfiguration.getDriverInstance().driver1,
                    "Chat", 10);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorTypeText, data.get(Locator.getLocatorInstance().visitorChatMsg));

            Thread.sleep(5000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorSendText);

            Thread.sleep(4000);

            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"247-afv-stage - 247-afv-stage");
            //Click on Form Dropdown button
            Keywords.getKeywordInstance().clickOnDropdownByXpath(DriverConfiguration.getDriverInstance().driver1,Locator.getLocatorInstance().formButton);

            //Click on a Form item
            String dropDownPanelLocator = Locator.getLocatorInstance().formList;
            Thread.sleep(2000);
            Keywords.getKeywordInstance().selectDropdownItem(DriverConfiguration.getDriverInstance().driver1,dropDownPanelLocator,"Trip");
            Thread.sleep(2000);
            //get form source of agent
            List <String> agentFormSource = Keywords.getKeywordInstance().GetLastFormHTMLSource(DriverConfiguration.getDriverInstance().driver1,"chat_win");


            //Switch to Visitor chat window
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"Chat");
            //get form source of visitor
            List<String> visitorFormSource = Keywords.getKeywordInstance().GetLastFormHTMLSource(DriverConfiguration.getDriverInstance().driver1,"ClientView");
            Thread.sleep(2000);
            System.out.println("Agent Form Source"+agentFormSource);
            System.out.println("Visitor Form Source"+visitorFormSource);

            Assert.assertEquals(agentFormSource, visitorFormSource, Messages.getMessage().stringAssertionFailureMessage);
        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testExchangeForm !!!!!");

        }
        System.out.println("Executed TC - testExchangeForm.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testExchangeForm" + "$$$$");
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
    public Object[][] testExchangeFormDataProvider() {
        return TestUtil.getdata("testExchangeForm",
                Excel.getInstance());
    }
}
