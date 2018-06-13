package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafariLinear {

	public static void main(String[] args) {
		WebDriver driver = new SafariDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();

		//Page 1 - HomePageImpl
		System.out.printf("Browser is: Safari;\n");
		driver.get("https://www.weightwatchers.com/us/");
		String mainTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
		System.out.println((driver.getTitle().equals(mainTitle))?"Page Title is correct":"Page Title is incorrect");
		
		//Page 2 - FindAMeeting
		String findMeatingTitle = "Get Schedules & Times Near You";
		String zipCode = "10011";
		driver.findElement(By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting")).click();
		wait.until(ExpectedConditions.titleContains(findMeatingTitle));
		System.out.println((driver.getTitle().contains(findMeatingTitle)?"Page Title is correct":"Page Title is incorrect"));	
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("meetingSearch"))));
		driver.findElement(By.id("meetingSearch")).clear();
		driver.findElement(By.id("meetingSearch")).sendKeys(zipCode);
		driver.findElement(By.xpath("//button[contains(@class, \"btn btn-default form-blue-pill__btn\")]")).click();
		
		// Page 3 - 
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("(//div[contains(@class, 'meeting-location__top')])[1]"))));
		driver.findElement(By.xpath("(//div[contains(@class, \"meeting-location__top\")])[1]")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, \"hours-list-item-wrapper hours-list--currentday\")]//div[contains(@ng-repeat, \"meeting in day.meetings\")]")));
		
		// Page 4
		System.out.println("\nTODAY`s hours of operation:");		
		List<WebElement>todaysHoursOfOperation = driver.findElements(By.xpath("//div[contains(@class, \"hours-list-item-wrapper hours-list--currentday\")]//div[contains(@ng-repeat, \"meeting in day.meetings\")]"));
		for(WebElement s:todaysHoursOfOperation) {
			System.out.println(s.getText());
		}
		driver.quit();
		
	}

}

