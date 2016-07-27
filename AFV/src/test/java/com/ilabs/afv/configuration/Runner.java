
package com.ilabs.afv.configuration;

import com.ilabs.afv.testcases.*;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Runner {

	static TestListenerAdapter tla;
	static TestNG testng;

	public static void main(String[] args) {

		tla = new TestListenerAdapter();
		testng = new TestNG();
		testng.setTestClasses(new Class[] {
//				AgentBrowserBackButtonClickCobrowseTestCase.class,
//				AgentBrowserBackButtonClickCoviewTestCase.class,
//				AgentSessionTerminateTestCase.class,
//				BrowseBackButtonClickCobrowseTestCase.class,
//				BrowseBackButtonClickCoviewTestCase.class,
//				BrowserForwardButtonClickCobrowseTestCase.class,
//				BrowserForwardButtonClickCoviewTestCase.class,
//				ChangeDomainAgentTestCase.class,
//				ChangeDomainCustomerTestCase.class,
//				ClickHighlightCobrowseAgentTestCase.class,
//				ClickHighlightCobrowseCustomerTestCase.class,
//				CobrowseFormFillTestCase.class,
//				ConnectButtonInactiveTestCase.class,
//                ContinueSessionTestCase.class,
//				CoScrollTestCase.class,
//				CoViewTestCase.class,
//				CustomerSessionTerminateTestCase.class,
//				DropDownSelectionTestCase.class,
//				DuplicateSessionsTestCase.class,
//				DuplicateCoViewSessionTestCase.class,
//				FormFillTestCase.class,
//				GenerateKeyTestCase.class,
//				HomePageSearchCobrowseCustomerTestCase.class,
//				HomePageSearchCobrowseAgentTestCase.class,
//				InternalPageClicksCobrowseAgentTestCase.class,
//				InternalPageClicksCobrowseCustomerTestCase.class,
//				InvalidKeyTestCase.class,
//				MaskedFieldTestCase.class,
//				MultipleClicksCobrowseTestCase.class,
//				MultipleClicksCoViewTestCase.class,
//				MultipleTabs.class,
//				RandomClicksCoBrowseTestCase.class,
//				ReconnectAgentCobrowseTestCase.class,
//				ReconnectAgentCoViewTestCase.class,
//				SessionConnectionSuccessTestCase.class,
//				StatusCobrowseCoviewTestCase.class,
//				ToggleCobrowseCoviewTestCase.class,
//				TopMenuClicksCobrowseAgentTestCase.class,
//				VeryifyTextCoViewTestCase.class
//				
				
});
		testng.addListener(tla);
		testng.setOutputDirectory(System.getProperty("user.dir"));
		testng.run();
	}
}

