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
public class FormFillByAgentTestCase {
    @DataProvider
    public Object[][] testFormFillByAgentDataProvider() {
        return TestUtil.getdata("testFormFillByAgent",
                Excel.getInstance());
    }

    @Test(dataProvider = "testFormFillByAgentDataProvider")
    public void testFormFillByAgent(Hashtable<String, String> data)
            throws InterruptedException, MalformedURLException {

        if (!TestUtil.isTestCaseExecutable("testFormFillByAgent",
                Excel.getInstance())) {
            DriverConfiguration.APPLICATION_LOGS
                    .debug("Skipping the test case :" + " testFormFillByAgent "
                            + " as the run mode is NO ");
            throw new SkipException("skipping the test case as run mode is NO");
        }
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Starting the Execution of the Test Case : ----> "
                + "testFormFillByAgent" + "$$$$");

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
            List<String> agentFormSource = Keywords.getKeywordInstance().GetLastFormHTMLSource(DriverConfiguration.getDriverInstance().driver1,"chat_win");


            //Switch to Visitor chat window
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"Chat");
            //get form source of visitor
            List<String> visitorFormSource = Keywords.getKeywordInstance().GetLastFormHTMLSource(DriverConfiguration.getDriverInstance().driver1,"ClientView");
            Thread.sleep(2000);
            //System.out.println("Agent Form Source"+agentFormSource);
            //System.out.println("Visitor Form Source"+visitorFormSource);

         //   Assert.assertEquals(agentFormSource, visitorFormSource, Messages.getMessage().stringAssertionFailureMessage);


            //Fill Form by the agent.
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"247-afv-stage - 247-afv-stage");

            Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1,"chat_win");
            //Select One Way Radio Button"
            String groupLocator =Locator.getLocatorInstance().groupLocator;
            Keywords.getKeywordInstance().selectRadioButtonInAGroup(DriverConfiguration.getDriverInstance().driver1,groupLocator,1);
            Thread.sleep(2000);
            //Enter departure date
            String departureLocator =Locator.getLocatorInstance().departureLocator;
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,departureLocator,"01/01/2012");
            Thread.sleep(2000);
            //Enter arrival date
            String arrivalLocator =Locator.getLocatorInstance().arrivalLocator;
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,arrivalLocator,"01/01/2012");
            Thread.sleep(2000);
            //Click on date flexible checkbox
            String dateFlexiblelocator =Locator.getLocatorInstance().dateFlexiblelocator;
            Keywords.getKeywordInstance().clickOnCheckBoxByXpath(DriverConfiguration.getDriverInstance().driver1,dateFlexiblelocator);
            Thread.sleep(2000);
            //Enter departing from textField
            String departingFromLocator =Locator.getLocatorInstance().departingFromLocator;
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,departingFromLocator,"Delhi");
            Thread.sleep(2000);
            //Enter arriving from textField
            String arrivingFromlocator =Locator.getLocatorInstance().arrivingFromlocator;
            Keywords.getKeywordInstance().enterDataInTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,arrivingFromlocator,"Bangalore");
            Thread.sleep(2000);

            //Select adult dropdown
            String adultDropDownLocator=Locator.getLocatorInstance().adultDropDownLocator;
            Keywords.getKeywordInstance().chooseValueFromDropdownbyXpath(DriverConfiguration.getDriverInstance().driver1, adultDropDownLocator, "2");
            Thread.sleep(2000);
            //Select children dropdown
            String childrenDropDownLocator =Locator.getLocatorInstance().childrenDropDownLocator;
            Keywords.getKeywordInstance().chooseValueFromDropdownbyXpath(DriverConfiguration.getDriverInstance().driver1, childrenDropDownLocator, "2");
            Thread.sleep(2000);
            //Select infants dropdown
            String infantsDropDownLocator = Locator.getLocatorInstance().infantsDropDownLocator;
            Keywords.getKeywordInstance().chooseValueFromDropdownbyXpath(DriverConfiguration.getDriverInstance().driver1, infantsDropDownLocator, "2");

            Thread.sleep(5000);
            //Edited  all the fields in Agent window.
            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"247-afv-stage - 247-afv-stage");
            Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "chat_win");
            //Get all the values from the agent form;
            String agentDepartureDate = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,departureLocator);
            String agentArrivalDate = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,arrivalLocator);
            String agentDepartingFrom = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,departingFromLocator);
            String agentArrivingFrom = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,arrivingFromlocator);
            String agentAdultDropDown = Keywords.getKeywordInstance().getSelectedOptionFromDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, adultDropDownLocator);
            String agentChildrenDropDown = Keywords.getKeywordInstance().getSelectedOptionFromDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, childrenDropDownLocator);
            String agentInfantsDropDown = Keywords.getKeywordInstance().getSelectedOptionFromDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, infantsDropDownLocator);

            Keywords.getKeywordInstance().switchToWindowWithTitle(DriverConfiguration.getDriverInstance().driver1,"Chat");
            Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1,"ClientView");
            Thread.sleep(5000);
            //Get all the values from the visitor form;
            String visitorDepartureDate = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,departureLocator);
            String visitorArrivalDate = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,arrivalLocator);
            String visitorDepartingFrom = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,departingFromLocator);
            String visitorArrivingFrom = Keywords.getKeywordInstance().fetchDataFromTextFieldByXpath(DriverConfiguration.getDriverInstance().driver1,arrivingFromlocator);
            String visitorAdultDropDown = Keywords.getKeywordInstance().getSelectedOptionFromDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, adultDropDownLocator);
            String visitorChildrenDropDown = Keywords.getKeywordInstance().getSelectedOptionFromDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, childrenDropDownLocator);
            String visitorInfantsDropDown = Keywords.getKeywordInstance().getSelectedOptionFromDropdownByXpath(DriverConfiguration.getDriverInstance().driver1, infantsDropDownLocator);

            Assert.assertEquals(visitorDepartureDate,agentDepartureDate,  Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals(visitorArrivalDate,agentArrivalDate,  Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals(visitorDepartingFrom,agentDepartingFrom,  Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals(visitorArrivingFrom,agentArrivingFrom,  Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals(visitorAdultDropDown,agentAdultDropDown,  Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals(visitorChildrenDropDown,agentChildrenDropDown,  Messages.getMessage().stringAssertionFailureMessage);
            Assert.assertEquals(visitorInfantsDropDown,agentInfantsDropDown,  Messages.getMessage().stringAssertionFailureMessage);

        } catch (Throwable t) {
            DriverConfiguration.APPLICATION_LOGS.debug(
                    "Selenium related exception ---->" + t.getMessage()
                            + " occured", t);
            Assert.fail(Messages.getMessage().assertionFailureMessage, t);
            System.out.println("!!!!! TC Failed - testFormFillByAgent !!!!!");

        }
        System.out.println("Executed TC - testFormFillByAgent.");
        DriverConfiguration.APPLICATION_LOGS.debug("$$$$"
                + "Finishing the Execution of the Test Case : ----> "
                + "testFormFillByAgent" + "$$$$");
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
