package core;
import static core.pom.BasePage.*;
import static core.util.Config.getProperty;

import org.testng.annotations.Test;

import core.pom.FindAMeetingPageImpl;
import core.pom.HomePageImpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoTest {
	
	@BeforeMethod
	  public void beforeMethod() {
		
		setDriver("SAFARI");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  getDriver().quit();
	  }
	
  @Test()
  public void question2Test() {
	  
	  HomePageImpl homePageImpl = new HomePageImpl();
	  
	  String title1 = homePageImpl
			  .openPage()
			  .getTitle();
	  
	 FindAMeetingPageImpl findAMeetingPageImpl = homePageImpl
			 .goToFindAMeetingPage()
			 .setZipCode();
	 
			 findAMeetingPageImpl
			 .getFirstTitleNameLabel()
			 .getFirstTitleDistLabel()
			 .goToFirstTitle()
			 .printTodaysWorkHours();
			 
			 
	  assertThat(title1, describedAs("Incorrect page title", is(getProperty("title.1"))));
	  assertThat(findAMeetingPageImpl.getFirstTitleNameActual(), describedAs("Incorrect page title", is(findAMeetingPageImpl.getFirstTitleNameExpected())));
  }
  
}
