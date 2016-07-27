package com.ilabs.afv.testcases;

import com.ilabs.afv.configuration.DriverConfiguration;
import com.ilabs.afv.excelUtility.Excel;
import com.ilabs.afv.excelUtility.TestUtil;
import com.ilabs.afv.keywords.Keywords;
import com.ilabs.afv.locators.Locator;
import com.ilabs.afv.messages.Messages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.List;

public class ExchangeChatMessageTestCase {

    @Test(dataProvider = "testExchangeChatMessageDataProvider")
    public void testExchangeChatMessage(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testExchangeChatMessage",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testExchangeChatMessage "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testExchangeChatMessage" + "$$$$");

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
                    "Chat",10);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorTypeText, data.get(Locator.getLocatorInstance().visitorChatMsg));

            Thread.sleep(5000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorSendText);

            Thread.sleep(4000);

            DriverConfiguration.getDriverInstance().driver1.switchTo().window(MainWindow);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().typeText, data.get(Locator.getLocatorInstance().ChatMsg1));

            Thread.sleep(4000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().agentSendText);

            Thread.sleep(10000);


            Keywords.getKeywordInstance().switchToWindowTitle(DriverConfiguration.getDriverInstance().driver1,
                    "Chat",10);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorTypeText, data.get(Locator.getLocatorInstance().visitorChatMsg1));

            Thread.sleep(5000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorSendText);

            Thread.sleep(4000);

            DriverConfiguration.getDriverInstance().driver1.switchTo().window(MainWindow);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().typeText, data.get(Locator.getLocatorInstance().ChatMsg2));

            Thread.sleep(4000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().agentSendText);

            Thread.sleep(10000);

            Keywords.getKeywordInstance().switchToWindowTitle(DriverConfiguration.getDriverInstance().driver1,
                    "Chat",10);

            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorTypeText, data.get(Locator.getLocatorInstance().visitorChatMsg2));

            Thread.sleep(5000);

            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().visitorSendText);

            Thread.sleep(4000);

            DriverConfiguration.getDriverInstance().driver1.switchTo().window(MainWindow);

            String AgentText = Keywords.getKeywordInstance().GetLastAgentText(DriverConfiguration.getDriverInstance().driver1);

            String VisitorText =  Keywords.getKeywordInstance().GetLastVisitorText(DriverConfiguration.getDriverInstance().driver1);

            System.out.print("Agent Text from AC = " + AgentText);
            System.out.print("Visitor Text from AC = " + VisitorText);

            Keywords.getKeywordInstance().switchToWindowTitle(DriverConfiguration.getDriverInstance().driver1,
                    "Chat",10);

            String AgentText1 = Keywords.getKeywordInstance().GetLastAgentTextVC(DriverConfiguration.getDriverInstance().driver1);

            String VisitorText1 =  Keywords.getKeywordInstance().GetLastVisitorTextVC(DriverConfiguration.getDriverInstance().driver1);

            System.out.print("Agent Text from VC = " + AgentText1);
            System.out.print("Visitor Text from VC = " + VisitorText1);


            Assert.assertEquals(VisitorText,VisitorText1,
                    Messages.getMessage().stringAssertionFailureMessage);


        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testExchangeChatMessage !!!!!");

        }
        System.out.println("Executed TC - testExchangeChatMessage.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testExchangeChatMessage" + "$$$$");
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
    public Object[][] testExchangeChatMessageDataProvider() {
        return TestUtil.getdata("testExchangeChatMessage",
                Excel.getInstance());
    }
}
