package core.pom;

import static core.util.Config.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePageImpl extends BasePage{

	@Step("Open home page")
	public HomePageImpl openPage() {
		
		driver.get(getProperty(URI));
		
		return this;
	}
	
	@Step("Go To Find A Meeting Page")
	public FindAMeetingPageImpl goToFindAMeetingPage() {
		
		driver.findElement(Variables.find_a_meating_button).click();
		wait.until(ExpectedConditions.titleContains(getProperty("title.2")));
		
		return new FindAMeetingPageImpl();
	}
	
}
