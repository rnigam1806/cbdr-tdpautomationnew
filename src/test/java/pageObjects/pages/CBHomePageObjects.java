
package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ExplicitWaiting;
import org.testng.Assert;


import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.RandomGenerator;


public class CBHomePageObjects extends PageFactoryInitializer
{
	

	@FindBy(xpath="//app-root/div/app-homepage/cbd-searchbar/div/button")
	private WebElement SearchBarButton;

	
	
	
	public CBHomePageObjects verifyPageTitle() throws Exception 
	{
		utils.ExplicitWaiting.explicitWaitVisibilityOfElement(SearchBarButton,10);
		Assert.assertEquals(getWebDriver().getTitle(), "Homepage");
		return this;
	}

}
