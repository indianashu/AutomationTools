
package com.ilabs.afv.messages;

public class Messages {

	private static Messages message;
	public String alertCobrowseInitiation = "Customer support Agent will start a co-browse session with you. Please accept.";
	public String alertCobrowseCancelled = "The client didn't accepted the request.";
	public String alertCoviewInitiation = "Customer support Agent will start a co-view session with you. Please accept.";
	public String alertCoviewCancelled = "The client didn't accepted the request.";
	public String stringAssertionFailureMessage = "Assertion failed as the strings do not match";
	public String objectAssertionFailureMessage = "Assertion failed as the objects do not match";
	public String booleanAssertionFailureMessage="Boolean Assertion failed";
	public String alertSwitchCoview = "The Client changed session to Co-View";
	public String alertSwitchCobrowse = "The Client changed session to CoBrowse";
	public String connectedStatus="Status: Connected!";
	public String disconnectedStatus="Status: Disconnected";
	public String assertionFailureMessage="Assertion failed due to the following reason : --> ";
	public String agentTerminatedSessionMessage="Admin left the channel.";
    public String customerTerminatedSessionMessage="Client left the channel.";   
	//public String topSellersLabelTextContent="BESTSELLERS";

	private Messages() {

	}

	public static Messages getMessage() {
		if (message == null) {
			message = new Messages();
		}
		return message;
	}

}
