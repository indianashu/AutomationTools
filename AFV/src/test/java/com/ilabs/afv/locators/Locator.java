
package com.ilabs.afv.locators;

//This class contains the locator details of all the elements through which interactions take place through selenium
public class Locator {

    private static Locator locator;

    public String browserOne = "Browser1";
    //public String browserOne="mozilla";
    public String browserTwo = "Browser2";
    public String customerData = "customerdata";
    public String agentData = "agentdata";

    public String windowsOperatingSystem = "Windows 7";
    public String windowsOperatingSystem8 = "Windows 8.1";
    public String getWindowsOperatingSystem10 = "Windows 10";
    public String linuxOperatingSystem = "Linux";
    public String macOperatingSystem = "Mac OS X";
    public String firefoxBrowser = "mozilla";
    public String chromeBrowser = "chrome";
    public String internetExplorerbrowser = "ie";
    public String macbrowser = "safari";


    //public String customerURL = "http://ec2-174-129-75-125.compute-1.amazonaws.com/#!/login";
    public String afvURL = "https://afv-staging.app.247-inc.net/#!/login";
    //public String afvURL = "http://ec2-174-129-75-125.compute-1.amazonaws.com/#!/";

    //Agent Login Details
    public String agentlogin = "agent@247-inc.com";
    public String agentpassword = "Welcome@123";


    //AFV Login Page
    public String loginName = ".//*[@id='username']";
    public String loginPassword = ".//*[@id='password']";
    public String loginButton = ".//*[@id='login']/form/button";
    public String logoutLink = ".//*[@id='afv']/div[1]/div/div/div/div[1]/span/span/a";
    public String logoutLinkCSS = ".flt_right>a";
    public String afvLoginLabel = ".//*[@id='afv']/section/section/section/section/section/section/div/div/div/div/ul/li/a";

    //Guest-ID Search
    //public String guestID = ".//*[@id='afv']/section/section/section/div/div/div[1]/div/div/label/input";
    public String guestID = ".//*[@id='search_txt']";
    public String guestSearch = ".//*[@id='search_item']";
    //Could'nt find the associated account !
    public String guestNotFound = ".//*[@id='afv']/section/section/section/div/div/div[2]/div/div[3]/center/h4";
    public String guestName = "guestName";
    public String createNewAccountGuest = ".//*[@id='afv']/section/section/section/div/div/div[2]/div/div[3]/div[2]/span/input";
    public String guestIDAddConfirm = ".//*[@id='guest_id']";
    public String guestIDValue = "return document.getElementById(\"guest_id\").value;";
    public String foundthemStart = ".//*[@id='afv']/section/section/section/div/div/div[2]/div/div[2]/div[2]/span/input";
    public String InviteSubject = "InviteSubject";
    public String guestName1 = "guestName1";


    //View Hints
    public String viewHints = ".//*[@id='after_guest_id']/div[3]/div";

    //Enter Notes
    public String notesArea = ".//*[@id='notesId']";
    public String notesTextField = ".//*[@id='notesId']/div/input";
    //public String enterNotes1 = ".//*[@id='notesId']/div/div/div[1]";
    //public String enterNotes2 = ".//*[@id='notesId']/div/div/div[2]";
    //public String enterNotes3 = ".//*[@id='notesId']/div/div/div[3]";
    public String noteId = "notesId";
    public String note1 = "note1";
    public String note2 = "note2";
    public String note3 = "note3";

    //Enter Chat Msg by Agent
    public String typeText = ".//*[@id='chat']";
    public String ChatMsg = "ChatMsg";
    public String ChatMsg1 = "ChatMsg1";
    public String ChatMsg2 = "ChatMsg2";
    public String agentSendText = ".//*[@id='dashboard_id']/div[2]/div[6]/form/div/span/button";
    public String returnAgentText = "div.slimScrollDiv li.by-other div span";
    public String returnVisitorText = "div.slimScrollDiv li.by-me div span";


    //Enter Chat Msg by Visitor
    public String visitorTypeText = ".//*[@id='chatInput']";
    public String visitorChatMsg = "visitorChatMsg";
    public String visitorChatMsg1 = "visitorChatMsg1";
    public String visitorChatMsg2 = "visitorChatMsg2";
    public String visitorSendText = "html/body/div[1]/div[3]/div/span/input";

    //Send Apps
    public String searchAppKeyword = "searchAppKeyword";
    public String searchAppKeyword1 = "searchAppKeyword1";
    public String appButton = ".//*[@id='dashboard_id']/div[2]/div[5]/div[1]/div";
    public String searchApps = ".//*[@id='dashboard_id']/div[2]/div[5]/div[1]/ol/input";
    public String availableApps = ".//*[@id='dashboard_id']/div[2]/div[5]/div[1]/ol/div/li";
    public String sendApp1 = ".//*[@id='dashboard_id']/div[2]/div[5]/div[1]/ol/div/li[1]";
    public String agentWindowApp1 = "/html/body/div[5]/div/div/ul/li[3]/div/span/div/table";
    public String countOfApp = "countOfApp";
    public String countOfApp1 = "countOfApp1";
    public String appsPanel = ".//*[@id='dashboard_id']/div[2]/div[5]/div[1]/ol";

    //Send Form
    public String formButton = ".//*[@id='dashboard_id']/div[2]/div[5]/div[2]/div";
    public String formList = ".//*[@id='dashboard_id']/div[2]/div[5]/div[2]/ol/div";
    public String searchForm = ".//*[@id='dashboard_id']/div[2]/div[5]/div[2]/ol/input";
    public String sendForm1 = ".//*[@id='dashboard_id']/div[2]/div[5]/div[2]/ol/div/li[1]";
    public String sendForm2 = ".//*[@id='dashboard_id']/div[2]/div[5]/div[2]/ol/div/li[2]";
    public String searchFormKeyword = "searchFormKeyword";
    public String searchFormKeyword1 = "searchFormKeyword1";
    public String countOfForm = "countOfForm";
    public String countOfForm1 = "countOfForm1";


    //Send Template
    public String searchTemplateKeyword = "searchTemplateKeyword";
    public String searchTemplateKeyword1 = "searchTemplateKeyword1";
    public String searchTemplateKeyword2 = "searchTemplateKeyword2";
    public String templatesButton = ".//*[@id='dashboard_id']/div[2]/div[5]/div[3]/div";
    public String searchTemplate = ".//*[@id='dashboard_id']/div[2]/div[5]/div[3]/ol/input";
    public String templatesList = ".//*[@id='dashboard_id']/div[2]/div[5]/div[3]/ol";
    public String sendTemplate1 = ".//*[@id='dashboard_id']/div[2]/div[5]/div[3]/ol/div/li[1]";
    public String sendTemplate2 = ".//*[@id='dashboard_id']/div[2]/div[5]/div[3]/ol/div/li[2]";
    public String sendTemplate3 = ".//*[@id='dashboard_id']/div[2]/div[5]/div[3]/ol/div/li[3]";
    public String countOfTemplate = "countOfTemplate";
    public String countOfTemplate1 = "countOfTemplate1";

    //Enter Subject
    public String enterSubject = ".//*[@id='subject_con']";
    //Click Invite
    public String clickInvite = ".//*[@id='inactive_id']";

    //Click Test Invite
    public String testInvite = ".//*[@id='demo_id']";

    //Select Phone
    public String selectPhone = ".//*[@id='dashboard_id']/div[2]/div[1]/span[2]/div/div[2]/p[2]/select";
    public String sendSMS = ".//*[@id='dashboard_id']/div[2]/div[1]/span[2]/div/div[2]/p[2]/input";

    //Select Email
    public String selectEmail = ".//*[@id='dashboard_id']/div[2]/div[1]/span[2]/div/div[3]/p[2]/select";
    public String sendEmail = ".//*[@id='dashboard_id']/div[2]/div[1]/span[2]/div/div[3]/p[2]/input";

    //End Session
    public String endSession = ".//*[@id='dashboard_id']/div[2]/div[1]/span[2]/span[4]/span[2]";

    //Visitor Traits
    public String visitorTraitsLink = "//div[1]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/a";
    public String buyingHabit1 = "buyingHabit1";
    public String moneyMind1 = "moneyMind1";
    public String ourCustomer1 = "ourCustomer1";
    public String buyingHabit2 = "buyingHabit2";
    public String moneyMind2 = "moneyMind2";
    public String ourCustomer2 = "ourCustomer2";

    //Phone No
    //Enter Phone Number
    public String phoneNumberPlus = ".//*[@id='InputsWrapper']/span[3]/img";
    public String enterPhoneNumber = ".//*[@id='InputsWrapper']/div/div/input";
    public String enterPhoneNumber1 = ".//div/div/div[1]/div/div[1]/form/div[1]/div/div[1]/input";
    public String enterPhoneNumber2 = ".//div/div/div[1]/div/div[1]/form/div[1]/div/div[2]/input";
    public String enterPhoneNumber3 = ".//div/div/div[1]/div/div[1]/form/div[1]/div/div[3]/input";
    public String phoneNo1 = "phoneNo1";
    public String phoneNo2 = "phoneNo2";
    public String phoneNo3 = "phoneNo3";

    //Enter Email IDs
    public String emailIDPlus = ".//*[@id='InputsemailWrapper']/span[3]/img";
    public String enterEmailID = ".//*[@id='InputsemailWrapper']/div/div/input";
    public String enterEmailID1 = ".//*[@id='InputsemailWrapper']/div/div[1]/input";
    public String enterEmailID2 = ".//*[@id='InputsemailWrapper']/div/div[2]/input";
    public String enterEmailID3 = ".//*[@id='InputsemailWrapper']/div/div[3]/input";
    public String emailId1 = "emailId1";
    public String emailId2 = "emailId2";
    public String emailId3 = "emailId3";

    //Customer Traits
    public String visitorTrait = ".//div[1]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/div/span";
    public String customerTrait = ".//div[2]/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr";
    public String moneyMindTrait = ".//div[2]/div[1]/div/table/tbody/tr/td[2]/table/tbody/tr";
    public String buyingHabitTrait = ".//div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr";

    //Trip Form Locator
    public String groupLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[1]/label[2]/input";
    public String departureLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[2]/div[1]/form/p[1]/label[2]/input";
    public String arrivalLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[2]/div[2]/form/p[1]/label[2]/input";
    public String dateFlexiblelocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[2]/div[1]/form/p[1]/label[3]/input";
    public String departingFromLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[2]/div[1]/form/p[2]/label[2]/input";
    public String arrivingFromlocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[2]/div[2]/form/p[2]/label[2]/input";
    public String adultDropDownLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[3]/div/label[1]/select";
    public String childrenDropDownLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[3]/div/label[2]/select";
    public String infantsDropDownLocator = "html/body/div[5]/div/div/ul/li[3]/div/span/div/div[2]/div[3]/div/label[3]/select";
    //Visitor Chat window dimension
    public String chatWindowHeight1 = "chatWindowHeight1";
    public String chatWindowWidth1 = "chatWindowWidth1";
    public String chatWindowHeight2 = "chatWindowHeight2";
    public String chatWindowWidth2 = "chatWindowWidth2";
    //Active header
    public String header247assist = ".//*[@id='afv']/div/div/div/div/div[1]/h2";

    //Agent disposition form
    public String interactionRadioLocator = ".//*[@name='r1']";
    public String hintsLocator = ".//*[@id='basicInfo']/div[2]/div[1]/div";
    public String hintsSidePanelLocator = ".//*[@id='after_guest_id']/div[3]/div";
    public String nextOneLocator = ".//*[@id='nextOne']";
    public String onlineSessionCheckBoxLocator = ".//*[@id='onlineSession']/span[2]/div/div/div[1]";
    public String customerWasNtConvincedCheckBox = ".//*[@id='onlineSession']/span[2]/div/div/div[2]/label";
    public String customerSideCheckBox = ".//*[@id='onlineSession']/span[2]/div/div/div[3]/label";
    public String clarificationLocator = ".//*[@id='onlineSession']/div[1]/div[1]/textarea";
    public String ideaLocator = ".//*[@id='onlineSession']/div[2]/div/textarea";
    public String nextTwoLocator = ".//*[@id='nextTwo']";
    public String summaryLocator = ".//*[@id='summaryId']/textarea";
    public String submitButton = ".//*[@id='after_guest_id']/div[3]/div";
    public String InteractionStatus = "InteractionStatus";
    public String hint = "hint";
    public String clarrification = "clarrification";
    public String idea = "idea";


    //VisitorWindow
    public String closeButton = "#closeBtn";
    public String exitButton = "#quitButton";
    public String visitorSuggestionDropdown = ".//*[@id='feedbackForm']/div[1]/div[2]/center/label/select";
    public String visitorSuggestion = "visitorSuggestion";
    public String feedbackArea = ".//*[@id='feedbackForm']/div[1]/div[3]/div/textarea";
    public String feedback = "feedback";
    public String visitorEmailId = ".//*[@id='visitor_email']";
    public String visitorEmail = "visitorEmail";
    public String doneButton = ".//*[@id='feedbackForm']/div[2]/input";

    private Locator() {

    }

    public static Locator getLocatorInstance() {
        if (locator == null) {
            locator = new Locator();
        }
        return locator;
    }

}
