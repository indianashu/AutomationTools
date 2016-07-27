
package com.ilabs.afv.keywords;

import com.google.common.base.Predicate;
import com.ilabs.afv.configuration.DriverConfiguration;
import com.ilabs.afv.locators.InteractionStatus;
import com.ilabs.afv.locators.Locator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This class uses the keyword driven approach to run methods based on the keyword type supplied by the test case
public class Keywords {

    private static Keywords keywords;

    private Keywords() {

    }

    public static Keywords getKeywordInstance() {
        if (keywords == null) {
            keywords = new Keywords();
        }
        return keywords;
    }

    // This method is used to launch the first browser
    public void launchBrowserOne(String browserType) {
        DriverConfiguration.getDriverInstance()
                .initializeDriverOne(browserType);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Launching the first browser --> " + browserType + "****");
    }

    // This method is used to launch the second browser
    public void launchBrowserTwo(String browserType) {
        DriverConfiguration.getDriverInstance()
                .initializeDriverTwo(browserType);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Launching the second browser --> " + browserType + "****");
    }

    // This method is used to launch the third browser
    public void launchBrowserThree(String browserType) {
        DriverConfiguration.getDriverInstance()
                .initializeDriverThree(browserType);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Launching the second browser --> " + browserType + "****");
    }


    // This method is used to navigate to a particular url
    public void navigateToTheUrl(WebDriver driver, String url) {
        driver.get(url);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Navigating to the URL --> " + url + "****");
    }

    public void navigateToTheUrl(WebDriver driver, String url, String sessionKey) {
        driver.get(url + sessionKey);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Navigating to the URL --> " + url + sessionKey + "****");
    }

    // This method is used to enter data in text field
    public void enterDataInTextField(WebDriver driver, String locator,
                                     String data) {
        driver.findElement(By.cssSelector(locator)).sendKeys(data);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Entering value --> "
                + driver.findElement(By.cssSelector(locator)).getAttribute(
                "value") + " into the text field" + "****");
    }

    // This method is used to enter data in text field
    public void enterDataInTextFieldbyInt(WebDriver driver, String locator,
                                          String data) {
        driver.findElement(By.cssSelector(locator)).sendKeys(data);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Entering value --> "
                + driver.findElement(By.cssSelector(locator)).getAttribute(
                "value") + " into the text field" + "****");
    }

    public void enterDataInTextField(WebDriver driver, String locator,
                                     Keys key) {
        driver.findElement(By.cssSelector(locator)).sendKeys(key);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Entering value --> "
                + driver.findElement(By.cssSelector(locator)).getAttribute(
                "value") + " into the text field" + "****");
    }

    public void enterDataInTextFieldByXpath(WebDriver driver, String locator,
                                            String key) {
        driver.findElement(By.xpath(locator)).sendKeys(key);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Entering value --> "
                + driver.findElement(By.xpath(locator)).getAttribute(
                "value") + " into the text field" + "****");
    }

    // This method is used to clear data entered in the text field
    public void clearDataInTextField(WebDriver driver, String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
        //driver.findElement(By.cssSelector(locator)).sendKeys(Keys.TAB);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clearing value --> "
                + driver.findElement(By.xpath(locator)).getAttribute(
                "value") + " from the text field" + "****");
    }

    // This method is used to clear data entered in the text field
    public void clearDataInTextFieldByXpath(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).clear();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clearing value --> "
                + driver.findElement(By.xpath(locator)).getAttribute(
                "value") + " from the text field" + "****");
    }

    // This method is used to fetch the label name
    public String fetchLabelName(WebDriver driver, String locator) {
        String labelName = driver.findElement(By.cssSelector(locator))
                .getText();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fetching label name --> " + labelName + "****");
        return labelName;
    }

    // This method is used to fetch the label name
    public String fetchLabelNamebyXpath(WebDriver driver, String locator) {
        String labelName = driver.findElement(By.xpath(locator))
                .getText();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fetching label name --> " + labelName + "****");
        return labelName;
    }

    // This method is used to fetch data entered in the text field
    public String fetchDataFromTextField(WebDriver driver, String locator) {
        String data = driver.findElement(By.cssSelector(locator)).getAttribute(
                "value");
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fetching value --> "
                + driver.findElement(By.cssSelector(locator)).getAttribute(
                "value") + " from the text field" + "****");
        return data;
    }


    // This method is used to fetch data entered in the text field
    public String fetchDataFromTextFieldByXpath(WebDriver driver, String locator) {
        String data = driver.findElement(By.xpath(locator)).getAttribute(
                "value");
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fetching value --> "
                + driver.findElement(By.xpath(locator)).getAttribute(
                "value") + " from the text field" + "****");
        return data;
    }

    //This method is used to return a boolean value in terms of string for the disbaled attribute of a field
    public String fetchDisabledAttribute(WebDriver driver, String locator) {
        String isDisabled = driver.findElement(By.cssSelector(locator)).getAttribute("disabled");
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "This text field's disabled status is  --> "
                + driver.findElement(By.cssSelector(locator)).getAttribute(
                "disabled") + "****");
        return isDisabled;
    }

    // This method is used to click on a link
    public void clickOnLink(WebDriver driver, String locator) {
        driver.findElement(By.cssSelector(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the link" + "****");
    }

    // This method is used to click on a link
    public void clickOnLinkbyXpath(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the link" + "****");
    }

    // This method is used to click on a button
    public void clickOnButton(WebDriver driver, String locator) {
        driver.findElement(By.cssSelector(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the button" + "****");

    }

    // This method is used to click on a button
    public void clickOnButtonByXpath(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the button" + "****");

    }

    // This method is used to click on a radio button
    public void clickOnRadioButton(WebDriver driver, String locator) {
        driver.findElement(By.cssSelector(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the radio button" + "****");
    }

    // This method is used to click on a checkbox button
    public void clickOnCheckBox(WebDriver driver, String locator) {
        driver.findElement(By.cssSelector(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the radio button" + "****");
    }

    // This method is used to click on a checkbox button
    public void clickOnCheckBoxByXpath(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the checkbox" + "****");
    }

    // This method is used to choose value from a dropdown
    public void chooseValueFromDropdown(WebDriver driver, String locator,
                                        String data) {
        driver.findElement(By.cssSelector(locator)).sendKeys(data);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Choosing the value --> " + data + " from drop down field"
                + "****");
    }

    public void chooseValueFromDropdownbyXpath(WebDriver driver, String locator,
                                               String data) {
        driver.findElement(By.xpath(locator)).sendKeys(data);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Choosing the value --> " + data + " from drop down field"
                + "****");
    }

    public void chooseValueFromDropdownbyXpathlocator(WebDriver driver, String locator,
                                                      String locator1) {
        driver.findElement(By.xpath(locator)).sendKeys(locator1);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Choosing the value --> " + locator1 + " from drop down field"
                + "****");
    }

    // This method is used to switch to a frame
    public void switchToFrame(WebDriver driver) {
        driver.switchTo().frame(0);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Switching to a frame" + "****");
    }

    // This method is used to switch to a frame
    public void switchToFramewithID(WebDriver driver, String Id) {
        driver.switchTo().frame(Id);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Switching to a frame" + "****");
    }


    // This method is used to get last agent text from agent console
    public String GetLastAgentText(WebDriver driver) {
        Keywords.getKeywordInstance().switchToFramewithID(driver, "chat_win");

        List<WebElement> Elements = driver.findElements(By.cssSelector(Locator.getLocatorInstance().returnAgentText));

        String GetText = Elements.get(Elements.size() - 1).getText();

        Keywords.getKeywordInstance().switchToDefaultContent(driver);

        return GetText;

    }

    public String fetchLabelOfOptionsByXpath(WebDriver driver, String groupLocator, int option) {
        List<WebElement> radios = driver.findElements(By.xpath(groupLocator));
        String label = "";
        if (option > 0 && option <= radios.size()) {

            label = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", radios.get(option - 1));

        } else {
            throw new NotFoundException("option " + option + " not found");
        }
        return label;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    // This method is used to get no of apps pushed by the agent
    public int GetAgentAppElementCount(WebDriver driver) {
        Keywords.getKeywordInstance().switchToFramewithID(driver, "chat_win");
        List<WebElement> Elements = driver.findElements(By.id("comp-detail-info"));
        int count = 0;
        for (WebElement e : Elements) {
            count++;
        }
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Get Agent App element count" + "****");

        return count;
    }

    // This method is used to get no of apps displayed on visitor chat window
    public int GetVisitorAppElementCount(WebDriver driver) {
        Keywords.getKeywordInstance().switchToFramewithID(driver, "ClientView");
        List<WebElement> Elements = driver.findElements(By.id("comp-detail-info"));
        int count = 0;
        for (WebElement e : Elements) {
            count++;
        }
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Get visitor App element count" + "****");

        return count;
    }

    // Returns the text of all elements present in the following frame with frameId
    public List<String> GetAppTextSource(WebDriver driver, String frameId) {
        Keywords.getKeywordInstance().switchToFramewithID(driver, frameId);
        List<WebElement> Elements = driver.findElements(By.id("comp-detail-info"));
        List<String> appSource = new ArrayList<String>();
        for (WebElement e : Elements) {
            appSource.add(e.getText());

        }
        return appSource;
    }

    // Returns the text of all elements present in the following frame with frameId
    public List<String> GetLastFormHTMLSource(WebDriver driver, String frameId) {
        Keywords.getKeywordInstance().switchToFramewithID(driver, frameId);
        List<WebElement> Elements = driver.findElements(By.className("form_container"));
        List<String> appSource = new ArrayList<String>();
        for (WebElement e : Elements) {
            appSource.add(e.getAttribute("innerHTML"));

        }
        return appSource;

    }

    //Switch to the window with the following windowTitle
    public void switchToWindowWithTitle(WebDriver driver, String windowTitle) {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(windowTitle)) {
                return;
            }
        }
    }

    //This method is used to check whether the Element is displayed /not
    public boolean isElementDisplayed(WebDriver driver, String locator) throws InterruptedException {
        WebElement element;
        boolean status = false;
        for (int i = 5; i > 0; i--) {
            try {
                element = driver.findElement(By.className(locator));
                if (element.isDisplayed())
                    status = true;

            } catch (Exception e) {
                Thread.sleep(1000);
                element = driver.findElement(By.className(locator));
                if (element.isDisplayed())
                    status = true;
            }
        }
        return status;
    }

    //This method gets the dimension of a frame in the form (width,height)
    public Dimension getFrameSize(WebDriver driver, String frameId) {
        WebElement frame = driver.findElement(By.id(frameId));
        String style = frame.getAttribute("style");
        Pattern heightPattern = Pattern.compile("height\\s*:\\s*\\d+\\s*px");
        Pattern widthPattern = Pattern.compile("width\\s*:\\s*\\d+\\s*px");
        Matcher heightMatcher = heightPattern.matcher(style);
        Matcher widthMatcher = widthPattern.matcher(style);
        String height = "0";
        String width = "0";
        if (heightMatcher.find()) {
            height = heightMatcher.group(0).replaceAll("[^0-9]", "");

        }
        if (widthMatcher.find()) {
            width = widthMatcher.group(0).replaceAll("[^0-9]", "");
        }

        return new Dimension(Integer.valueOf(height), Integer.valueOf(width));
    }

    // This method is used to click an item present in dropdown traits
    public void clickOnCustomerTrait(WebDriver driver, String locator, String trait) {
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }

        int i = 1;
        for (WebElement e : elements) {
            if (e.getText().trim().equalsIgnoreCase(trait.trim())) {
                driver.findElement(By.xpath(locator + "[" + i + "]")).click();
            }
            i++;
        }
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Click on customer trait" + "****");

    }

    // This method is used to check whether the visitorTrait contains the following trait
    public boolean containsVisitorTrait(WebDriver driver, String trait) {

        List<WebElement> elements = driver.findElements(By.xpath(Locator.getLocatorInstance().visitorTrait));

        for (WebElement e : elements) {
            if (e.getText().trim().equalsIgnoreCase(trait.trim() + ",")) {
                DriverConfiguration.APPLICATION_LOGS.debug("****"
                        + "contains Visitor Trait" + "****");
                return true;
            }

        }
        return false;
    }

    // This method is used to click on the dropdown. This will not select the dropdown item
    public void clickOnDropdownByXpath(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Click on DropDown list" + "****");
    }

    // This method is used to check whether the dropdown list contains the following element
    public boolean isElementPresentInDropdownByXpath(WebDriver driver, String locator, String element) {
        Select select = new Select(driver.findElement(By.xpath(locator)));
        for (WebElement e : select.getOptions()) {
            if (e.getText().trim().equalsIgnoreCase(element)) {
                return true;
            }
        }

        return false;
    }

    //This method returns the first selected option from Dropdown list
    public String getSelectedOptionFromDropdownByXpath(WebDriver driver, String locator) {
        Select select = new Select(driver.findElement(By.xpath(locator)));

        DriverConfiguration.APPLICATION_LOGS.debug("****"

                + "getSelectedOptionFromDropdownByXpath" + "****");

        return select.getFirstSelectedOption().getText().toString();
    }

    // This method is used to check whether the element is present /not
    public boolean isElementPresentByXpath(WebDriver driver, String locator) {
        boolean status = driver.findElement(By.xpath(locator)).isDisplayed();

        DriverConfiguration.APPLICATION_LOGS.debug("****"

                + "isElementPresentByXpath status:" + status + "****");
        return status;
    }

    // This method is used to get the no of items in dropdown.
    public int countOfElementPresentInDropdownByXpath(WebDriver driver, String locator) {
        Select select = new Select(driver.findElement(By.xpath(locator)));
        int count = 0;
        for (WebElement e : select.getOptions()) {
            count++;
        }

        return count;
    }

    // This method is used to get the no of items in a panel.
    public int countOfElementPresentInPanelByXpath(WebDriver driver, String locator) {
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElement(By.xpath(locator)).findElements(By.tagName("li"));

        return elementList.size();
    }

    // This method is used to click on an image specified by xpath
    public void clickOnImageButtonByXpath(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        if (element.isDisplayed()) {
            element.click();
            DriverConfiguration.APPLICATION_LOGS.debug("****"
                    + "Click on image button" + "****");
        } else {
            DriverConfiguration.APPLICATION_LOGS.debug("****"
                    + "Image button is not displayed" + "****");
        }

    }

    //This method fetches the list of notes from notepad specified by noteId
    public List<String> fetchTextFromNotePad(WebDriver driver, String noteId) {
        List<WebElement> element = driver.findElement(By.id(noteId)).findElements(By.tagName("div"));
        List<String> notes = new ArrayList<String>();
        for (WebElement e : element)
            notes.add(e.getText());
        return notes;
    }

    public List<String> fetchSourceOfAllImageElement(WebDriver driver) {

        List<WebElement> element = driver.findElements(By.tagName("img"));
        List<String> imgSrc = new ArrayList<String>();
        for (WebElement e : element) {
            String src = e.getAttribute("src");
            imgSrc.add(src);
        }
        return imgSrc;
    }

    public void selectDropdownItem(WebDriver driver, String locator, String item) {
        //  Select select = new Select(DriverConfiguration.getDriverInstance().driver.findElement(By.xpath(locator)));
        // select.selectByVisibleText(item);
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElement(By.xpath(locator)).findElements(By.tagName("li"));
        System.out.println("Element list in Dropdown = ");

        for (WebElement e : elementList) {

            System.out.println(e.getText());
            if (e.getText().trim().equals(item.trim())) {
                e.click();

            }
        }

    }

    public void selectRadioButtonInAGroup(WebDriver driver, String groupLocator, int option) {
        List<WebElement> radios = driver.findElements(By.xpath(groupLocator));
        if (option > 0 && option <= radios.size()) {
            radios.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found");
        }
    }

    public int getInteractionValueByName(String interaction) {
        if (interaction.contains("Initial inquiry")) {
            return InteractionStatus.INITIAL_INQUIRY.getValue();
        } else if (interaction.contains("Decisioning stage")) {
            return InteractionStatus.DECISIONING_STAGE.getValue();
        } else if (interaction.contains("Looking for deal/discount")) {
            return InteractionStatus.LOOKING_FOR_DEAL_DISCOUNT.getValue();
        } else if (interaction.contains("Can close with follow-up")) {
            return InteractionStatus.CAN_CLOSE_WITH_FOLLOW_UP.getValue();
        } else if (interaction.contains("Sale")) {
            return InteractionStatus.SALE.getValue();
        } else if (interaction.contains("Uncertain/No-Sale")) {
            return InteractionStatus.UNCERTAIN_NO_SALE.getValue();
        } else
            return 0;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // This method is used to get last visitor text from agent console
    public String GetLastVisitorText(WebDriver driver) {
        Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "chat_win");

        List<WebElement> Elements = DriverConfiguration.getDriverInstance().driver1.findElements(By.cssSelector(Locator.getLocatorInstance().returnVisitorText));

        String GetText = Elements.get(Elements.size() - 1).getText();

        Keywords.getKeywordInstance().switchToDefaultContent(DriverConfiguration.getDriverInstance().driver1);

        return GetText;

    }

    // This method is used to get last agent text from visitor console
    public String GetLastAgentTextVC(WebDriver driver) {
        Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "ClientView");

        List<WebElement> Elements = DriverConfiguration.getDriverInstance().driver1.findElements(By.cssSelector(Locator.getLocatorInstance().returnAgentText));

        String GetText = Elements.get(Elements.size() - 1).getText();

        Keywords.getKeywordInstance().switchToDefaultContent(DriverConfiguration.getDriverInstance().driver1);

        return GetText;

    }


    // This method is used to get last visitor text from visitor console
    public String GetLastVisitorTextVC(WebDriver driver) {
        Keywords.getKeywordInstance().switchToFramewithID(DriverConfiguration.getDriverInstance().driver1, "ClientView");

        List<WebElement> Elements = DriverConfiguration.getDriverInstance().driver1.findElements(By.cssSelector(Locator.getLocatorInstance().returnVisitorText));

        String GetText = Elements.get(Elements.size() - 1).getText();

        Keywords.getKeywordInstance().switchToDefaultContent(DriverConfiguration.getDriverInstance().driver1);

        return GetText;

    }

    // This method is used to switch to default content
    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Switching to default content" + "****");
    }

    // This method is used to select item from Dropdown
    public void selctItemfromDropDown(WebDriver driver, String locator, String item) {
        Select select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(item);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Select item from dropdown" + "****");
    }

    // This method is used to switch to default content
    public void switchToWindow(WebDriver driver, String data) {
        driver.switchTo().window(data);
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Switching to default content" + "****");
    }

    // This method is used to click on an element which is visible only after
    // certain interactions take place on its descendants
    public void clickOnComplexMouseInteractions(WebDriver driver, String locator) {
        WebElement slidemenu = driver.findElement(By.cssSelector(locator));
        Actions act = new Actions(driver);
        act.moveToElement(slidemenu).build().perform();
        slidemenu.click();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Clicking on the slide through menu" + "****");
    }

    // This method is used to choose an option after clicking on a particular
    // location from dropdown
    public void mouseAction(WebDriver driver, String locator1, String locator2) throws InterruptedException {
        Actions act = new Actions(driver);
        WebElement ele1 = driver.findElement(By.cssSelector(locator1));
        WebElement ele2 = driver.findElement(By.cssSelector(locator2));
        Thread.sleep(5000);
        act.moveToElement(ele1).click().perform();
        Thread.sleep(2000);
        ele2.click();
    }

    public List<WebElement> getList(WebDriver driver, String elementType) {
        List<WebElement> check = driver.findElements(By.className(elementType));
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fetching a List of size " + check.size() + "****");
        return check;
    }

    public List<WebElement> getTagSize(WebDriver driver, String tagName) {
        List<WebElement> check = driver.findElements(By.tagName(tagName));
        /*DriverConfiguration.APPLICATION_LOGS.debug("****"
				+ "Fetching a List of size " + check.size() + "****");*/
        return check;
    }

    // This method is used to close the browsers
    public void closeBrowsers(WebDriver driver1, WebDriver driver2) {
        driver1.quit();
        driver2.quit();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Closing both the browsers" + "****");
    }

    // This method is used to close the browsers
    public void closeBrowser(WebDriver driver1) {
        driver1.quit();
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Closing both the browsers" + "****");
    }

    // This method is used to accept an alert message
    public void acceptAlert(WebDriver driver) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Accepting the alert message " + "****");
        driver.switchTo().alert().accept();

    }

    // This method is used to dismiss an alert message
    public void dismissAlert(WebDriver driver) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Rejecting the alert message " + "****");
        driver.switchTo().alert().dismiss();

    }

    // This method is used to manage timeouts
    public void manageTimeout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // This method is used to maximize the window
    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    // This method is used to fetch text from an alert message
    public String getAlertMessage(WebDriver driver) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fetching the text " + driver.switchTo().alert().getText()
                + " from the alert message " + "****");
        return driver.switchTo().alert().getText();
    }

    // This method is used to execute a javascript function directly
    public void executeJavascript(WebDriver driver, String javascript) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function " + javascript + "****");
        ((JavascriptExecutor) driver).executeScript(javascript);
    }

    // This method is used to execute a javascript function with return value
    public Object executeJavascriptWithReturn(WebDriver driver,
                                              String javascript) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function with a return value "
                + javascript + "****");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(javascript);

    }

    // This method is used to scroll down a window using javascript
    public void executeJavascriptWindowScroller(WebDriver driver,
                                                String javascript, int x, int y) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function for window scroller "
                + javascript + "****");
        javascript = javascript + "(" + x + "," + y + ")";
        ((JavascriptExecutor) driver).executeScript(javascript);
    }

    //This method is used to fetch text from a page
    public String executeJavascriptToFetchValue(WebDriver driver, String javascript, int indexValue) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function for fetching a value "
                + javascript + "****");
        Object o = ((JavascriptExecutor) driver).executeScript(javascript);
        List<WebElement> li = (List<WebElement>) o;

        return li.get(indexValue - 1).getText();
    }


    //This method is used to fetch text from a page
    public String executeJavascriptToFetchValueFromDisabledField(WebDriver driver, String javascript) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function for fetching a value "
                + javascript + "****");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object textvalue = js.executeScript(javascript);

        return textvalue.toString();
    }

    // This method is used to close a single browser
    public void quitDriver(WebDriver driver) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Closing a single browser" + "****");
        driver.quit();
    }

    //This method is used for fluent wait
    public void FluentWait(final WebDriver driver, String locator) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fluently waiting " + "****");
        FluentWait<By> fluentWait = new FluentWait<By>(By.cssSelector(locator));
        fluentWait.pollingEvery(5, TimeUnit.SECONDS);
        fluentWait.withTimeout(40, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(By by) {
                try {
                    return driver.findElement(by).isDisplayed();
                } catch (NoSuchElementException ex) {
                    return false;
                }
            }
        });
    }


    public void fluentWaitPageLoad(final WebDriver driver, final String locator, final String value) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fluently waiting for the page to load " + "****");
        FluentWait<By> fluentWait = new FluentWait<By>(By.cssSelector(locator));
        fluentWait.pollingEvery(5, TimeUnit.SECONDS);
        fluentWait.withTimeout(40, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(By by) {
                try {
                    return driver.findElement(By.cssSelector(locator)).getText().equalsIgnoreCase(value);
                } catch (NoSuchElementException ex) {
                    return false;
                }
            }
        });

    }

    public void fluentWaitPageLoadByXpath(final WebDriver driver, final String locator, final String value) {
        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Fluently waiting for the page to load " + "****");
        FluentWait<By> fluentWait = new FluentWait<By>(By.xpath(locator));
        fluentWait.pollingEvery(5, TimeUnit.SECONDS);
        fluentWait.withTimeout(40, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(By by) {
                try {
                    return driver.findElement(By.cssSelector(locator)).getText().equalsIgnoreCase(value);
                } catch (NoSuchElementException ex) {
                    return false;
                }
            }
        });

    }

    // This method is used to copy value from one field and paste in to another
    // field
    public void copyPasteValue(String valueCopyLocator,
                               String valuePasteLocator, WebDriver driver, String OS) throws InterruptedException {

        if (OS.equals(Locator.getLocatorInstance().windowsOperatingSystem) || OS.equals(Locator.getLocatorInstance().linuxOperatingSystem)) {
            driver.findElement(By.cssSelector(valueCopyLocator)).sendKeys(
                    Keys.LEFT_CONTROL + "a");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(valueCopyLocator)).sendKeys(
                    Keys.LEFT_CONTROL + "c");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(valuePasteLocator)).sendKeys(
                    Keys.LEFT_CONTROL + "v");
            Thread.sleep(2000);
            DriverConfiguration.APPLICATION_LOGS.debug("****"
                    + "Copying the value: "
                    + driver.findElement(By.cssSelector(valueCopyLocator))
                    .getAttribute("value")
                    + " and pasting it into another field"
                    + " ,the value in the pasted field is: "
                    + driver.findElement(By.cssSelector(valuePasteLocator))
                    .getAttribute("value") + "****");
        } else {

            driver.findElement(By.cssSelector(valueCopyLocator)).sendKeys(
                    Keys.COMMAND + "a");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(valueCopyLocator)).sendKeys(
                    Keys.COMMAND + "c");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(valuePasteLocator)).sendKeys(
                    Keys.COMMAND + "v");
            Thread.sleep(2000);
            DriverConfiguration.APPLICATION_LOGS.debug("****"
                    + "Copying the value: "
                    + driver.findElement(By.cssSelector(valueCopyLocator))
                    .getAttribute("value")
                    + " and pasting it into another field"
                    + " ,the value in the pasted field is: "
                    + driver.findElement(By.cssSelector(valuePasteLocator))
                    .getAttribute("value") + "****");

        }
    }


    final public String getNewWindow(WebDriver driver, int timeout) throws Exception {
        String main = driver.getWindowHandle();
        System.out.println("MAIN =" + main);
        //Set<String> st=null;
        Set<String> st = null;
        String newst = null;
        int i = 0;
        timeout = timeout * 1000;
        while (i < timeout) {
            st = driver.getWindowHandles();
            final Iterator<String> e = st.iterator();
            newst = null;
            System.out.println("TIME = " + (i * 1000));
            while (e.hasNext()) {
                newst = e.next();
                System.out.println("got in here - WINDOWS -" + newst);
                if (main.equals(newst)) {
                    continue;
                } else {
                    System.out.println("got a new handle" + newst);
                    return newst;
                }
            }
            System.out.println("sleeping");
            Thread.sleep(500);
            i = i + 500;
        }
        return "";
    }

    /**
     * Used to switch to a new popup window like an authentication dialog.
     *
     * @param title   Title of the window to search for.
     * @param timeout The time to search for the window.
     * @throws Exception When window is not found.
     */
    final public void switchToWindowTitle(WebDriver driver, final String title, int timeout) throws Exception {
        final String main = driver.getWindowHandle();
        Set<String> st = null;
        String newst = null;
        Iterator<String> e = null;
        int i = 0;
        timeout = timeout * 1000;
        while (i < timeout) {
            st = driver.getWindowHandles();
            e = st.iterator();
            newst = null;
            while (e.hasNext()) {
                newst = e.next();
                if (main.equals(newst)) {
                    continue;
                } else {
                    driver.switchTo().window(newst);
                    if (driver.getTitle().equals(title))
                        return;
                    else
                        driver.switchTo().window(main);
                }
            }
            Thread.sleep(500);
            i = i + 500;
        }
        throw new Exception("Didnt get Window with TITLE=" + title);
    }

    public void ContinueSessionCobrowse(String Key, WebDriver driver) {

        String jsCSCobrowse = "ContinueSession('" + Key + ";cobrowse')";

        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function " + jsCSCobrowse + "****");
        ((JavascriptExecutor) driver).executeScript(jsCSCobrowse);
    }

    public void ContinueSessionCoview(String Key, WebDriver driver) {

        String jsCSCoview = "ContinueSession('" + Key + ";coview')";

        DriverConfiguration.APPLICATION_LOGS.debug("****"
                + "Executing the javascript function " + jsCSCoview + "****");
        ((JavascriptExecutor) driver).executeScript(jsCSCoview);
    }


}


