package core.pom;

import org.openqa.selenium.By;

public class Variables {
	
	static By find_a_meating_button = By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting");
	static By search_field = By.id("meetingSearch");
	static By first_searched_result = By.xpath("(//div[contains(@class, 'meeting-location__top')])[1]");
	static By first_searched_result_title = By.xpath("(//div[@class='meeting-location'])[1]//div[@class='location__top']//span");
	static By first_searched_result_distance = By.xpath("(//div[@class='meeting-location'])[1]//div[@class='location__top']//div[@class='location__distance']");
	static By todays_hours_of_operation = By.xpath(" //div[contains(@class, \"hours-list-item-wrapper hours-list--currentday\")]//div[contains(@ng-repeat, \"meeting in day.meetings\")]");
	static By actual_title_of_the_first_serched_result = By.xpath("//div[contains(@class, 'location__container')]//span");
	
}
