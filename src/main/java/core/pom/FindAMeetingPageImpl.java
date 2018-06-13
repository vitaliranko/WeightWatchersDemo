package core.pom;

import static core.util.Config.getProperty;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class FindAMeetingPageImpl extends BasePage {

	private static final Logger LOG = Logger.getLogger(FindAMeetingPageImpl.class.getName());
	private String firstTitleNameExpected;

	@Step("Enter ZIP code")
	public FindAMeetingPageImpl setZipCode() {
		wait.until(ExpectedConditions.presenceOfElementLocated(Variables.search_field));
		driver.findElement(Variables.search_field).clear();
		driver.findElement(Variables.search_field).sendKeys(getProperty("zip") + Keys.ENTER);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(Variables.first_searched_result));
		return this;
	}

	@Step("Getting Title of the first search result")
	public FindAMeetingPageImpl getFirstTitleNameLabel() {

		firstTitleNameExpected = driver
				.findElement(Variables.first_searched_result_title)
				.getText();
		LOG.info(firstTitleNameExpected);
		return this;
	}

	@Step("Getting Distance of the first search result")
	public FindAMeetingPageImpl getFirstTitleDistLabel() {
		LOG.info(driver.findElement(Variables.first_searched_result_distance)
				.getText());
		return this;
	}
	
	@Step("Go to first serched result")
	public FindAMeetingPageImpl goToFirstTitle() {
		driver.findElement(Variables.first_searched_result)
				.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Variables.todays_hours_of_operation));
		return this;
	}
	@Step("Get title of the first searched resultin list")
	public String getFirstTitleNameExpected() {
		return firstTitleNameExpected;
	}
	@Step("Get actual title of the first searched result")
	public String getFirstTitleNameActual() {
		return driver.findElement(Variables.actual_title_of_the_first_serched_result).getText();
	}

	@Step("Printing today`s working hours")
	public FindAMeetingPageImpl printTodaysWorkHours() {
		LOG.info("\nTODAY`s hours of operation:");
		final By workHoursLabel = Variables.todays_hours_of_operation;
		for (WebElement s : driver.findElements(workHoursLabel)) {
			LOG.info(s.getText());
		}
		return this;
	}

}
