

package com.ilabs.afv.configuration; 

import com.ilabs.afv.locators.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

//This class uses the singleton design pattern to initialize the webdriver with the desired browser type 
public class DriverConfiguration {

	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	public WebDriver driver1;
	public WebDriver driver2;
	public WebDriver driver3;
	public WebDriver driver4;
	public WebDriver driver5;
	public WebDriver driver6;
	
	private static DriverConfiguration getInstance;

	private DriverConfiguration() {
	}

	public static DriverConfiguration getDriverInstance() {
		if (getInstance == null) {
			getInstance = new DriverConfiguration();
		}
		return getInstance;
	}

	// This method is used to initialize the first browser
	public void initializeDriverOne(String driver1) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
        if (System.getProperty("os.name").equals(
                Locator.getLocatorInstance().windowsOperatingSystem)) {

            if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                this.driver1 = new FirefoxDriver(cap);
            } else if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\chromedriver.exe");
                this.driver1 = new ChromeDriver(cap);
            } else if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
                System.setProperty("webdriver.ie.driver",
                        System.getProperty("user.dir")
                                + "\\IEDriverServer32.exe");
                this.driver1 = new InternetExplorerDriver(cap);
            } else {
                APPLICATION_LOGS.debug("Error Message----> "
                        + "driver type not mentioned properly");
            }
        } else if (System.getProperty("os.name").equals(
                Locator.getLocatorInstance().linuxOperatingSystem)) {
            if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                this.driver1 = new FirefoxDriver(cap);
            } else if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "//chromedriver");
                this.driver1 = new ChromeDriver(cap);
            } else {
                APPLICATION_LOGS.debug("Error Message----> "
                        + "driver type not mentioned properly");
            }
        } else if (System.getProperty("os.name").equals(
                Locator.getLocatorInstance().macOperatingSystem)) {
            if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                this.driver1 = new FirefoxDriver(cap);
            } else if (driver1
                    .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "//chromedriver");
                this.driver1 = new ChromeDriver(cap);
            } else if (driver1.equalsIgnoreCase(Locator.getLocatorInstance().macbrowser)) {
                this.driver1 = new SafariDriver(cap);

            } else if (System.getProperty("os.name").equals(
                    Locator.getLocatorInstance().windowsOperatingSystem8)) {
                if (driver1
                        .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                    this.driver1 = new FirefoxDriver(cap);
                } else if (driver1
                        .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "\\chromedriver.exe");
                    this.driver1 = new ChromeDriver(cap);
                } else if (driver1
                        .equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
                    System.setProperty("webdriver.ie.driver",
                            System.getProperty("user.dir")
                                    + "\\IEDriverServer32.exe");
                    this.driver1 = new InternetExplorerDriver(cap);
                } else {
                    APPLICATION_LOGS.debug("Error Message----> "
                            + "driver type not mentioned properly");
                }
            }
        }
    }

	// This method is used to initialize the second browser
    public void initializeDriverTwo(String driver2) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
        if (System.getProperty("os.name").equals(
                Locator.getLocatorInstance().windowsOperatingSystem)) {

            if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                this.driver2 = new FirefoxDriver(cap);
            } else if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\chromedriver.exe");
                this.driver2 = new ChromeDriver(cap);
            } else if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
                System.setProperty("webdriver.ie.driver",
                        System.getProperty("user.dir")
                                + "\\IEDriverServer32.exe");
                this.driver2 = new InternetExplorerDriver(cap);
            } else {
                APPLICATION_LOGS.debug("Error Message----> "
                        + "driver type not mentioned properly");
            }
        } else if (System.getProperty("os.name").equals(
                Locator.getLocatorInstance().linuxOperatingSystem)) {
            if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                this.driver2 = new FirefoxDriver(cap);
            } else if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "//chromedriver");
                this.driver2 = new ChromeDriver(cap);
            } else {
                APPLICATION_LOGS.debug("Error Message----> "
                        + "driver type not mentioned properly");
            }
        } else if (System.getProperty("os.name").equals(
                Locator.getLocatorInstance().macOperatingSystem)) {
            if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                this.driver2 = new FirefoxDriver(cap);
            } else if (driver2
                    .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "//chromedriver");
                this.driver2 = new ChromeDriver(cap);
            } else if (driver2.equalsIgnoreCase(Locator.getLocatorInstance().macbrowser)) {
                this.driver2 = new SafariDriver(cap);

            } else if (System.getProperty("os.name").equals(
                    Locator.getLocatorInstance().windowsOperatingSystem8)) {
                if (driver2
                        .equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
                    this.driver2 = new FirefoxDriver(cap);
                } else if (driver2
                        .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "\\chromedriver.exe");
                    this.driver2 = new ChromeDriver(cap);
                } else if (driver2
                        .equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
                    System.setProperty("webdriver.ie.driver",
                            System.getProperty("user.dir")
                                    + "\\IEDriverServer32.exe");
                    this.driver2 = new InternetExplorerDriver(cap);
                } else {
                    APPLICATION_LOGS.debug("Error Message----> "
                            + "driver type not mentioned properly");
                }
            }
        }
    }

public void initializeDriverThree(String driver3){
	DesiredCapabilities cap= new DesiredCapabilities();
	cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
	if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().windowsOperatingSystem)) {
		if (driver3.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver3 = new FirefoxDriver(cap);
		} else if (driver3.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\chromedriver.exe");
			this.driver3 = new ChromeDriver(cap);
		} else if (driver3.equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\IEDriverServer32.exe");
			this.driver3 = new InternetExplorerDriver(cap);
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}

	} else if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().linuxOperatingSystem)) {
		if (driver3	.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver3 = new FirefoxDriver(cap);
		} else if (driver3.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//chromedriver");
			this.driver3 = new ChromeDriver(cap);
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}
	}
	else if (System.getProperty("os.name").equals(
            Locator.getLocatorInstance().macOperatingSystem)) {
        if (driver3.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
            this.driver3 = new FirefoxDriver(cap);
        } else if (driver3
                .equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "//chromedriver");
            this.driver3 = new ChromeDriver(cap);
        } else {
            APPLICATION_LOGS.debug("Error Message----> "
                    + "driver type not mentioned properly");
        }
	}
}

public void initializeDriverFour(String driver4){
	DesiredCapabilities cap= new DesiredCapabilities();
	cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
	if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().windowsOperatingSystem)) {
		if (driver4.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver4 = new FirefoxDriver(cap);
		} else if (driver4.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\chromedriver.exe");
			this.driver4 = new ChromeDriver(cap);
		} else if (driver4.equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\IEDriverServer32.exe");
			this.driver4 = new InternetExplorerDriver(cap);
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}

	} else if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().linuxOperatingSystem)) {
		if (driver4	.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver4 = new FirefoxDriver(cap);
		} else if (driver4.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//chromedriver");
			this.driver4 = new ChromeDriver(cap);
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}
	}
	
}

public void initializeDriverFive(String driver5){
	if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().windowsOperatingSystem)) {
		if (driver5.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver5 = new FirefoxDriver();
		} else if (driver5.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\chromedriver.exe");
			this.driver5 = new ChromeDriver();
		} else if (driver5.equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\IEDriverServer32.exe");
			this.driver5 = new InternetExplorerDriver();
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}

	} else if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().linuxOperatingSystem)) {
		if (driver5	.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver5 = new FirefoxDriver();
		} else if (driver5.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//chromedriver");
			this.driver5 = new ChromeDriver();
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}
	}
	
}

public void initializeDriverSix(String driver6){
	if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().windowsOperatingSystem)) {
		if (driver6.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver6 = new FirefoxDriver();
		} else if (driver6.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\chromedriver.exe");
			this.driver6 = new ChromeDriver();
		} else if (driver6.equalsIgnoreCase(Locator.getLocatorInstance().internetExplorerbrowser)) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\IEDriverServer32.exe");
			this.driver6 = new InternetExplorerDriver();
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}

	} else if (System.getProperty("os.name").equals(
			Locator.getLocatorInstance().linuxOperatingSystem)) {
		if (driver6	.equalsIgnoreCase(Locator.getLocatorInstance().firefoxBrowser)) {
			this.driver6 = new FirefoxDriver();
		} else if (driver6.equalsIgnoreCase(Locator.getLocatorInstance().chromeBrowser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//chromedriver");
			this.driver6 = new ChromeDriver();
		} else {
			APPLICATION_LOGS.debug("Error Message----> "
					+ "driver type not mentioned properly");
		}
	}
	
}
}