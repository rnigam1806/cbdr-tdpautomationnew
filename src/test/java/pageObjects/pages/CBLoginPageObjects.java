package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;
import utils.ExplicitWaiting;


public class CBLoginPageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//input[@id='cbsys_login_email']")
	private WebElement emailIDTextBox;
	
	@FindBy(xpath="//input[@id='cbsys_login_password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='btnsigninemp']")
	private WebElement signInButton;

	@Step("Log into On CareerBuilder Home Page")
	public CBLoginPageObjects enterEmailID(String emailID,String password) throws Exception
	{
		AllureAttachments.saveWebElement(getWebDriver(), emailIDTextBox);
		AllureAttachments.saveWebElement(getWebDriver(), passwordTextBox);
		AllureAttachments.saveWebElement(getWebDriver(), signInButton);
		emailIDTextBox.sendKeys(emailID);	
		passwordTextBox.sendKeys(password);
		signInButton.click();
		
		AllureAttachments.attachFileType_XLSX(ExcelFiles + "TestData.xlsx");
		return this;
	}

	@Step("Verify Page Title of CareerBuilder Home Page")
	public CBLoginPageObjects verifyPageTitle() throws Exception 
	{
		Assert.assertEquals(getWebDriver().getTitle(), "Homepage");
		return this;
	}
	
	
	
}
