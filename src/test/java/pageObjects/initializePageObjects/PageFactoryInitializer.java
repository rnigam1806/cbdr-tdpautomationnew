/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.CBHomePageObjects;
import pageObjects.pages.CBLoginPageObjects;




public class PageFactoryInitializer extends BaseMethod {
    public CBHomePageObjects cbHomePage() {
        return PageFactory.initElements(getWebDriver(), CBHomePageObjects.class);
    }

    public CBLoginPageObjects cbLoginPage() {
        return PageFactory.initElements(getWebDriver(), CBLoginPageObjects.class);
    }
}