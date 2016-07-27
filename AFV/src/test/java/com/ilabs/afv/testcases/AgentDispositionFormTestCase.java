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
 * Created by habi.ravi on 10/14/2014.
 */
public class AgentDispositionFormTestCase {

    //@Test(dataProvider = "testAgentDispositionFormDataProvider")
    @Test(dataProvider = "testAgentDispositionFormLongTextDataProvider")
    public void testAgentDispositionForm(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testAgentDispositionForm",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testAgentDispositionForm "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testAgentDispositionForm" + "$$$$");

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


            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1, "247-afv-stage - 247-afv-stage");
            //Click on End Session

            Keywords.getKeywordInstance().clickOnButtonByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().endSession);
            Thread.sleep(1000);
            //Fill basic information
            //Click on Interaction status
            String interactionRadioLocator = Locator.getLocatorInstance().interactionRadioLocator;
            String interaction = data.get(Locator.getLocatorInstance().InteractionStatus);
            Keywords.getKeywordInstance().selectRadioButtonInAGroup(DriverConfiguration.getDriverInstance().driver1, interactionRadioLocator, Keywords.getKeywordInstance().getInteractionValueByName(interaction));
            String radiolabel = Keywords.getKeywordInstance().fetchLabelOfOptionsByXpath(DriverConfiguration.getDriverInstance().driver1, interactionRadioLocator, Keywords.getKeywordInstance().getInteractionValueByName(interaction));
            //Add some hints
            String hintsLocator = Locator.getLocatorInstance().hintsLocator;
            ;
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, hintsLocator);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, hintsLocator, data.get(Locator.getLocatorInstance().hint));
            //Get hints from Agent main window.
            String hintsSidePanelLocator = Locator.getLocatorInstance().hintsSidePanelLocator;
            Thread.sleep(1000);
            //Click on Next
            String nextOneLocator = Locator.getLocatorInstance().nextOneLocator;
            ;
            Keywords.getKeywordInstance().clickOnButtonByXpath(DriverConfiguration.getDriverInstance().driver1, nextOneLocator);
            //Click all checkbox in About Online Session
            String onlineSessionCheckBoxLocator = Locator.getLocatorInstance().onlineSessionCheckBoxLocator;
            String customerWasNtConvincedCheckBox = Locator.getLocatorInstance().customerWasNtConvincedCheckBox;
            String customerSideCheckBox = Locator.getLocatorInstance().customerSideCheckBox;
            Keywords.getKeywordInstance().clickOnCheckBoxByXpath(DriverConfiguration.getDriverInstance().driver1, onlineSessionCheckBoxLocator);
            Keywords.getKeywordInstance().clickOnCheckBoxByXpath(DriverConfiguration.getDriverInstance().driver1, customerSideCheckBox);
            Keywords.getKeywordInstance().clickOnCheckBoxByXpath(DriverConfiguration.getDriverInstance().driver1, customerWasNtConvincedCheckBox);
            Thread.sleep(1000);
            //Add clarification
            String clarificationLocator = Locator.getLocatorInstance().clarificationLocator;
            ;
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, clarificationLocator);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, clarificationLocator, data.get(Locator.getLocatorInstance().clarrification));

            String ideaLocator = Locator.getLocatorInstance().ideaLocator;
            Keywords.getKeywordInstance().clearDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, ideaLocator);
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, ideaLocator, data.get(Locator.getLocatorInstance().idea));

            String nextTwoLocator = Locator.getLocatorInstance().nextTwoLocator;
            ;
            Keywords.getKeywordInstance().clickOnButtonByXpath(DriverConfiguration.getDriverInstance().driver1, nextTwoLocator);

            Thread.sleep(1000);
            String summaryLocator = Locator.getLocatorInstance().summaryLocator;
            String summary = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1, summaryLocator);
            //Check summary
            //Click submit
            Keywords.getKeywordInstance().clickOnButtonByXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().submitButton);
            System.out.println(summary);
            //Get hint from Left panel of Agent window
            String hintsFromSidePanel = Keywords.getKeywordInstance().fetchLabelNamebyXpath(DriverConfiguration.getDriverInstance().driver1, Locator.getLocatorInstance().hintsSidePanelLocator);


            Assert.assertTrue(summary.contains(data.get(Locator.getLocatorInstance().guestName)));
            Assert.assertTrue(summary.contains(data.get(Locator.getLocatorInstance().InviteSubject)));
            Assert.assertTrue(summary.contains(data.get(Locator.getLocatorInstance().InteractionStatus)));
            Assert.assertEquals(hintsFromSidePanel, data.get(Locator.getLocatorInstance().hint));
            Assert.assertTrue(summary.contains(data.get(Locator.getLocatorInstance().idea)));

        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testAgentDispositionForm !!!!!");

        }
        System.out.println("Executed TC - testAgentDispositionForm.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testAgentDispositionForm" + "$$$$");
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
    public Object[][] testAgentDispositionFormDataProvider() {
        return TestUtil.getdata("testAgentDispositionForm",
                Excel.getInstance());
    }

    @DataProvider
    public Object[][] testAgentDispositionFormLongTextDataProvider() {
        return TestUtil.getdata("testAgentDispositionFormLongText",
                Excel.getInstance());
    }
}
