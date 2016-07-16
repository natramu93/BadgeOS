package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePage {
	public WebDriver driver;
	public WebDriverWait sync;
	public By locator;
	public WebElement element;
		public UserHomePage(WebDriver Webdriver, WebDriverWait Webdriverwait)
		{
			super();
			this.driver=Webdriver;
			this.sync = Webdriverwait;
		}
		public WebElement Logout_Link(){
			locator = By.id("wp-logout");
			sync.until(ExpectedConditions.elementToBeClickable(locator));
			element = driver.findElement(locator);
			return element;
		}
}
