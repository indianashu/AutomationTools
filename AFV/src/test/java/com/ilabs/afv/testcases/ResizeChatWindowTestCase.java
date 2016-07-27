package com.ilabs.afv.testcases;

import com.ilabs.afv.configuration.DriverConfiguration;
import com.ilabs.afv.excelUtility.Excel;
import com.ilabs.afv.excelUtility.TestUtil;
import com.ilabs.afv.keywords.Keywords;
import com.ilabs.afv.locators.Locator;
import com.ilabs.afv.messages.Messages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Hashtable;

/**
 * Created by habi.ravi on 10/9/2014.
 */
public class ResizeChatWindowTestCase {
    @DataProvider
    public Object[][] testResizeChatWindowDataProvider() {
        return TestUtil.getdata("testResizeChatWindow",
                Excel.getInstance());
    }

    @Test(dataProvider = "testResizeChatWindowDataProvider")
    public void testResizeChatWindow(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testResizeChatWindow",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testResizeChatWindow "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testResizeChatWindow" + "$$$$");

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
            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().clickInvite);
            Thread.sleep(5000);
            Keywords.getKeywordInstance().clickOnLinkbyXpath(DriverConfiguration.getDriverInstance().driver1,
                    Locator.getLocatorInstance().testInvite);

            Thread.sleep(10000);
            Alert a = DriverConfiguration.getDriverInstance().driver1.switchTo().alert();
            a.accept();
            Thread.sleep(5000);
            //Get visitor chat window size.
       //     Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "chat_win");

            //Check initial window size
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"Chat");
            Dimension visitorInitialFrameSize = Keywords.getKeywordInstance().getFrameSize(DriverConfiguration.getDriverInstance().driver1, "ClientView");

            System.out.println("Visitor initial frame size:"+visitorInitialFrameSize);
            Thread.sleep(5000);
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1, "247-afv-stage - 247-afv-stage");
            Dimension agentInitialFrameSize = Keywords.getKeywordInstance().getFrameSize(DriverConfiguration.getDriverInstance().driver1, "chat_win");
            System.out.println("Agent initial frame size:"+agentInitialFrameSize);
            Assert.assertEquals(visitorInitialFrameSize,agentInitialFrameSize);

            //Change visitor chat window size
            System.out.println(data.get(Locator.getLocatorInstance().chatWindowHeight1)+","+data.get(Locator.getLocatorInstance().chatWindowWidth1));
            System.out.println(data.get(Locator.getLocatorInstance().chatWindowHeight2)+","+data.get(Locator.getLocatorInstance().chatWindowWidth2));

            int chatWindowHeight1 = (int)Double.parseDouble(data.get(Locator.getLocatorInstance().chatWindowHeight1));
            int chatWindowWidth1 = (int)Double.parseDouble(data.get(Locator.getLocatorInstance().chatWindowWidth1));
            int chatWindowHeight2 = (int)Double.parseDouble(data.get(Locator.getLocatorInstance().chatWindowHeight2));
            int chatWindowWidth2 = (int)Double.parseDouble(data.get(Locator.getLocatorInstance().chatWindowWidth2));

            Dimension newVisitorFrameSize1 = new Dimension(chatWindowWidth1,chatWindowHeight1);
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"Chat");
            DriverConfiguration.getDriverInstance().driver1.manage().window().setSize(newVisitorFrameSize1);
            //Get the size of visitor chat frame after changing the size of window
            newVisitorFrameSize1 = Keywords.getKeywordInstance().getFrameSize(DriverConfiguration.getDriverInstance().driver1, "ClientView");


            Thread.sleep(5000);
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1, "247-afv-stage - 247-afv-stage");
            Dimension newAgentFrameSize1 = Keywords.getKeywordInstance().getFrameSize(DriverConfiguration.getDriverInstance().driver1, "chat_win");
            System.out.println("visitor frame size"+newVisitorFrameSize1);
            System.out.println("agent frame size" + newAgentFrameSize1);
            Assert.assertEquals(newVisitorFrameSize1,newAgentFrameSize1);



            //Change visitor chat window size

            Dimension newVisitorFrameSize2 = new Dimension(chatWindowWidth2,chatWindowHeight2);
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"Chat");
            DriverConfiguration.getDriverInstance().driver1.manage().window().setSize(newVisitorFrameSize2);
            //Get the size of visitor chat frame after changing the size of window
            newVisitorFrameSize2 = Keywords.getKeywordInstance().getFrameSize(DriverConfiguration.getDriverInstance().driver1, "ClientView");


            Thread.sleep(5000);
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1, "247-afv-stage - 247-afv-stage");
            Dimension newAgentFrameSize2 = Keywords.getKeywordInstance().getFrameSize(DriverConfiguration.getDriverInstance().driver1, "chat_win");
            System.out.println("visitor frame size"+newVisitorFrameSize2);
            System.out.println("agent frame size"+newAgentFrameSize2);

            Assert.assertEquals(newVisitorFrameSize2,newAgentFrameSize2);



        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testResizeChatWindow !!!!!");

        }
        System.out.println("Executed TC - testResizeChatWindow.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testResizeChatWindow" + "$$$$");
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
