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
public class ExchangeTemplatesTestCase {
    @DataProvider
    public Object[][] testExchangeTemplatesDataProvider() {
        return TestUtil.getdata("testExchangeTemplates",
                Excel.getInstance());
    }

    @Test(dataProvider = "testExchangeTemplatesDataProvider")
    public void testExchangeTemplates(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testExchangeTemplates",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testExchangeTemplates "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testExchangeTemplates" + "$$$$");

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

            Thread.sleep(5000);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().typeText, data.get(Locator.getLocatorInstance().ChatMsg));

            Thread.sleep(4000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().agentSendText);

            String searchTemplateKeyword1 = data.get(Locator.getLocatorInstance().searchTemplateKeyword1);
            String searchTemplateKeyword2 = data.get(Locator.getLocatorInstance().searchTemplateKeyword2);

            String templateButtonLocator = Locator.getLocatorInstance().templatesButton;
            //click on template dropdown
            String templatesList = Locator.getLocatorInstance().templatesList;
            Keywords.getKeywordInstance().clickOnDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, templateButtonLocator);
           //Clear the search key present in the text field
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().searchTemplate);
            Thread.sleep(5000);
            System.out.println("Search Keyword 1 ="+searchTemplateKeyword1);
            Keywords.getKeywordInstance().selectDropdownItem(DriverConfiguration.getDriverInstance().driver1, templatesList, searchTemplateKeyword1);

            Thread.sleep(5000);
            Keywords.getKeywordInstance().clickOnDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, templateButtonLocator);
            //Clear the previous search keyword
            Thread.sleep(5000);
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().searchTemplate);
            Thread.sleep(5000);
            System.out.println("Search Keyword 2 ="+searchTemplateKeyword2);
            Keywords.getKeywordInstance().selectDropdownItem(DriverConfiguration.getDriverInstance().driver1, templatesList, searchTemplateKeyword2);
            Thread.sleep(5000);


            //switch to iframe of Agent
            Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "chat_win");
            Thread.sleep(5000);
            // Get url of image displayed in visitor window
            List<String> img = Keywords.getKeywordInstance().fetchSourceOfAllImageElement(DriverConfiguration.getDriverInstance().driver1);
            System.out.println("Image found in Agent frame= " + img);

            Keywords.getKeywordInstance().switchToWindowTitle(DriverConfiguration.getDriverInstance().driver1,
                    "Chat", 10);
            Thread.sleep(5000);
            Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "ClientView");
            Thread.sleep(5000);

            // Get url of image displayed in visitor window
            List<String> imgVisitor = Keywords.getKeywordInstance().fetchSourceOfAllImageElement(DriverConfiguration.getDriverInstance().driver1);
            System.out.println("Image found in Visitor frame= " + imgVisitor);
            Assert.assertEquals(img, imgVisitor, Messages.getMessage().stringAssertionFailureMessage);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testExchangeTemplates !!!!!");

        }
        System.out.println("Executed TC - testExchangeTemplates.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testExchangeTemplates" + "$$$$");
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
