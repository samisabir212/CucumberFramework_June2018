package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver getDriver() {

		try {
			// read config
			ReadConfigFile file = new ReadConfigFile();
			String browserName = file.getBrowser();

			switch (browserName) {

			case "firefox":
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break; // breakout of the case
			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break; // breakout of the case

			case "safari":

				driver = new SafariDriver();
				driver.manage().window().maximize();
			}

		} catch (Exception e) {
			System.out.println("Unable to load browser :: " + e);
		} finally {

			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		}

		return driver;

	}

}
