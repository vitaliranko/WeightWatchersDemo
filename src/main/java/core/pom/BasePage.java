package core.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static final Logger LOG = Logger.getLogger(BasePage.class.getName());
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public static final WebDriver getDriver() {
		return driver;
	}

	public static final void setDriver(String webDriverType) {

		switch (webDriverType.toUpperCase()) {

		case "CHROME": {
			// BasePage.driver = driver;
			break;
		}

		case "SAFARI": {
			BasePage.driver = new SafariDriver();

			LOG.info("Browser is: Safari;\n");
			break;
		}

		}

		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}

	public String getTitle() {

		return driver.getTitle();
	}
}
